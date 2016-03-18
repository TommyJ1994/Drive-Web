package drive



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import java.util.Formatter.DateTime

@Transactional(readOnly = true)
class JourneyController {

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Journey.list(params), model:[journeyInstanceCount: Journey.count()]
	}

	def show(Journey journeyInstance) {
		
		def calculatedEngineLoad = [:]
		def engineCoolantTemperature = [:];
		def fuelPressure = [:];
		def intakeManifoldAbsolutePressure = [:];
		def engineRPM = [:];
		def vehicleSpeed = [:];
		def intakeAirTemperature = [:];
		def mafAirFlowRate = [:];
		def throttlePosition = [:];
		def oxygenSensorVoltage1 = [:];
		def oxygenSensorVoltage2 = [:];
		def barometricPressure = [:];
		def catalystTemperatureBank1Sensor1 = [:];
		def catalystTemperatureBank2Sensor1 = [:];
		def catalystTemperatureBank1Sensor2 = [:];
		def catalystTemperatureBank2Sensor2 = [:];
		def absoluteloadValue = [:];
		def relativeThrottlePosition = [:];
		def ambientAirTemperature = [:];
		def commandedThrottleActuator = [:];
		def relativeAcceleratorPedalPosition = [:];
		def engineOilTemperature = [:];
		def fuelInjectionTiming = [:];
		def engineFuelRate = [:];
		def driversDemandEngineTorque = [:];
		def actualEngineTorque = [:];
		def engineReferenceTorque = [:];

		for(int i = 0; i < journeyInstance.sensors.size();i++) {
			
			def points = []
			
			for(int j = 0; j < journeyInstance.sensors[i].points.size();j++)
			{
				def pointList = journeyInstance.sensors[i].points.sort{it.index}
				points << [journeyInstance.sensors[i].name, pointList[j].value]
			}
			
			
			def currentSensorData = ["name":journeyInstance.sensors[i].name, "description":journeyInstance.sensors[i].description, "points": points]
			
			switch (journeyInstance.sensors[i].name) {
				// Calculated engine load value
				case "Calculated Engine Load":
					calculatedEngineLoad = currentSensorData
					break
				// Engine Coolant Temperature
				case "Engine Coolant Temperature":
					engineCoolantTemperature = currentSensorData
					break
				// Fuel Pressure
				case "Fuel Pressure":
					fuelPressure = currentSensorData
					break
				// Intake Manifold Absolute Pressure
				case "Intake Manifold Absolute Pressure":
					intakeManifoldAbsolutePressure = currentSensorData
					break
				// Engine RPM
				case "Engine RPM":
					engineRPM = currentSensorData
					break
				// Vehicle Speed
				case "Vehicle Speed":
					vehicleSpeed = currentSensorData
					break
				// Intake Air Temperature
				case "Intake Air Temperature":
					intakeAirTemperature = currentSensorData
					break
				// MAF Air Flow Rate
				case "MAF Air Flow Rate":
					mafAirFlowRate = currentSensorData
					break
				// Throttle Position
				case "Throttle Position":
					throttlePosition = currentSensorData
					break
				// Oxygen Sensor 1 Voltage
				case "Oxygen Sensor Voltage 1":
					oxygenSensorVoltage1 = currentSensorData
					break
				// Oxygen Sensor 2 Voltage
				case "Oxygen Sensor Voltage 2":
					oxygenSensorVoltage2 = currentSensorData
					break
				// Barometric Pressure
				case "Barometric Pressure":
					barometricPressure = currentSensorData
					break
				// Catalyst Temperature Bank 1 Sensor 1
				case "Catalyst Temperature Bank 1 Sensor 1":
					catalystTemperatureBank1Sensor1 = currentSensorData
					break
				// Catalyst Temperature Bank 1 Sensor 2
				case "Catalyst Temperature Bank 1 Sensor 2":
					catalystTemperatureBank1Sensor2 = currentSensorData
					break
				// Catalyst Temperature Bank 2 Sensor 1
				case "Catalyst Temperature Bank 2 Sensor 1":
					catalystTemperatureBank2Sensor1 = currentSensorData
					break
				// Catalyst Temperature Bank 2 Sensor 2
				case "Catalyst Temperature Bank 2 Sensor 2":
					catalystTemperatureBank2Sensor2 = currentSensorData
					break
				// Absolute load value
				case "Absolute Load Value":
					absoluteloadValue = currentSensorData
					break
				// Relative Throttle Position
				case "Relative Throttle Position":
					relativeThrottlePosition = currentSensorData
					break
				// Ambient Air Temperature
				case "Ambient Air Temperature":
					ambientAirTemperature = currentSensorData
					break
				// Commanded Throttle Actuator
				case "Commanded Throttle Actuator":
					commandedThrottleActuator = currentSensorData
					break
				// Relative Accelerator Pedal Position
				case "Relative Accelerator Pedal Position":
					relativeAcceleratorPedalPosition = currentSensorData
					break
				// Engine Oil Temperature
				case "Engine Oil Temperature":
					engineOilTemperature = currentSensorData
					break
				// Fuel Injection Timing
				case "Fuel Injection Timing":
					fuelInjectionTiming = currentSensorData
					break
				// Engine Fuel Rate
				case "Engine Fuel Rate":
					engineFuelRate = currentSensorData
					break
				// Drivers Demand Engine Torque
				case "Drivers Demand Engine Torque":
					driversDemandEngineTorque = currentSensorData
					break
				// Actual Engine Torque
				case "Actual Engine Torque":
					actualEngineTorque = currentSensorData
					break
				// Engine Reference Torque
				case "Engine Reference Torque":
					engineReferenceTorque = currentSensorData
					break
				default:
					println ""
			}
		}
		
		def engineDataSensors = [calculatedEngineLoad, throttlePosition, vehicleSpeed]
		def smallestDataset = engineDataSensors[0];
		
		for(int t = 0; t < engineDataSensors.size();t++)
		{
			if(engineDataSensors[t].points.size() < smallestDataset.points.size())
			{
				smallestDataset = engineDataSensors[t];
			}
		}
		
		def engineData = []
		
		for(int x = 0; x < smallestDataset.points.size();x++)
		{
			def speedPoint = vehicleSpeed.points[x][1]
			def engineLoadPoint = calculatedEngineLoad.points[x][1]
			def throttlePositionPoint = throttlePosition.points[x][1]
			engineData << ["Speed (KPH)", x, 200, speedPoint]
			engineData << ["Engine Load (%)", x, 600, engineLoadPoint]
			engineData << ["Throttle Position (%)", x, 800, throttlePositionPoint]
		}
			
			
			
			def lambdaData = []
			
			if(oxygenSensorVoltage1.points.size() > oxygenSensorVoltage2.points.size())
			{
				for(int x = 0; x < oxygenSensorVoltage2.points.size();x++)
				{
					def oxygen1Point = oxygenSensorVoltage1.points[x][1]
					def oxygen2Point = oxygenSensorVoltage2.points[x][1]

					lambdaData << ["Point", oxygen1Point, oxygen2Point]
				}
			}
			else
			{
				for(int x = 0; x < oxygenSensorVoltage1.points.size();x++)
				{
					def oxygen1Point = oxygenSensorVoltage1.points[x][1]
					def oxygen2Point = oxygenSensorVoltage2.points[x][1]

					lambdaData << ["Point", oxygen1Point, oxygen2Point]
				}
			}
						
		respond journeyInstance, model:[calculatedEngineLoad : calculatedEngineLoad,
		engineCoolantTemperature: engineCoolantTemperature,
		fuelPressure : fuelPressure,
		intakeManifoldAbsolutePressure : intakeManifoldAbsolutePressure,
		engineRPM : engineRPM,
		vehicleSpeed : vehicleSpeed,
		intakeAirTemperature : intakeAirTemperature,
		mafAirFlowRate : mafAirFlowRate,
		throttlePosition : throttlePosition,
		oxygenSensorVoltage1 : oxygenSensorVoltage1,
		oxygenSensorVoltage2 : oxygenSensorVoltage2,
		barometricPressure : barometricPressure,
		catalystTemperatureBank1Sensor1 : catalystTemperatureBank1Sensor1,
		catalystTemperatureBank2Sensor1 : catalystTemperatureBank2Sensor1,
		catalystTemperatureBank1Sensor2 : catalystTemperatureBank1Sensor2,
		catalystTemperatureBank2Sensor2 : catalystTemperatureBank2Sensor2,
		absoluteloadValue : absoluteloadValue,
		relativeThrottlePosition : relativeThrottlePosition,
		ambientAirTemperature : ambientAirTemperature,
		commandedThrottleActuator : commandedThrottleActuator,
		relativeAcceleratorPedalPosition : relativeAcceleratorPedalPosition,
		engineOilTemperature : engineOilTemperature,
		fuelInjectionTiming : fuelInjectionTiming,
		engineFuelRate : engineFuelRate,
		driversDemandEngineTorque : driversDemandEngineTorque,
		actualEngineTorque : actualEngineTorque,
		engineReferenceTorque : engineReferenceTorque,
		engineData: engineData,
		lambdaData: lambdaData]
	}

	def create() {
		respond new Journey(params)
	}

	@Transactional
	def save(Journey journeyInstance) {
		if (journeyInstance == null) {
			notFound()
			return
		}

		if (journeyInstance.hasErrors()) {
			respond journeyInstance.errors, view:'create'
			return
		}

		journeyInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [
					message(code: 'journey.label', default: 'Journey'),
					journeyInstance.id
				])
				redirect journeyInstance
			}
			'*' { respond journeyInstance, [status: CREATED] }
		}
	}

	def edit(Journey journeyInstance) {
		respond journeyInstance
	}

	@Transactional
	def update(Journey journeyInstance) {
		if (journeyInstance == null) {
			notFound()
			return
		}

		if (journeyInstance.hasErrors()) {
			respond journeyInstance.errors, view:'edit'
			return
		}

		journeyInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'Journey.label', default: 'Journey'),
					journeyInstance.id
				])
				redirect journeyInstance
			}
			'*'{ respond journeyInstance, [status: OK] }
		}
	}

	@Transactional
	def delete(Journey journeyInstance) {

		if (journeyInstance == null) {
			notFound()
			return
		}

		journeyInstance.delete flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'Journey.label', default: 'Journey'),
					journeyInstance.id
				])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}

	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'journey.label', default: 'Journey'),
					params.id
				])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
