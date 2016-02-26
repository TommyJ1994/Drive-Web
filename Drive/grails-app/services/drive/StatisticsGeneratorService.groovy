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
    def getAverageSpeed(def speedData) 
	{
		int sum = 0;
		
		for(int i = 0; i < speedData.size(); i++)
		{
			sum += speedData[i]
		}
		
		return sum / speedData.size()
    }
	
	/**
	 * Get the average rpm of the vehicle
	 * @rpmData - the rpm values recorded on a journey
	 */
	def getAverageRPM(def rpmData) 
	{
		int sum = 0;
		
		for(int i = 0; i < rpmData.size(); i++)
		{
			sum += rpmData[i]
		}
		
		return sum / rpmData.size()
	}
	
	/**
	 * Get the top speed of the vehicle
	 * @param speedData - the speed values recorded on a journey
	 */
	def getTopSpeed(def speedData) 
	{
		int topSpeed = speedData[0];
		
		for(int i = 0; i < speedData.size(); i++)
		{
			if(speedData[i] > topSpeed)
			{
				topSpeed = speedData[i]
			}
		}
		return topSpeed
	}
	
	/**
	 * Get the top engine RPM
	 * @rpmData - the rpm values recorded on a journey
	 */
	def getTopRPM(def rpmData) 
	{
		int topSpeed = rpmData[0];
		
		for(int i = 0; i < rpmData.size(); i++)
		{
			if(rpmData[i] > topSpeed)
			{
				topSpeed = rpmData[i]
			}
		}
		return topSpeed
	}
	
	/**
	 * Get the number of times the driver braked heavily during a journey
	 * @param speedData - the speed values recorded on a journey
	 */
	def getHeavyBrakingCount(def speedData) 
	{
		int count = 0
		
		for(int i = 0; i < speedData.size(); i++)
		{
			// check that the end of the list has not been reached
			if(speedData[i + 5] != null && speedData[i] - speedData[i + 1] > 7)
			{
				count++;
				i+= 10 // Prevent a long brake being counted as multiple heavy brakings
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
			if(speedData[i + 5] != null && speedData[i + 1] - speedData[i] > 7)
			{
				count++;
				i+= 10 // Prevent a long acceleration being counted as multiple heavy accelerations
			}
		}
		return count
	}
	
}
