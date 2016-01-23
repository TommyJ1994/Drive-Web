package drive

class Vehicle {
	
	String identifier
	Driver driver
	static hasMany = [journeys : Journey]
	String manufacturer
	String model
	int year
	double engineSize
	String fuelType

    static constraints = {
		identifier blank:false
		driver()
		manufacturer()
		model()
		year()
		engineSize()
		fuelType()
    }
}
