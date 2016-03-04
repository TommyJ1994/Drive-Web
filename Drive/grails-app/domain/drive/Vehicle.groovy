package drive

class Vehicle {
	
	String identifier
	Driver driver
	OverallStatistics overallStatistics
	static hasMany = [journeys : Journey, features : String, colourNames : String, colourCodes : String]
	
	String make, model, engineConfiguration, fuelType, manufacturerEngineCode, drivenWheels, transmissionType, vehicleStyle, vehicleClass, numberOfSpeeds
	Integer year, cylinders, engineDisplacement, totalEngineValves, numOfDoors, mpgHighway, mpgCity, newPrice, usedPrice
	Double compressionRatio, engineSize, horsepower, torque
	
    static constraints = {
		identifier blank:false
		overallStatistics blank:false
		driver blank:false
		make blank:false
		model blank:false
		year blank:false
		engineConfiguration nullable:true
		engineDisplacement nullable:true
		manufacturerEngineCode nullable:true
		totalEngineValves nullable:true
		cylinders nullable:true
		compressionRatio nullable:true
		engineSize nullable:true
		horsepower nullable:true
		torque nullable:true
		fuelType nullable:true
		drivenWheels nullable:true
		transmissionType nullable:true
		vehicleStyle nullable:true
		vehicleClass nullable: true
		numberOfSpeeds nullable:true
		numOfDoors nullable:true
		mpgHighway nullable:true
		mpgCity nullable:true
		newPrice nullable:true
		usedPrice nullable:true
		colourNames nullable:true
		colourCodes nullable:true 
		features nullable:true
    }
	
}
