package drive

import grails.transaction.Transactional

@Transactional
class VehicleService {
	
	def addNewDriver(age, dateOfBirth, country)
	{
		new Driver("age":age, "dateOfBirth": Date.parse( 'dd-MM-yyyy', dateOfBirth ), "country":country).save()
	}

    def addNewVehicle() {

    }
	
	def generateUniqueID()
	{
		
	}
	
}
