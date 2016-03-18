package drive
import grails.transaction.Transactional

/**
 * This service will convert the data from a hex format to a human readable / true value format.
 */

@Transactional
class JourneyDataManipulationService {

	def statisticsGeneratorService


	/**
	 * This method will receive the journey data from the API controller
	 */
	def process(def data) {
		
		// The following will hold the list of recorded points on a journey for each sensor.
	
		def calculatedEngineLoad = [];
		def engineCoolantTemperature = [];
		def fuelPressure = [];
		def intakeManifoldAbsolutePressure = [];
		def engineRPM = [];
		def vehicleSpeed = [];
		def intakeAirTemperature = [];
		def mafAirFlowRate = [];
		def throttlePosition = [];
		def oxygenSensorVoltage1 = [];
		def oxygenSensorVoltage2 = [];
		def barometricPressure = [];
		def catalystTemperatureBank1Sensor1 = [];
		def catalystTemperatureBank2Sensor1 = [];
		def catalystTemperatureBank1Sensor2 = [];
		def catalystTemperatureBank2Sensor2 = [];
		def absoluteloadValue = [];
		def relativeThrottlePosition = [];
		def ambientAirTemperature = [];
		def commandedThrottleActuator = [];
		def relativeAcceleratorPedalPosition = [];
		def engineOilTemperature = [];
		def fuelInjectionTiming = [];
		def engineFuelRate = [];
		def driversDemandEngineTorque = [];
		def actualEngineTorque = [];
		def engineReferenceTorque = [];
	
		// statistics fields
		def topSpeed = 0
		def topRPM = 0
		def averageSpeed = 0
		def averageRPM = 0
		def heavyBrakingCount = 0
		def heavyAccelerationCount = 0
		def averagePercentageIdle  = 0
		def averageGForce = 0
		def topAccelerationGforce = 0
		def topDecelerationGforce = 0
		def averagePercentageHighRPM = 0
		def averageEngineLoad = 0
		def averageMPG = 0
		def averageThrottlePosition = 0
		def averagePercentageCoasting = 0
	
		// sampling size fields
		def speedSamples = 0
		def rpmSamples = 0
		def idleSamples = 0
		def gForceSamples = 0
		def engineLoadSamples = 0
		def mpgSamples = 0
		def throttleSamples = 0
		
		// sort the list of points into their sensor list
		for(int i = 0; i < data.size(); i++)
		{
			def point = data[i]
			
			// The first 2 bytes contain the sensor identifier, the rest is the data
			// Check the identifier matches in the switch statement, then just pass on the data.
			
			def sensorIdentifier = point.substring(0, 4)
			switch (sensorIdentifier) {
				// Calculated engine load value
				case "4104":
					calculatedEngineLoad << point.substring(point.length() - 2)
					break
				// Engine Coolant Temperature
				case "4105":
					engineCoolantTemperature << point.substring(point.length() - 2)
					break
				// Fuel Pressure
				case "410A":
					fuelPressure << point.substring(point.length() - 2)
					break
				// Intake Manifold Absolute Pressure
				case "410B":
					intakeManifoldAbsolutePressure << point.substring(point.length() - 2)
					break
				// Engine RPM
				case "410C":
					engineRPM << point.substring(point.length() - 4)
					break
				// Vehicle Speed
				case "410D":
					vehicleSpeed << point.substring(point.length() - 2)
					break
				// Intake Air Temperature
				case "410F":
					intakeAirTemperature << point.substring(point.length() - 2)
					break
				// MAF Air Flow Rate
				case "4110":
					mafAirFlowRate << point.substring(point.length() - 4)
					break
				// Throttle Position
				case "4111":
					throttlePosition << point.substring(point.length() - 2)
					break
				// Oxygen Sensor 1 Voltage
				case "4114":
					oxygenSensorVoltage1 << point.substring(point.length() - 4)
					break
				// Oxygen Sensor 2 Voltage
				case "4115":
					oxygenSensorVoltage2 << point.substring(point.length() - 4)
					break
				// Barometric Pressure
				case "4133":
					barometricPressure << point.substring(point.length() - 2)
					break
				// Catalyst Temperature Bank 1 Sensor 1
				case "413C":
					catalystTemperatureBank1Sensor1 << point.substring(point.length() - 4)
					break
				// Catalyst Temperature Bank 1 Sensor 2
				case "413D":
					catalystTemperatureBank1Sensor2 << point.substring(point.length() - 4)
					break
				// Catalyst Temperature Bank 2 Sensor 1
				case "413E":
					catalystTemperatureBank2Sensor1 << point.substring(point.length() - 4)
					break
				// Catalyst Temperature Bank 2 Sensor 2
				case "413F":
					catalystTemperatureBank2Sensor2 << point.substring(point.length() - 4)
					break
				// Absolute load value
				case "4143":
					absoluteloadValue << point.substring(point.length() - 4)
					break
				// Relative Throttle Position
				case "4145":
					relativeThrottlePosition << point.substring(point.length() - 2)
					break
				// Ambient Air Temperature
				case "4146":
					ambientAirTemperature << point.substring(point.length() - 2)
					break
				// Commanded Throttle Actuator
				case "414C":
					commandedThrottleActuator << point.substring(point.length() - 2)
					break
				// Relative Accelerator Pedal Position
				case "415A":
					relativeAcceleratorPedalPosition << point.substring(point.length() - 2)
					break
				// Engine Oil Temperature
				case "415C":
					engineOilTemperature << point.substring(point.length() - 2)
					break
				// Fuel Injection Timing
				case "415D":
					fuelInjectionTiming << point.substring(point.length() - 4)
					break
				// Engine Fuel Rate
				case "415E":
					engineFuelRate << point.substring(point.length() - 4)
					break
				// Drivers Demand Engine Torque
				case "4161":
					driversDemandEngineTorque << point.substring(point.length() - 2)
					break
				// Actual Engine Torque
				case "4162":
					actualEngineTorque << point.substring(point.length() - 2)
					break
				// Engine Reference Torque
				case "4163":
					engineReferenceTorque << point.substring(point.length() - 4)
					break
				default:
					println ""
			}
		}		
		
		// Convert the hex based data list of each sensor into its true decimal form

		def calculatedEngineLoadDecoded = decodeCalculatedEngineLoadPoints(calculatedEngineLoad)
		def engineCoolantTemperatureDecoded = decodeEngineCoolantTemperature(engineCoolantTemperature)
		def fuelPressureDecoded = decodeFuelPressure(fuelPressure)
		def intakeManifoldAbsolutePressureDecoded = decodeIntakeManifoldAbsolutePressure(intakeManifoldAbsolutePressure)
		def engineRPMDecoded = decodeEngineRPM(engineRPM)
		def vehicleSpeedDecoded = decodeVehicleSpeed(vehicleSpeed)
		def intakeAirTemperatureDecoded = decodeIntakeAirTemperature(intakeAirTemperature)
		def mafAirFlowRateDecoded = decodeMafAirFlowRate(mafAirFlowRate)
		def throttlePositionDecoded = decodeThrottlePosition(throttlePosition)
		def oxygenSensorVoltage1Decoded = decodeOxygenSensorVoltage(oxygenSensorVoltage1)
		def oxygenSensorVoltage2Decoded = decodeOxygenSensorVoltage(oxygenSensorVoltage2)
		def barometricPressureDecoded = decodeBarometricPressure(barometricPressure)
		def catalystTemperatureBank1Sensor1Decoded = decodeCatalystTemperature(catalystTemperatureBank1Sensor1)
		def catalystTemperatureBank2Sensor1Decoded = decodeCatalystTemperature(catalystTemperatureBank2Sensor1)
		def catalystTemperatureBank1Sensor2Decoded = decodeCatalystTemperature(catalystTemperatureBank1Sensor2)
		def catalystTemperatureBank2Sensor2Decoded = decodeCatalystTemperature(catalystTemperatureBank2Sensor2)
		def absoluteloadValueDecoded = decodeAbsoluteloadValue(absoluteloadValue)
		def relativeThrottlePositionDecoded = decodeRelativeThrottlePosition(relativeThrottlePosition)
		def ambientAirTemperatureDecoded = decodeAmbientAirTemperature(ambientAirTemperature)
		def commandedThrottleActuatorDecoded = decodeCommandedThrottleActuator(commandedThrottleActuator)
		def relativeAcceleratorPedalPositionDecoded = decodeRelativeAcceleratorPedalPosition(relativeAcceleratorPedalPosition)
		def engineOilTemperatureDecoded = decodeEngineOilTemperature(engineOilTemperature)
		def fuelInjectionTimingDecoded = decodeFuelInjectionTiming(fuelInjectionTiming)
		def engineFuelRateDecoded = decodeEngineFuelRate(engineFuelRate)
		def driversDemandEngineTorqueDecoded = decodeDriversDemandEngineTorque(driversDemandEngineTorque)
		def actualEngineTorqueDecoded = decodeActualEngineTorque(actualEngineTorque)
		def engineReferenceTorqueDecoded = decodeEngineReferenceTorque(engineReferenceTorque)


		// Generate statistics for the journey
		
		// Vehicle speed related statistics
		if(vehicleSpeedDecoded.size() > 0)
		{
			speedSamples = vehicleSpeedDecoded.size()
			idleSamples = vehicleSpeedDecoded.size()
			gForceSamples = vehicleSpeedDecoded.size()
			topSpeed = statisticsGeneratorService.getTopSpeed(vehicleSpeedDecoded)
			averageSpeed = statisticsGeneratorService.getAverageSpeed(vehicleSpeedDecoded)
			heavyBrakingCount = statisticsGeneratorService.getHeavyBrakingCount(vehicleSpeedDecoded)
			heavyAccelerationCount = statisticsGeneratorService.getHeavyAccelerationCount(vehicleSpeedDecoded)
			averagePercentageIdle = statisticsGeneratorService.getAveragePercentageIdle(vehicleSpeedDecoded)
			averageGForce = statisticsGeneratorService.getAverageGForce(vehicleSpeedDecoded)
			topAccelerationGforce = statisticsGeneratorService.getTopAccelerationGforce(vehicleSpeedDecoded)
			topDecelerationGforce = statisticsGeneratorService.getTopDecelerationGforce(vehicleSpeedDecoded)
		}

		// Engine RPM related statistics
		if(engineRPMDecoded.size() > 0)
		{
			rpmSamples = engineRPMDecoded.size()
			topRPM = statisticsGeneratorService.getTopRPM(engineRPMDecoded)
			averageRPM = statisticsGeneratorService.getAverageRPM(engineRPMDecoded)
			averagePercentageHighRPM = statisticsGeneratorService.getAveragePercentageHighRPM(engineRPMDecoded)
		}

		// Calculated engine load related statistics
		if(calculatedEngineLoadDecoded.size() > 0)
		{
			engineLoadSamples = calculatedEngineLoadDecoded.size()
			averageEngineLoad = statisticsGeneratorService.getAverageEngineLoad(calculatedEngineLoadDecoded)
		}

		// Engine fuel rate related statistics
		if(engineFuelRateDecoded.size() > 0)
		{
			mpgSamples = engineFuelRateDecoded.size()
			averageMPG = statisticsGeneratorService.getAverageMPG(engineFuelRateDecoded)
		}

		// Throttle position related statistics
		if(throttlePositionDecoded.size() > 0)
		{
			averageThrottlePosition = statisticsGeneratorService.getAverageThrottlePosition(throttlePositionDecoded)
		}

		// Coasting related statistics
		if(throttlePositionDecoded.size() > 0 && vehicleSpeedDecoded.size() > 0)
		{
			throttleSamples = throttlePosition.size()
			averagePercentageCoasting = statisticsGeneratorService.getAveragePercentageCoasting(vehicleSpeedDecoded, throttlePositionDecoded)
		}

		
		// The list of all sensors.
		def sensors = [
			calculatedEngineLoadDecoded,
			engineCoolantTemperatureDecoded,
			fuelPressureDecoded,
			intakeManifoldAbsolutePressureDecoded,
			engineRPMDecoded,
			vehicleSpeedDecoded,
			intakeAirTemperatureDecoded,
			mafAirFlowRateDecoded,
			throttlePositionDecoded,
			oxygenSensorVoltage1Decoded,
			oxygenSensorVoltage2Decoded,
			barometricPressureDecoded,
			catalystTemperatureBank1Sensor1Decoded,
			catalystTemperatureBank2Sensor1Decoded,
			catalystTemperatureBank1Sensor2Decoded,
			catalystTemperatureBank2Sensor2Decoded,
			absoluteloadValueDecoded,
			relativeThrottlePositionDecoded,
			ambientAirTemperatureDecoded,
			commandedThrottleActuatorDecoded,
			relativeAcceleratorPedalPositionDecoded,
			engineOilTemperatureDecoded,
			fuelInjectionTimingDecoded,
			engineFuelRateDecoded,
			driversDemandEngineTorqueDecoded,
			actualEngineTorqueDecoded,
			engineReferenceTorqueDecoded
		]
		

		// The lists of all statistics + sampling sizes
		def statistics = [
			topSpeed,
			topRPM,
			averageSpeed,
			averageRPM,
			heavyBrakingCount,
			heavyAccelerationCount,
			averagePercentageIdle,
			averageGForce,
			topAccelerationGforce,
			topDecelerationGforce,
			averagePercentageHighRPM,
			averageEngineLoad,
			averageMPG,
			averageThrottlePosition,
			averagePercentageCoasting,
			speedSamples,
			rpmSamples,
			idleSamples,
			gForceSamples,
			engineLoadSamples,
			mpgSamples,
			throttleSamples
		]
		
		
		
		
		// return data to the controller for validation and storage in the database
		return ["sensors": sensors, "statistics": statistics]
	}
	
	/**
	 * Conversion for the calculated engine load.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeCalculatedEngineLoadPoints(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = (a*100)/255
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	
	/**
	 * Conversion for the engine coolant temperature.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeEngineCoolantTemperature(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a - 40
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the fuel pressure.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeFuelPressure(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a * 3
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the Intake Manifold Absolute Pressure.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeIntakeManifoldAbsolutePressure(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the Engine RPM.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeEngineRPM(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i].substring(hexList[i].length()-4, hexList[i].length()-2),16);
				def b = Integer.parseInt(hexList[i].substring(hexList[i].length() - 2),16);
				def result = ((a*256)+b)/4
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the vehicle engine speed.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeVehicleSpeed(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the throttle position.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeThrottlePosition(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a*100/255
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the MAF air flow rate.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeMafAirFlowRate(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i].substring(hexList[i].length()-4, hexList[i].length()-2),16);
				def b = Integer.parseInt(hexList[i].substring(hexList[i].length() - 2),16);
				def result = ((a*256)+b) / 100
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the intake air temperature sensor.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeIntakeAirTemperature(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a - 40
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the oxygen sensors.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeOxygenSensorVoltage(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def b = Integer.parseInt(hexList[i].substring(hexList[i].length() - 2),16);

				// The first byte is the voltage, the second is the percentage.
				b = (double)Math.round(((b - 128) * 100/128) * 10000d) / 10000d

				// The values will be stored in the format: VoltageValue-PercentageValue
				def result = b
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the barometric pressure.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeBarometricPressure(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for Catalyst Temperature Bank X, Sensor X.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeCatalystTemperature(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i].substring(hexList[i].length()-4, hexList[i].length()-2),16);
				def b = Integer.parseInt(hexList[i].substring(hexList[i].length() - 2),16);
				def result = ((a*256)+b)/10 - 40
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the absolute load value.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeAbsoluteloadValue(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i].substring(hexList[i].length()-4, hexList[i].length()-2),16);
				def b = Integer.parseInt(hexList[i].substring(hexList[i].length() - 2),16);
				def result = ((a*256)+b)*100/255
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the throttle position.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeAmbientAirTemperature(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a*100/255
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the ambient air temperature.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeRelativeThrottlePosition(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a-40
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the Commanded throttle actuator.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeCommandedThrottleActuator(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a*100/255
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the Relative accelerator pedal position.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeRelativeAcceleratorPedalPosition(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a*100/255
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the Engine oil temperature.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeEngineOilTemperature(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a-40
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the Fuel injection timing.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeFuelInjectionTiming(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i].substring(hexList[i].length()-4, hexList[i].length()-2),16);
				def b = Integer.parseInt(hexList[i].substring(hexList[i].length() - 2),16);
				def result = (((a*256)+b)-26880)/128
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the Engine fuel rate.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeEngineFuelRate(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i].substring(hexList[i].length()-4, hexList[i].length()-2),16);
				def b = Integer.parseInt(hexList[i].substring(hexList[i].length() - 2),16);
				def result = ((a*256)+b)*0.05
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the Driver's demand engine - percent torque.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeDriversDemandEngineTorque(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a-125
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	/**
	 * Conversion for the Actual engine - percent torque.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeActualEngineTorque(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i],16);
				def result = a-125
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}


	/**
	 * Conversion for the Engine reference torque.
	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value.
	 * @param hexList - the list of hex values to decode and enter into the mathematical equation.
	 */
	def decodeEngineReferenceTorque(def hexList)
	{
		def decodedList = []

		if(hexList != null && hexList.size > 0)
		{
			for(int i = 0; i < hexList.size(); i++)
			{
				def a = Integer.parseInt(hexList[i].substring(hexList[i].length()-4, hexList[i].length()-2),16);
				def b = Integer.parseInt(hexList[i].substring(hexList[i].length() - 2),16);
				def result = a*256+b
				result = (double)Math.round(result * 10000d) / 10000d
				decodedList << result
			}
		}
		return decodedList
	}

	
}

