package drive

import grails.transaction.Transactional

/**
 * This service will convert the data from a hex format to a human readable / true value format.
 */

@Transactional
class JourneyDataManipulationService {
	
	def calculatedEngineLoad, 
	engineCoolantTemperature, 
	fuelPressure,
	intakeManifoldAbsolutePressure,
	engineRPM,
	vehicleSpeed,
	intakeAirTemperature,
	mafAirFlowRate,
	throttlePosition,
	oxygenSensorVoltage1,
	oxygenSensorVoltage2,
	barometricPressure,
	catalystTemperatureBank1Sensor1,
	catalystTemperatureBank2Sensor1,
	catalystTemperatureBank1Sensor2,
	catalystTemperatureBank2Sensor2,
	absoluteloadValue,
	relativeThrottlePosition,
	ambientAirTemperature,
	commandedThrottleActuator,
	relativeAcceleratorPedalPosition,
	engineOilTemperature,
	fuelInjectionTiming,
	engineFuelRate,
	driversDemandEngineTorque,
	actualEngineTorque,
	engineReferenceTorque = [:];
 
 	/**
	 * This method will receive the journey data from the API controller
 	*/
    def process() {
		
		def data = ["410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410582","410F3C","413C0000","413D0000","413E0000","413F0000","414641","415C87","411133","414500","414C00","415A00","41140000","41150000","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","411133","414500","414C00","415A00","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","411133","414500","414C00","415A00","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","411133","414500","414C00","415A00","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410582","410F3C","413C0000","413D0000","413E0000","413F0000","414641","415C87","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","411133","414500","414C00","415A00","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","411133","414500","414C00","415A00","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","411133","414500","414C00","415A00","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF","416300F0","410A32","415D0000","415E0091","413365","410B64","41101F40","41140000","41150000","41140000","41150000","410582","410F3C","413C0000","413D0000","413E0000","413F0000","414641","415C87","410C0FA0","41047F","410D32","4143007F","4161D7","4162AF"]		
		
		// sort the list of points into their sensor list
		for(int i = 0; i < data.size(); i++)
		{
			sort(data[i])
		}
		
		transformData(calculatedEngineLoad)
		transformData(engineCoolantTemperature)
		transformData(fuelPressure)
		transformData(intakeManifoldAbsolutePressure)
		transformData(engineRPM)
		transformData(vehicleSpeed)
		transformData(intakeAirTemperature)
		transformData(mafAirFlowRate)
		transformData(throttlePosition)
		transformData(oxygenSensorVoltage1)
		transformData(oxygenSensorVoltage2)
		transformData(barometricPressure)
		transformData(catalystTemperatureBank1Sensor1)
		transformData(catalystTemperatureBank2Sensor1)
		transformData(catalystTemperatureBank1Sensor2)
		transformData(catalystTemperatureBank2Sensor2)
		transformData(absoluteloadValue)
		transformData(relativeThrottlePosition)
		transformData(ambientAirTemperature)
		transformData(commandedThrottleActuator)
		transformData(relativeAcceleratorPedalPosition)
		transformData(engineOilTemperature)
		transformData(fuelInjectionTiming)
		transformData(engineFuelRate)
		transformData(driversDemandEngineTorque)
		transformData(actualEngineTorque)
		transformData(engineReferenceTorque)
		
		def journey = new Journey(getCalculatedEngineLoad(), getEngineCoolantTemperature())
		return journey // do the validation + saving in the controller
    }
	
	/**
	 * Sort the sensors recorded journey data
	 */
	def sort(def point) {
		// First 2 bytes contain the sensor identifier, the rest is the data
		// Check the identifier matches in the switch statement, then just pass on the data

		def sensorIdentifier = point.substring(0, 4)
		switch (sensorIdentifier) {
			// Calculated engine load value
			case "4104":
			calculatedEngineLoad << point.substring(2)
			break
			case "4105":
			engineCoolantTemperature << point.substring(2)
			break
			case "410A":
			fuelPressure << point.substring(2)
			break
			case "410B":
			intakeManifoldAbsolutePressure << point.substring(2)
			break
			case "410C":
			engineRPM << point.substring(4)
			break
			case "410C":
			engineRPM << point.substring(4)
			break
			case "410D":
			vehicleSpeed << point.substring(2)
			break
			case "410F":
			intakeAirTemperature << point.substring(2)
			break
			case "4110":
			mafAirFlowRate << point.substring(4)
			break
			case "4111":
			throttlePosition << point.substring(2)
			break
			case "4114":
			oxygenSensorVoltage1 << point.substring(4)
			break
			case "4115":
			oxygenSensorVoltage2 << point.substring(4)
			break
			case "4115":
			barometricPressure << point.substring(2)
			break
			case "413C":
			catalystTemperatureBank1Sensor1 << point.substring(4)
			break
			case "413D":
			catalystTemperatureBank1Sensor2 << point.substring(4)
			break
			case "413E":
			catalystTemperatureBank2Sensor1 << point.substring(4)
			break
			case "413F":
			catalystTemperatureBank2Sensor2 << point.substring(4)
			break
			case "4143":
			absoluteloadValue << point.substring(4)
			break
			case "4145":
			relativeThrottlePosition << point.substring(2)
			break
			case "4146":
			ambientAirTemperature << point.substring(2)
			break
			case "414C":
			commandedThrottleActuator << point.substring(2)
			break
			case "41":
			relativeAcceleratorPedalPosition << point.substring(2)
			break
			case "415C":
			engineOilTemperature << point.substring(2)
			break
			case "415D":
			fuelInjectionTiming << point.substring(4)
			break
			case "415E":
			engineFuelRate << point.substring(4)
			break
			case "4161":
			driversDemandEngineTorque << point.substring(2)
			break
			case "4162":
			actualEngineTorque << point.substring(2)
			break
			case "4163":
			engineReferenceTorque << point.substring(4)
			break
			default:
			return
		}
	}
	
	// CREATE ONE CONVERSION METHOD FOR EVERY SENSOR
	
//	/**
//	 * Conversion for 1 byte sensor payloads
//	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value
//	 * @param hexList - the list of hex values to decode and enter into the mathematical equation
//	 */
//	def transformOneByteData(def hexList)
//	{
//		for(int i = 0; i < hexList.size(); i++)
//		{
//			temp1 = Integer.parseInt(display.getText().trim(), 16 );
//		}
//		
//	}
//	
//	/**
//	 * Conversion for 2 byte sensor payloads
//	 * This method will convert hex to a decoded decimal value and then into the true human readable sensor value
//	 * @param hexList - the list of hex values to decode and enter into the mathematical equation
// 	*/
//	def transformTwoBytesData(def hexList)
//	{
//		for(int i = 0; i < hexList.size(); i++)
//		{
//			
//		}
//	}
	
	/**
	 * This method will calculate statistics for the journey data
	 * @param readableJourneyData - the journey data to draw statistics from.
 	*/
	def calculateStatistics(def readableJourneyData)
	{
		
	}
	
	// ???????? Unrequired method?
	def formatResult()
	{
		
	}
}
