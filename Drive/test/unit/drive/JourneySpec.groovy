package drive

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Journey)
class JourneySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

   void testCreationSuccess() {

		given: "A new Journey is created"
		def driver = new Driver(gender: 'male',
			dateOfBirth: new Date(),
			country: 'Australia',
			year: 1991)
		
		def overallStatistics = new OverallStatistics()
		
		def vehicle = new Vehicle("identifier": 'v67cn49fj3u',
			"driver": driver,
			"overallStatistics": overallStatistics,
			"year": 2010,
			"make": 'Ford',
			"model": 'Focus',
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
			"vehicleStyle": '2dr Hatchback',
			"numOfDoors": 4,
			"mpgHighway": 28,
			"mpgCity": 21,
			"newPrice": 23423,
			"usedPrice": 15838,
			"colourNames": [],
			"colourCodes": [],
			"features": [])
		
		def newJourney = new Journey("sensors": [],
		"startTime": new Date(),
		"endTime": new Date(),
		"journeyTimeLength": 0,
		"topSpeed": 0,
		"topRPM": 0,
		"averageSpeed": 0,
		"averageRPM": 0,
		"heavyBrakingCount": 0,
		"heavyAccelerationCount": 0,
		"averagePercentageIdle": 0,
		"averageGForce": 0,
		"topAccelerationGforce": 0,
		"topDecelerationGforce": 0,
		"averagePercentageHighRPM": 0,
		"averageEngineLoad": 0,
		"averageMPG": 0,
		"averageThrottlePosition": 0,
		"averagePercentageCoasting": 0,
		"vehicle": vehicle
		);
		
		when: "the Journey is saved"
		 newJourney.save()
		
		
		then: "the number of Drivers should be equals to 1"
			assertEquals 1, Journey.list().size()
		}
	
	void testCreationFailure() {

		given: "A new Journey is created"
		def driver = new Driver(gender: 'male',
			dateOfBirth: new Date(),
			country: 'Australia',
			year: 1991)
		
		def overallStatistics = new OverallStatistics()
		
		def vehicle = new Vehicle("identifier": 'v67cn49fj3u',
			"driver": driver,
			"overallStatistics": overallStatistics,
			"year": 2010,
			"make": 'Ford',
			"model": 'Focus',
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
			"vehicleStyle": '2dr Hatchback',
			"numOfDoors": 4,
			"mpgHighway": 28,
			"mpgCity": 21,
			"newPrice": 23423,
			"usedPrice": 15838,
			"colourNames": [],
			"colourCodes": [],
			"features": [])
		
		def newJourney = new Journey("sensors": [],
		"startTime": new Date(),
		"endTime": new Date(),
		"journeyTimeLength": 'Not an Integer',
		"topSpeed": 'Not an Integer',
		"topRPM": 'Not an Integer',
		"averageSpeed": 'Not an Integer',
		"averageRPM": 'Not an Integer',
		"heavyBrakingCount": 'Not an Integer',
		"heavyAccelerationCount": 'Not an Integer',
		"averagePercentageIdle": 'Not an Integer',
		"averageGForce": 'Not an Integer',
		"topAccelerationGforce": 'Not an Integer',
		"topDecelerationGforce": 'Not an Integer',
		"averagePercentageHighRPM": 'Not an Integer',
		"averageEngineLoad": 'Not an Integer',
		"averageMPG": 'Not an Integer',
		"averageThrottlePosition": 'Not an Integer',
		"averagePercentageCoasting": 'Not an Integer',
		"vehicle": vehicle
		);
		
		when: "the Journey is saved"
		 newJourney.save()
		
		
		then: "the number of Journeys should be equals to 0"
			assertEquals 0, Journey.list().size()
		}
}
