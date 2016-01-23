package drive

import grails.transaction.Transactional

@Transactional
class VehicleService {
	
	def addNewDriver(gender, dateOfBirth, country)
	{
		new Driver("gender":gender, "dateOfBirth": Date.parse( 'dd-MM-yyyy', dateOfBirth ), "country":country).save()
	}

    def addNewVehicle() {

    }
	
	def generateUniqueID()
	{
		
	}
	
}
