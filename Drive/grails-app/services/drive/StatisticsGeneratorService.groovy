package drive

import grails.transaction.Transactional

/**
 * This service generates statistics for a given journey
 */

@Transactional
class StatisticsGeneratorService {


	/**
	 * Get the average speed of the vehicle
	 * @param speedData - the speed values recorded on a journey
	 */
	def getAverageSpeed(def speedData) {
		int sum = 0;

		for(int i = 0; i < speedData.size(); i++) {
			sum += speedData[i]
		}

		return sum / speedData.size()
	}

	/**
	 * Get the average rpm of the vehicle
	 * @rpmData - the rpm values recorded on a journey
	 */
	def getAverageRPM(def rpmData) {
		int sum = 0;

		for(int i = 0; i < rpmData.size(); i++) {
			sum += rpmData[i]
		}

		return sum / rpmData.size()
	}

	/**
	 * Get the top speed of the vehicle
	 * @param speedData - the speed values recorded on a journey
	 */
	def getTopSpeed(def speedData) {
		int topSpeed = speedData[0];

		for(int i = 0; i < speedData.size(); i++) {
			if(speedData[i] > topSpeed) {
				topSpeed = speedData[i]
			}
		}
		return topSpeed
	}

	/**
	 * Get the top engine RPM
	 * @rpmData - the rpm values recorded on a journey
	 */
	def getTopRPM(def rpmData) {
		int topSpeed = rpmData[0];

		for(int i = 0; i < rpmData.size(); i++) {
			if(rpmData[i] > topSpeed) {
				topSpeed = rpmData[i]
			}
		}
		return topSpeed
	}

	/**
	 * Get the percentage of the journey driven at a high RPM
	 * @rpmData - the rpm values recorded on a journey
	 */
	def getAveragePercentageHighRPM(def rpmData) {
		int sum = 0;

		for(int i = 0; i < rpmData.size(); i++) {
			if(rpmData[i] > 3500) {
				sum++
			}
		}

		return (sum / rpmData.size()) * 100
	}

	/**
	 * Get the average MPG for the journey
	 * @mpgData - the mpg readings recorded on a journey
	 */
	def getAverageMPG(def mpgData) {
		int sum = 0;

		for(int i = 0; i < mpgData.size(); i++) {
			sum += mpgData[i]
		}

		return sum / mpgData.size()
	}

	/**
	 * Get the average engine load during the journey
	 * @engineLoadData - the engine load readings recorded on a journey
	 */
	def getAverageEngineLoad(def engineLoadData) {
		int sum = 0;

		for(int i = 0; i < engineLoadData.size(); i++) {
			sum += engineLoadData[i]
		}

		return sum / engineLoadData.size()
	}

	/**
	 * Get the average throttle position for the journey 
	 * @throttlePositionData - the throttle position readings recorded on a journey
	 */
	def getAverageThrottlePosition(def throttlePositionData) {
		int sum = 0;

		for(int i = 0; i < throttlePositionData.size(); i++) {
			sum += throttlePositionData[i]
		}

		return sum / throttlePositionData.size()
	}

	/**
	 * Get the average idle percentage for the journey
	 * @speedData - the vehicle speed readings recorded on a journey
	 */
	def getAveragePercentageIdle(def speedData) {
		int sum = 0;

		for(int i = 0; i < speedData.size(); i++) {
			if(speedData[i] < 3) {
				sum++
			}
		}
		return (sum / speedData.size()) * 100
	}

	/**
	 * Get the average idle percentage for the journey
	 * @speedData - the vehicle speed readings recorded on a journey
	 * @throttlePositionData - the throttle position readings recorded on a journey
	 */
	def getAveragePercentageCoasting(def speedData, def throttlePositionData) {
		int sum = 0;

		for(int i = 0; i < speedData.size(); i++) {
			if(throttlePositionData[i] != null) {
				if(speedData[i] > 5 && throttlePositionData[i] < 5) {
					sum++
				}
			}
		}
		return (sum / speedData.size()) * 100
	}

	/**
	 * Get the average g force for the journey
	 * @speedData - the vehicle speed readings recorded on a journey
	 */
	def getAverageGForce(def speedData) {
		int sum = 0;

		for(int i = 0; i < speedData.size(); i++) {
			if(speedData[i+1] != null) {
				int acceleration = ((speedData[i] - speedData[i+1]) * 1.47)/1
				int gForce = acceleration/32.174

				if(gForce < 0) {
					gForce = Math.abs(gForce) // get positive g force value
				}
				sum += gForce
			}
		}
		return Math.round((sum / speedData.size()) * 100.0)/100.0;
	}

	/**
	 * The highest recorded G Force under acceleration
	 * @speedData - the vehicle speed readings recorded on a journey
	 */
	def getTopAccelerationGforce(def speedData) {
		int topGforce = 0;

		for(int i = 0; i < speedData.size(); i++) {
			if(speedData[i+1] != null && speedData[i+1] > speedData[i]) {
				int acceleration = ((speedData[i] - speedData[i+1]) * 1.47)/1
				int gForce = acceleration/32.174

				if(gForce > topGforce) {
					topGforce = gForce 
				}
			}
		}

		return topGforce
	}
	
	/**
	 * The highest recorded G Force under braking
	 * @speedData - the vehicle speed readings recorded on a journey
	 */
	def getTopDecelerationGforce(def speedData) {
		int topGforce = 0;

		for(int i = 0; i < speedData.size(); i++) {
			if(speedData[i+1] != null && speedData[i+1] < speedData[i]) {
				int acceleration = ((speedData[i] - speedData[i+1]) * 1.47)/1
				int gForce = acceleration/32.174
				gForce = Math.abs(gForce) // get positive g force value

				if(gForce > topGforce) {
					topGforce = gForce
				}
			}
		}

		return topGforce
	}

	/**
	 * Get the number of times the driver braked heavily during a journey
	 * @param speedData - the speed values recorded on a journey
	 */
	def getHeavyBrakingCount(def speedData) {
		int count = 0

		for(int i = 0; i < speedData.size(); i++) {
			// check that the end of the list has not been reached
			if(speedData[i + 5] != null && speedData[i] - speedData[i + 1] > 11)
			{
				count++;
				i+= 5 // Prevent a long brake being counted as multiple heavy brakings
			}
		}
		return count
	}

	/**
	 * Get the number of times the driver accelerated heavily during a journey
	 */
	def getHeavyAccelerationCount(def speedData)
	{
		int count = 0

		for(int i = 0; i < speedData.size(); i++)
		{
			// check that the end of the list has not been reached
			if(speedData[i + 5] != null && speedData[i + 1] - speedData[i] > 11)
			{
				count++;
				i+= 5 // Prevent a long acceleration being counted as multiple heavy accelerations
			}
		}
		return count
	}

}
