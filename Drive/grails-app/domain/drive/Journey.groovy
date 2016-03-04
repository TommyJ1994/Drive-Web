package drive

import java.text.ParsePosition
import java.text.SimpleDateFormat

class Journey {
	
	static belongsTo = [vehicle: Vehicle]
	static hasMany = [sensors : Sensor]
	
	Date startTime
	Date endTime
	
	Integer journeyTimeLength
	Integer topSpeed
	Integer topRPM
	Integer averageSpeed
	Integer averageRPM
	Integer averagePercentageHighRPM
	Integer averageMPG
	Integer averageEngineLoad
	Integer averageThrottlePosition
	Integer averagePercentageIdle
	Integer heavyAccelerationCount
	Integer heavyBrakingCount
	Integer averageAmbientAirTemperature
	Integer averageGForce
	Integer topAccelerationGforce
	Integer topDecelerationGforce
	Integer averagePercentageCoasting
	
    static constraints = {
		journeyTimeLength(nullable:true)
		heavyAccelerationCount(nullable:true)
		heavyBrakingCount(nullable:true)
		averageSpeed(nullable:true)
		averageRPM(nullable:true)
		topSpeed(nullable:true)
		topRPM(nullable:true)
		averageAmbientAirTemperature(nullable:true)
		averageGForce(nullable:true)
		averagePercentageCoasting(nullable:true)
		averagePercentageIdle(nullable:true)
		averageThrottlePosition(nullable:true)
		averageEngineLoad(nullable:true)
		averageMPG(nullable:true)
		averagePercentageHighRPM(nullable:true)
		topDecelerationGforce(nullable:true)
		topDecelerationGforce(nullable:true)
    }
}
