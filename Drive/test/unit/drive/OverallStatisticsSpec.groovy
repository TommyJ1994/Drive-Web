package drive

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(OverallStatistics)
class OverallStatisticsSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void testCreationSuccess() {

		given: "A new set of OverallStatistics are created"
		def overallStatistics = new OverallStatistics("totalTimeLength" : 0,
		"heavyAccelerationCount" : 0,
		"heavyBrakingCount" : 0,
		"averageSpeed" : 0,
		"averageRPM" : 0,
		"topSpeed" : 0,
		"topRPM" : 0,
		"averageGForce" : 0,
		"averagePercentageCoasting" : 0,
		"averagePercentageIdle" : 0,
		"averageThrottlePosition" : 0,
		"averageEngineLoad" : 0,
		"averageMPG" : 0,
		"averagePercentageHighRPM" : 0,
		"topAccelerationGforce" : 0,
		"topDecelerationGforce" : 0,
		"speedSamples" : 0,
		"rpmSamples" : 0,
		"idleSamples" : 0,
		"gForceSamples" : 0,
		"engineLoadSamples" : 0,
		"mpgSamples" : 0,
		"throttleSamples" : 0)
		
		when: "the OverallStatistics are saved"
		 overallStatistics.save()
		
		
		then: "the number of OverallStatistics instances should be equals to 1"
			assertEquals 1, OverallStatistics.list().size()
		}
	
	void testCreationFailure() {
		
				given: "A new set of OverallStatistics are created"
				def overallStatistics = new OverallStatistics("totalTimeLength" : 0,
				"heavyAccelerationCount" : 'Not A Number',
				"heavyBrakingCount" : 'Not A Number',
				"averageSpeed" : 'Not A Number',
				"averageRPM" : 'Not A Number',
				"topSpeed" : 'Not A Number',
				"topRPM" : 'Not A Number',
				"averageGForce" : 'Not A Number',
				"averagePercentageCoasting" : 'Not A Number',
				"averagePercentageIdle" : 'Not A Number',
				"averageThrottlePosition" : 'Not A Number',
				"averageEngineLoad" : 'Not A Number',
				"averageMPG" : 'Not A Number',
				"averagePercentageHighRPM" : 'Not A Number',
				"topAccelerationGforce" : 'Not A Number',
				"topDecelerationGforce" : 'Not A Number',
				"speedSamples" : 'Not A Number',
				"rpmSamples" : 'Not A Number',
				"idleSamples" : 'Not A Number',
				"gForceSamples" : 'Not A Number',
				"engineLoadSamples" : 'Not A Number',
				"mpgSamples" : 'Not A Number',
				"throttleSamples" : 'Not A Number')
				
				when: "the OverallStatistics are saved"
				 overallStatistics.save()
				
				
				then: "the number of OverallStatistics instances should be equals to 'Not A Number'"
					assertEquals 0, OverallStatistics.list().size()
	}
}
