package drive

class Journey {
	
	static belongsTo = [vehicle: Vehicle]
	static hasMany = [sensors : Sensor]
	
	Date startTime
	Date endTime
	
	int heavyAccelerationCount
	int heavyBrakingCount
	
	// int averageSpeed
	// int averageRPM

    static constraints = {
    }
}
