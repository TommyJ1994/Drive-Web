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
    static allowedMethods = [addNewJourney: "POST", addNewVehicle: "POST", delete: "DELETE"]

	/**
	 * 
	 * @param max - the maximum number of items to return
 	*/
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Api.list(params), [status: OK]
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
		def country = data.country;
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
		def sensorNames = ["Calculated Engine Load",
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
		def sensorDescriptions = ["Indicates a percentage of peak available torque. Reaches 100% at wide open throttle at any altitude or RPM for both naturally aspirated and boosted engines.",
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
		
		def newJourney = new Journey("sensors": sensorList,
			"startTime": startTime,
			"endTime": endTime,
			"journeyTimeLength": journeyTimeLength,
			"topSpeed": result.statistics[0],
			"topRPM": result.statistics[1],
			"averageSpeed": result.statistics[2],
			"averageRPM": result.statistics[3],
			"heavyAccelerationCount": result.statistics[4],
			"heavyBrakingCount": result.statistics[5],
			"vehicle": vehicle
			);
		
		newJourney.validate();
		if (newJourney.hasErrors()) {
			respond status: NOT_ACCEPTABLE
			println newJourney.errors
			return
		}
					
				
			result.sensors.each
			{
				sensorData ->
								
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
