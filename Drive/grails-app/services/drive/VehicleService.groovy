package drive

import grails.transaction.Transactional

@Transactional
class VehicleService {
	
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
}
