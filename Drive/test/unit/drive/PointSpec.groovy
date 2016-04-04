package drive

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Point)
class PointSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

   void testCreationSuccess() {

		given: "A new set of Points are created"
		def sensor = new Sensor(name: 'Speed', description: 'Speed Sensor')
		def point = new Point(value: '23',
			index: 1, sensor: sensor)
		def point2 = new Point(value: '34',
			index: 2, sensor: sensor)
		def point3 = new Point(value: '21',
			index: 3, sensor: sensor)
		
		when: "the Points are saved"
		 point.save()
		 point2.save()
		 point3.save()
		
		
		then: "the number of Points should be equals to 3"
			assertEquals 3, Point.list().size()
		}
	
	void testCreationFailure() {
		
				given: "A new set of Points are created"
				def sensor = new Sensor(name: 'Speed', description: 'Speed Sensor')
				def point = new Point(value: '54',
					index: '5', sensor: sensor)
				def point2 = new Point(value: '21',
					index: null, sensor: sensor)
				
				when: "the Points are saved"
				 point.save()
				
				
				then: "the number of Points should be equals to 1"
					assertEquals 1, Point.list().size()
	}
}
