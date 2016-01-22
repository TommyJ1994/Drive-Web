package drive

class Vehicle {
	
	Driver driver
	static hasMany = [journeys : Journey]
	String manufacturer
	String model
	int year
	double engineSize
	String fuelType

    static constraints = {
		driver()
		manufacturer()
		model()
		year()
		engineSize()
		fuelType()
    }
}
