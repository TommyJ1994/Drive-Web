package drive

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import groovy.json.JsonSlurper

import java.text.SimpleDateFormat

/**
 * The API Controller is responsible for the handling of the interactions between the mobile app and the web app.
 */

@Transactional(readOnly = false)
class ApiController {

	// import vehicle and journey data manipulation services
	def vehicleService
	def journeyDataManipulationService

	// Data Response Formats
	static responseFormats = ['json', 'xml']

	// Allowed Methods to Interact with Resources
	static allowedMethods = [getVehicleInfo: "POST", addNewJourney: "POST", addNewVehicle: "POST", delete: "DELETE"]

	/**
	 * This method will return related data for a particular car
	 * @param vehicleID - the vehicle id of the car
	 */
	def getVehicleInfo(String vehicleID) {
		def data = request.JSON
		respond Vehicle.findByIdentifier(data.id)
	}

	/**
	 * This method adds a new driver and a vehicle to the database based on the data sent from the phone.
	 * @param properties - The Driver/Vehicle data sent from the phone in JSON format
	 */
	@Transactional
	def addNewVehicle(String properties)
	{
		// Collects the JSON data sent from the phone
		def data = request.JSON

		// Picking out Driver information and car data
		def dateOfBirth = data.dateOfBirth;
		def gender = data.gender;
		def country = data.country.toLowerCase();
		def carData = data.carData

		// Generate a new ID for the vehicle. This ID will be globally unique.
		String id = vehicleService.generateUniqueID();

		// Check if some of the key attributes are null
		if (dateOfBirth == null | gender == null | country == null | carData.model.name== null | carData.make.name == null | carData.year.year == null) {
			// Send 405 if any of the key data is null
			respond status: NOT_ACCEPTABLE
			return
		}

		// Create a new driver and save them to the database
		def driver = new Driver("gender": gender, "dateOfBirth": Date.parse( 'dd-MM-yyyy', dateOfBirth ), "country": country)

		// validate that the driver attributes obey the constraints set out in the domain class
		driver.validate()
		if (driver.hasErrors()) {
			respond status: NOT_ACCEPTABLE
			println driver.errors
			return
		}

		// save the driver to the database
		driver.save()

		// get the colour codes/names
		def colourCodes = vehicleService.getColourCodes(carData)
		def colourNames = vehicleService.getColourNames(carData)

		// Set to hold cars notable features list
		def features = vehicleService.getFeatures(carData)

		// create the new vehicle object
		def vehicle = new Vehicle("identifier": id,
		"driver": driver,
		"year": carData.year?.year,
		"make": carData.make?.name,
		"model": carData.model?.name,
		"engineConfiguration": carData.engine?.configuration,
		"compressionRatio": carData.engine?.compressionRatio,
		"engineDisplacement": carData.engine?.displacement,
		"engineSize": carData.engine?.size,
		"cylinders": carData.engine?.cylinder,
		"manufacturerEngineCode": carData.engine?.manufacturerEngineCode,
		"fuelType": carData.engine?.fuelType,
		"horsepower": carData.engine?.horsepower,
		"torque": carData.engine?.torque,
		"totalEngineValves": carData.engine?.totalValves,
		"transmissionType": carData.transmission?.transmissionType,
		"numberOfSpeeds": carData.transmission?.numberOfSpeeds,
		"drivenWheels": carData.options?.drivenWheels,
		"vehicleClass": carData.categories?.EPAClass,
		"vehicleStyle": carData.categories?.vehicleStyle,
		"numOfDoors": carData.numOfDoors,
		"mpgHighway": carData.MPG?.highway,
		"mpgCity": carData.MPG?.city,
		"newPrice": carData.price?.baseMSRP,
		"usedPrice": carData.price?.usedPrivateParty,
		"colourNames": colourNames,
		"colourCodes": colourCodes,
		"features": features)

		// validate that the vehicle attributes obey the constraints set out in the domain class
		vehicle.validate()
		if (vehicle.hasErrors()) {
			respond status: NOT_ACCEPTABLE
			println vehicle.errors
			return
		}

		// save the vehicle to the database
		vehicle.save()

		// New driver/vehicle created sucessfully
		respond status: CREATED, id: id
	}

	/**
	 * Receives journey data from the phone and adds it to the database 
	 * after the data manipulation has been carried out by the journey data manipulation service.
	 * Statistics are also generated using the statistics generator service.
	 */
	@Transactional
	def addNewJourney(String dataFromPhone)
	{
		def data = request.JSON

		// The ID of vehicle to which the journey data belongs
		def vehicle = Vehicle.findByIdentifier(data.vehicleID);

		// create new groovy date for the journey starting time using date data from the phone
		def startTime = new Date().copyWith(
				year: data.startTime.year,
				month: data.startTime.month,
				dayOfMonth: data.startTime.dayOfMonth,
				hourOfDay: data.startTime.hourOfDay,
				minute: data.startTime.minute,
				second: data.startTime.second)

		// create new groovy date for the journey end time using date data from the phone
		def endTime = new Date().copyWith(
				year: data.endTime.year,
				month: data.endTime.month,
				dayOfMonth: data.endTime.dayOfMonth,
				hourOfDay: data.endTime.hourOfDay,
				minute: data.endTime.minute,
				second: data.endTime.second)

		def journeyTimeLength = (endTime.getTime()-startTime.getTime())/1000;

		// The raw list of hex values from the car sensors
		def journeyData = data.journeyData;

		// Send the data to be processed by the manipulation service
		def result = journeyDataManipulationService.process(journeyData);

		// List of human readable sensor names
		def sensorNames = [
			"Calculated Engine Load",
			"Engine Coolant Temperature",
			"Fuel Pressure",
			"Intake Manifold Absolute Pressure",
			"Engine RPM",
			"Vehicle Speed",
			"Intake Air Temperature",
			"MAF Air Flow Rate",
			"Throttle Position",
			"Oxygen Sensor Voltage 1",
			"Oxygen Sensor Voltage 2",
			"Barometric Pressure",
			"Catalyst Temperature Bank 1 Sensor 1",
			"Catalyst Temperature Bank 2 Sensor 1",
			"Catalyst Temperature Bank 1 Sensor 2",
			"Catalyst Temperature Bank 2 Sensor 2",
			"Absolute Load Value",
			"Relative Throttle Position",
			"Ambient Air Temperature",
			"Commanded Throttle Actuator",
			"Relative Accelerator Pedal Position",
			"Engine Oil Temperature",
			"Fuel Injection Timing",
			"Engine Fuel Rate",
			"Drivers Demand Engine Torque",
			"Actual Engine Torque",
			"Engine Reference Torque"
		];

		// List of human readable sensor descriptions
		def sensorDescriptions = [
			"Indicates a percentage of peak available torque. Reaches 100% at wide open throttle at any altitude or RPM for both naturally aspirated and boosted engines.",
			"Engine coolant temperature derived from an engine coolant temperature sensor or a cylinder head temperature sensor.",
			"Indicates the fuel rail pressure at the engine referenced to atmosphere (gauge pressure).",
			"Indicates the manifold pressure derived from a Manifold Absolute Pressure sensor.",
			"The current engine revolutions per minute value.",
			"The vehicle road speed.",
			"The intake manifold air temperature.",
			"Airflow rate as measured by a vehicle MAF sensor or an equivalent source.",
			"The absolute throttle position (not the relative or learned) throttle position. Usually above 0% at idle and less than 100% at full throttle.",
			"Measures the proportion of oxygen (O2) in the gas or liquid being analysed for the first Oxygen sensor.",
			"Measures the proportion of oxygen (O2) in the gas or liquid being analysed for the second Oxygen sensor.",
			"Barometric pressure normally obtained from a dedicated barometric sensor.",
			"The catalyst substrate temperature in bank 1, sensor 1.",
			"The catalyst substrate temperature in bank 2, sensor 1.",
			"The catalyst substrate temperature in bank 1, sensor 2.",
			"The catalyst substrate temperature in bank 2, sensor 2.",
			"Indicates a percentage of peak available torque.",
			"The relative or learned throttle position.",
			"The ambient air temperature.",
			"The commanded throttle actuator.  0% fully closed and 100% fully open.",
			"Relative or learned pedal position.",
			"The engine oil temperature.",
			"The start of the mail fuel injection relative to Top Dead Center (TDC). Positive degrees indicate before TDC. Negative degrees indicate after TDC.",
			"The amount of fuel consumed by the engine per unit of time in liters per hour.",
			"The requested torque output of the engine by the driver.",
			"The calculated output torque of the engine.",
			"The engine reference torque value. This value does not change."
		];

		int count = 0;

		def sensorList = []

		// Get sensor value lists
		def topSpeed = result.statistics[0]
		def topRPM = result.statistics[1]
		def averageSpeed = result.statistics[2]
		def averageRPM = result.statistics[3]
		def heavyBrakingCount = result.statistics[4]
		def heavyAccelerationCount = result.statistics[5]
		def averagePercentageIdle = result.statistics[6]
		def averageGForce = result.statistics[7]
		def topAccelerationGforce = result.statistics[8]
		def topDecelerationGforce = result.statistics[9]
		def averagePercentageHighRPM = result.statistics[10]
		def averageEngineLoad = result.statistics[11]
		def averageMPG = result.statistics[12]
		def averageThrottlePosition = result.statistics[13]
		def averagePercentageCoasting = result.statistics[14]

		// Get sensor sample sizes
		def speedSamples = result.statistics[15]
		def rpmSamples = result.statistics[16]
		def idleSamples = result.statistics[17]
		def gForceSamples = result.statistics[18]
		def engineLoadSamples = result.statistics[19]
		def mpgSamples = result.statistics[20]
		def throttleSamples = result.statistics[21]

		def newJourney = new Journey("sensors": sensorList,
		"startTime": startTime,
		"endTime": endTime,
		"journeyTimeLength": journeyTimeLength,
		"topSpeed": topSpeed,
		"topRPM": topRPM,
		"averageSpeed": averageSpeed,
		"averageRPM": averageRPM,
		"heavyBrakingCount": heavyBrakingCount,
		"heavyAccelerationCount": heavyAccelerationCount,
		"averagePercentageIdle": averagePercentageIdle,
		"averageGForce": averageGForce,
		"topAccelerationGforce": topAccelerationGforce,
		"topDecelerationGforce": topDecelerationGforce,
		"averagePercentageHighRPM": averagePercentageHighRPM,
		"averageEngineLoad": averageEngineLoad,
		"averageMPG": averageMPG,
		"averageThrottlePosition": averageThrottlePosition,
		"averagePercentageCoasting": averagePercentageCoasting,
		"vehicle": vehicle
		);

		newJourney.validate();
		if (newJourney.hasErrors()) {
			respond status: NOT_ACCEPTABLE
			println newJourney.errors
			return
		}


		result.sensors.each
		{ sensorData ->

			String sensorName = sensorNames[count];
			String sensorDescription = sensorDescriptions[count];
			def points = [];

			def newSensor = new Sensor("name": sensorName, "description": sensorDescription, "points": [], "journey": newJourney);


			for(int i = 0; i < sensorData.size(); i++)
			{
				def point = new Point("value": sensorData[i], "sensor": newSensor)
				points << point
			}

			newSensor.points += points;

			newSensor.validate();
			if (newSensor.hasErrors()) {
				respond status: NOT_ACCEPTABLE
				println newSensor.errors
				return
			}

			sensorList.add(newSensor)
			count++
		}

		newJourney.sensors = sensorList;
		newJourney.save();

		// Update the overall statistics for a vehicle

		// update the overall driving time
		vehicle.overallStatistics.totalTimeLength += journeyTimeLength
		// Update the top speed value for the vehicle if a new top speed was reached
		vehicle.overallStatistics.topSpeed = (topSpeed > vehicle.overallStatistics.topSpeed) ? topSpeed : vehicle.overallStatistics.topSpeed
		// Update the top rpm value for the vehicle if a new top rpm was reached
		vehicle.overallStatistics.topRPM = (topRPM > vehicle.overallStatistics.topRPM) ? topRPM : vehicle.overallStatistics.topRPM
		// Update the average speed value for the vehicle
		vehicle.overallStatistics.averageSpeed = ((vehicle.overallStatistics.averageSpeed * vehicle.overallStatistics.speedSamples) + (averageSpeed * speedSamples)) / (vehicle.overallStatistics.speedSamples + speedSamples)
		// Update the average rpm value for the vehicle
		vehicle.overallStatistics.averageRPM = ((vehicle.overallStatistics.averageRPM * vehicle.overallStatistics.rpmSamples) + (averageRPM * rpmSamples)) / (vehicle.overallStatistics.rpmSamples + rpmSamples)
		// Update the heavy braking count for the vehicle
		vehicle.overallStatistics.heavyBrakingCount += heavyBrakingCount
		// Update the heavy acceleration count for the vehicle
		vehicle.overallStatistics.heavyAccelerationCount += heavyAccelerationCount
		// Update the average percentage idle value for the vehicle
		vehicle.overallStatistics.averagePercentageIdle = ((vehicle.overallStatistics.averagePercentageIdle * vehicle.overallStatistics.idleSamples) + (averagePercentageIdle * idleSamples)) / (vehicle.overallStatistics.idleSamples + idleSamples)
		// Update the average G Force value for the vehicle
		vehicle.overallStatistics.averageGForce = ((vehicle.overallStatistics.averageGForce * vehicle.overallStatistics.gForceSamples) + (averageGForce * gForceSamples)) / (vehicle.overallStatistics.gForceSamples + gForceSamples)
		// Update the top acceleration g force value for the vehicle if a top acceleration g force was reached
		vehicle.overallStatistics.topAccelerationGforce = (topAccelerationGforce > vehicle.overallStatistics.topAccelerationGforce) ? topAccelerationGforce : vehicle.overallStatistics.topAccelerationGforce
		// Update the top deceleration g force value for the vehicle if a top deceleration g force was reached
		vehicle.overallStatistics.topDecelerationGforce = (topDecelerationGforce > vehicle.overallStatistics.topDecelerationGforce) ? topDecelerationGforce : vehicle.overallStatistics.topDecelerationGforce
		// Update the average percentage high RPM value for the vehicle
		vehicle.overallStatistics.averagePercentageHighRPM = ((vehicle.overallStatistics.averagePercentageHighRPM * vehicle.overallStatistics.rpmSamples) + (averagePercentageHighRPM * rpmSamples)) / (vehicle.overallStatistics.rpmSamples + rpmSamples)
		// Update the average engine load value for the vehicle
		vehicle.overallStatistics.averageEngineLoad = ((vehicle.overallStatistics.averageEngineLoad * vehicle.overallStatistics.engineLoadSamples) + (averageEngineLoad * engineLoadSamples)) / (vehicle.overallStatistics.engineLoadSamples + engineLoadSamples)
		// Update the average mpg value for the vehicle
		vehicle.overallStatistics.averageMPG = ((vehicle.overallStatistics.averageMPG * vehicle.overallStatistics.mpgSamples) + (averageMPG * mpgSamples)) / (vehicle.overallStatistics.mpgSamples + mpgSamples)
		// Update the average throttle position value for the vehicle
		vehicle.overallStatistics.averageThrottlePosition = ((vehicle.overallStatistics.averageThrottlePosition * vehicle.overallStatistics.throttleSamples) + (averageThrottlePosition * throttleSamples)) / (vehicle.overallStatistics.throttleSamples + throttleSamples)
		// Update the average percentage coasting value for the vehicle
		vehicle.overallStatistics.averagePercentageCoasting = ((vehicle.overallStatistics.averagePercentageCoasting * vehicle.overallStatistics.speedSamples) + (averagePercentageCoasting * speedSamples)) / (vehicle.overallStatistics.speedSamples + speedSamples)

		// Send 200 OK, all data is valid and saved to DB successfully.
		respond status: CREATED
	}

	/**
	 * Delete a vehicle 
	 */
	@Transactional
	def delete(Api apiInstance) {

		if (apiInstance == null) {
			render status: NOT_FOUND
			return
		}

		apiInstance.delete flush:true
		render status: NO_CONTENT
	}
}
