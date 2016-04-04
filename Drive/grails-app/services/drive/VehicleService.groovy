package drive

import grails.transaction.Transactional

/**
* Logic for generating field values for the vehicle domain class.
*/

@Transactional
class VehicleService {
	
	/**
	 * Generates a unique id to assign to a vehicle
	 */
	def generateUniqueID()
	{
		boolean globallyUniqueID = false
		StringBuilder stringBuilder = new StringBuilder();
		
		while(globallyUniqueID == false)
		{
			char[] chars = "abcdefghijklmnopqrstuvwxyzABCEDFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
			
			Random random = new Random();
			
			for (int i = 0; i < 10; i++) {
				char character = chars[random.nextInt(chars.length)];
				stringBuilder.append(character);
			}
			
			if(Vehicle.findByIdentifier(stringBuilder.toString()) == null)
			{
				globallyUniqueID = true;
			}
			
		}
		return stringBuilder.toString();
	}

	/**
	 * Gets the various colour codes for the vehicle
	 * @param carData - the data from the car
	 */
	def getColourCodes(def carData)
	{
		// Sets to hold colour codes
		def colourCodes = []
		
		// Extract colour names/codes from the carData structure and add them to the sets
		for(int i = 0; i < carData.colors.size(); i++)
		{
			for(int j = 0; j < carData.colors[i].options.size(); j++)
			{
				colourCodes[i] = carData.colors[i].options[j].colorChips?.primary?.hex
			}
		}
		return colourCodes
	}


	/**
	 * Gets the various colour names for the vehicle
	 * @param carData - the data from the car
	 */
	def getColourNames(def carData)
	{
		// Sets to hold colour names
		def colourNames = []
		
		// Extract colour names from the carData structure and add them to the sets
		for(int i = 0; i < carData.colors.size(); i++)
		{
			for(int j = 0; j < carData.colors[i].options.size(); j++)
			{
				colourNames[i] = carData.colors[i].options[j].name
			}
		}
		return colourNames
	}
	
	
	/**
	 * Gets the various features for the vehicle
	 * @param carData - the data from the car
	 */
	def getFeatures(def carData)
	{
		// Set to hold features
		def features = []

	// Extract features from the carData structure and add them to the features set
		for(int i = 0; i < carData.options.size(); i++)
		{
			for(int j = 0; j < carData.options[i].options.size(); j++)
			{
				features[i] = carData.options[i].options[j].name
			}
		}
		return features
	}
	
	
	/**
	 * Gets the statistics for the given set of vehicles.
	 * @param vehicles - the list of vehicles
	 */
	def getStatistics(def vehicles)
	{
		// Get the number of vehicles of the make
		def vehicleCount = vehicles.size()
		
		// Get the number of models of a make
		def modelCount = vehicles.model as Set
		
		// Get the number of models of a make
		def journeyCount = 0
		
		for(int i = 0; i < vehicles.journeys.size(); i++)
		{
			if(vehicles.journeys[i] != null)
			{
				journeyCount += vehicles.journeys[i].size();
			}
		}
		
		def overallStatistics = vehicles.overallStatistics as Set
								
		// Get the average vehicle age
		def vehicleAgeAverage = vehicles.year.sum() / vehicles.year.size()
		
		// Get the total driven hours for the vehicle make
		def totalHours = (overallStatistics.totalTimeLength.sum() / 3600)
		
		// Get the top speed for the vehicle make
		def averageSpeed = 0;
		
		if(overallStatistics.averageSpeed.size() > 0)
		{
			averageSpeed = overallStatistics.averageSpeed.sum() / overallStatistics.averageSpeed.size()
		}

		
		// Get the top recorded speed for the vehicle make
		def topSpeed = overallStatistics.topSpeed.max()
		
		// Get the average rpm for the vehicle make
		
		def averageRPM = 0;
		
		if(overallStatistics.averageRPM.size() > 0)
		{
			averageRPM = overallStatistics.averageRPM.sum() / overallStatistics.averageRPM.size()
		}

		
		// Get the top recorded  rpm for the vehicle make
		def topRPM = overallStatistics.topRPM.max()
		
		// Get the heavy acceleration count for the vehicle make
		def heavyAccelerationCount = overallStatistics.heavyAccelerationCount.sum()
		
		// Get the heavy braking count for the vehicle make
		def heavyBrakingCount = overallStatistics.heavyBrakingCount.sum()
		
		// Get the average engine load for the vehicle make
		
		def averageEngineLoad = 0;
		
		if(overallStatistics.averageEngineLoad.size() > 0)
		{
			averageEngineLoad = overallStatistics.averageEngineLoad.sum() / overallStatistics.averageEngineLoad.size()
		}

		
		// Get the average engine load for the vehicle make
		
		def averageThrottlePosition = 0;
		
		if(overallStatistics.averageThrottlePosition.size() > 0)
		{
			averageThrottlePosition = overallStatistics.averageThrottlePosition.sum() / overallStatistics.averageThrottlePosition.size()
		}
		
		// Get the average engine load for the vehicle make
		
		def averagePercentageIdle = 0;
		
		if(overallStatistics.averagePercentageIdle.size() > 0)
		{
			averagePercentageIdle = overallStatistics.averagePercentageIdle.sum() / overallStatistics.averagePercentageIdle.size()
		}

		// Get the average engine load for the vehicle make
		
		def averagePercentageHighRPM = 0;
		
		if(overallStatistics.averagePercentageHighRPM.size() > 0)
		{
			averagePercentageHighRPM = overallStatistics.averagePercentageHighRPM.sum() / overallStatistics.averagePercentageHighRPM.size()
		}
		
		// Get the average engine load for the vehicle make
		
		def averageGForce = 0;
		
		if(overallStatistics.averageGForce.size() > 0)
		{
			averageGForce = overallStatistics.averageGForce.sum() / overallStatistics.averageGForce.size()
		}

		
		// Get the top recorded  rpm for the vehicle make
		def topAccelerationGforce = overallStatistics.topAccelerationGforce.max()
		
		// Get the top recorded  rpm for the vehicle make
		def topDecelerationGforce = overallStatistics.topDecelerationGforce.max()
		
		// Get the average engine load for the vehicle make
		
		def averagePercentageCoasting = 0;
		
		if(overallStatistics.averagePercentageCoasting.size() > 0)
		{
			averagePercentageCoasting = overallStatistics.averagePercentageCoasting.sum() / overallStatistics.averagePercentageCoasting.size()
		}
		
		// Get the unique list of countries and their counts
		def countryList = vehicles.driver.country as Set
		def countries = []
		
		for(int i = 0; i < countryList.size(); i++)
		{
			def entry = [countryList[i], vehicles.driver.country.count(countryList[i])]
			countries << entry
		}
		
		// Get the unique list of countries and their counts
		def genderList = vehicles.driver.gender as Set
		def genders = []
		
		for(int i = 0; i < countryList.size(); i++)
		{
			def entry = [genderList[i], vehicles.driver.gender.count(genderList[i])]
			genders << entry
		}
		
		// Get the unique list of ages
		def ageList = vehicles.driver.year as Set
		def ages = []
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		for(int i = 0; i < ageList.size(); i++)
		{
			def entry = [currentYear - ageList[i], vehicles.driver.year.count(ageList[i])]
			ages << entry
		}
		
		return [vehicleCount: vehicleCount, 
			modelCount: modelCount, 
			journeyCount: journeyCount,
			vehicleAgeAverage: vehicleAgeAverage,
			totalHours: totalHours,
			averageSpeed: averageSpeed,
			averageRPM: averageRPM,
			heavyAccelerationCount: heavyAccelerationCount,
			heavyBrakingCount: heavyBrakingCount,
			topSpeed: topSpeed,
			topRPM: topRPM,
			averageEngineLoad: averageEngineLoad,
			averageThrottlePosition: averageThrottlePosition,
			averagePercentageIdle: averagePercentageIdle,
			averagePercentageHighRPM: averagePercentageHighRPM,
			averageGForce: averageGForce,
			topAccelerationGforce: topAccelerationGforce,
			topDecelerationGforce: topDecelerationGforce,
			averagePercentageCoasting: averagePercentageCoasting,
			countries: countries,
			genders: genders,
			ages: ages]
		}
	
}
