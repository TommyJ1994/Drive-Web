package drive

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Driver)
class DriverSpec extends Specification {

    def setup() {
		
    }

    def cleanup() {
    }

    void testCreationSuccess() {

		given: "A new Driver is created"
		def driver = new Driver(gender: 'male',
			dateOfBirth: new Date(),
			country: 'Ireland',
			year: 2004)
		
		when: "the Driver is saved"
		 driver.save()
		
		
		then: "the number of Drivers should be equals to 1"
			assertEquals 1, Driver.list().size()
		}
	
	void testCreationFailure() {
		
				given: "A new Driver is created"
				def driver = new Driver(gender: 'female',
					dateOfBirth: new Date(),
					country: 'England',
					year: 'string')
				
				when: "the Driver is saved"
				 driver.save()
				
				
				then: "the number of Drivers should be equals to 0"
					assertEquals 0, Driver.list().size()
	}
    
}
