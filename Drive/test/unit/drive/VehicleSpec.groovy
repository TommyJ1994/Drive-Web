package drive

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Vehicle)
class VehicleSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

   void testCreationSuccess() {

		given: "A new Vehicle is created"
		def driver = new Driver(gender: 'male',
			dateOfBirth: new Date(),
			country: 'Finland',
			year: 1991)
		
		def overallStatistics = new OverallStatistics()
		
		def vehicle = new Vehicle("identifier": 'h27cn49fj3u',
		"driver": driver,
		"overallStatistics": overallStatistics,
		"year": 2010,
		"make": 'Mitsubishi',
		"model": 'Lancer',
		"engineConfiguration": 'inline',
		"compressionRatio": 9.5,
		"engineDisplacement": 1999,
		"engineSize": 2.0,
		"cylinders": 4,
		"manufacturerEngineCode": 'ARC',
		"fuelType": 'regular unleaded',
		"horsepower": 120,
		"torque": 130,
		"totalEngineValves": 16,
		"transmissionType": 'MANUAL',
		"numberOfSpeeds": 5,
		"drivenWheels": 'front',
		"vehicleClass": 'Compact Cars',
		"vehicleStyle": 'Sedan',
		"numOfDoors": 4,
		"mpgHighway": 28,
		"mpgCity": 21,
		"newPrice": 23423,
		"usedPrice": 15838,
		"colourNames": [],
		"colourCodes": [],
		"features": [])
		
		when: "the Vehicle is saved"
		 vehicle.save()
		
		
		then: "the number of Vehicles should be equals to 1"
			assertEquals 1, Vehicle.list().size()
		}
	
	void testCreationFailure() {
		
		given: "A new Vehicles are created"
		def driver = new Driver(gender: 'female',
			dateOfBirth: new Date(),
			country: 'United States',
			year: 1974)
		
		def overallStatistics = new OverallStatistics()
		
		def vehicle = new Vehicle("identifier": 'h27cn49fj3u',
		"driver": driver,
		"overallStatistics": overallStatistics,
		"year": null,
		"make": 'BMW',
		"model": '320d',
		"engineConfiguration": 'inline',
		"compressionRatio": 9.5,
		"engineDisplacement": 1999,
		"engineSize": 2.0,
		"cylinders": 4,
		"manufacturerEngineCode": 'ARC',
		"fuelType": 'regular unleaded',
		"horsepower": 170,
		"torque": 170,
		"totalEngineValves": 16,
		"transmissionType": 'MANUAL',
		"numberOfSpeeds": 5,
		"drivenWheels": 'rear',
		"vehicleClass": 'Compact Cars',
		"vehicleStyle": 'Coupe',
		"numOfDoors": 2,
		"mpgHighway": 24,
		"mpgCity": 18,
		"newPrice": 43423,
		"usedPrice": 25838,
		"colourNames": [],
		"colourCodes": [],
		"features": [])
		
		def driver2 = new Driver(gender: 'male',
			dateOfBirth: new Date(),
			country: 'Sweden',
			year: 1971)
		
		def overallStatistics2 = new OverallStatistics()
		
		def vehicle2 = new Vehicle("identifier": 'h27cn49fj3u',
		"driver": driver,
		"overallStatistics": overallStatistics,
		"year": 2001,
		"make": null,
		"model": null,
		"engineConfiguration": 'inline',
		"compressionRatio": 9.5,
		"engineDisplacement": 1999,
		"engineSize": 2.0,
		"cylinders": 4,
		"manufacturerEngineCode": 'ARC',
		"fuelType": 'regular unleaded',
		"horsepower": 177,
		"torque": 160,
		"totalEngineValves": 16,
		"transmissionType": 'MANUAL',
		"numberOfSpeeds": 5,
		"drivenWheels": 'rear',
		"vehicleClass": 'Compact Cars',
		"vehicleStyle": 'Coupe',
		"numOfDoors": 2,
		"mpgHighway": 24,
		"mpgCity": 18,
		"newPrice": 41423,
		"usedPrice": 21838,
		"colourNames": [],
		"colourCodes": [],
		"features": [])
		
		when: "the Vehicle is saved"
		 vehicle.save()
		 vehicle2.save()
		
		
		then: "the number of Vehicles should be equals to 1"
			assertEquals 0, Vehicle.list().size()
		}
}
