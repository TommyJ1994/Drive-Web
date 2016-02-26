package drive

import java.text.ParsePosition
import java.text.SimpleDateFormat

class Journey {
	
	static belongsTo = [vehicle: Vehicle]
	static hasMany = [sensors : Sensor]
	
	Date startTime
	Date endTime
	
	Integer journeyTimeLength // in minutes
	
	Integer heavyAccelerationCount
	Integer heavyBrakingCount
	
	Integer averageSpeed
	Integer averageRPM

	Integer topSpeed
	Integer topRPM
	
    static constraints = {
		journeyTimeLength(nullable:false)
		heavyAccelerationCount(nullable:false)
		heavyBrakingCount(nullable:false)
		averageSpeed(nullable:false)
		averageRPM(nullable:false)
		topSpeed(nullable:false)
		topRPM(nullable:false)
    }
}
