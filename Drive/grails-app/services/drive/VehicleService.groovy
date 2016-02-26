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
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCEDFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			char character = chars[random.nextInt(chars.length)];
			stringBuilder.append(character);
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

	// Extract features from the carData structure and ass them to the features set
		for(int i = 0; i < carData.options.size(); i++)
		{
			for(int j = 0; j < carData.options[i].options.size(); j++)
			{
				features[i] = carData.options[i].options[j].name
			}
		}
		return features
	}
}
