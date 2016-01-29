package drive

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import groovy.json.JsonSlurper

/**
 * The API Controller is responsible for the handling of the interactions between the mobile app and the web app.
 */

@Transactional(readOnly = false)
class ApiController {
	
	// import vehicle and journey data manipulation services
	def vehicleService
	def journeyDataManipulationService

	// Data Response Formats
    static responseFormats = ['json', 'xml']
	
	// Allowed Methods to Interact with Resources
    static allowedMethods = [addNewJourney: "POST", addNewVehicle: "POST", delete: "DELETE"]

	/**
	 * 
	 * @param max - the maximum number of items to return
 	*/
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Api.list(params), [status: OK]
    }
		
	/**
	 * This method adds a new driver and a vehicle to the database based on the data sent from the phone.
	 * @param properties - The Driver/Vehicle data sent from the phone in JSON format
 	*/
	@Transactional
	def addNewVehicle(String properties) 
	{
		// Collects the JSON data sent from the phone 
		def data = request.JSON										
		
		// Picking out Driver information and car data
		def dateOfBirth = data.dateOfBirth;
		def gender = data.gender;
		def country = data.country;
		def carData = data.carData
		
		// Generate a new ID for the vehicle. This ID will be globally unique.
		String id = vehicleService.generateUniqueID();
		
		// Check if some of the key attributes are null
		if (dateOfBirth == null | gender == null | country == null | carData.model.name== null | carData.make.name == null | carData.year.year == null) {
			// Send 405 if any of the key data is null
			render status: NOT_ACCEPTABLE							
			return
		}
		
		// Create a new driver and save them to the database	
		def driver = new Driver("gender": gender, "dateOfBirth": Date.parse( 'dd-MM-yyyy', dateOfBirth ), "country": country)
		
		// validate that the driver attributes obey the constraints set out in the domain class
		driver.validate()
		if (driver.hasErrors()) {
			render status: NOT_ACCEPTABLE
			println driver.errors
			return
		}

		// save the driver to the database
		driver.save()
		
		// Sets to hold colour names/codes
		def colourNames = []
		def colourCodes = []
		
		// Extract colour names/codes from the carData structure and ass them to the sets
		for(int i = 0; i < carData.colors.size(); i++)
		{
			for(int j = 0; j < carData.colors[i].options.size(); j++)
			{
				colourNames[i] = carData.colors[i].options[j].name
				colourCodes[i] = carData.colors[i].options[j].colorChips?.primary?.hex
			}

		}
		
		// Set to hold cars notable features list
		def features = []
		
		// Extract features from the carData structure and ass them to the features set
		for(int i = 0; i < carData.options.size(); i++)
		{
			for(int j = 0; j < carData.options[i].options.size(); j++)
			{
				features[i] = carData.options[i].options[j].name
			}
		}
		
		// create the new vehicle object
		def vehicle = new Vehicle("identifier": id, 
					"driver": driver, 
					"year": carData.year?.year,
					"make": carData.make?.name,
					"model": carData.model?.name,
					"engineConfiguration": carData.engine?.configuration,
					"compressionRatio": carData.engine?.compressionRatio,
					"engineDisplacement": carData.engine?.displacement,
					"engineSize": carData.engine?.size,
					"cylinders": carData.engine?.cylinder,
					"manufacturerEngineCode": carData.engine?.manufacturerEngineCode,
					"fuelType": carData.engine?.fuelType,
					"horsepower": carData.engine?.horsepower,
					"torque": carData.engine?.torque,
					"totalEngineValves": carData.engine?.totalValves,
					"transmissionType": carData.transmission?.transmissionType,
					"numberOfSpeeds": carData.transmission?.numberOfSpeeds,
					"drivenWheels": carData.options?.drivenWheels,
					"vehicleClass": carData.categories?.EPAClass,
					"vehicleStyle": carData.categories?.vehicleStyle,
					"numOfDoors": carData.numOfDoors,
					"mpgHighway": carData.MPG?.highway,
					"mpgCity": carData.MPG?.city,
					"newPrice": carData.price?.baseMSRP,
					"usedPrice": carData.price?.usedPrivateParty,
					"colourNames": colourNames,
					"colourCodes": colourCodes,
					"features": features)
		
		// validate that the vehicle attributes obey the constraints set out in the domain class
		vehicle.validate()
		if (vehicle.hasErrors()) {
			render status: NOT_ACCEPTABLE
			println vehicle.errors
			return
		}
		
		// save the vehicle to the database
		vehicle.save()	

		// New driver/vehicle created sucessfully
		render status: CREATED											
	}
	
	/**
	 * Receives journey data from the phone and adds it to the database 
	 * after the data manipulation has been carried out
 	*/
	@Transactional
	def addNewJourney(String vehicleData)
	{
		def data = request.JSON	
		
		println data
		
		// Send 200 OK, all data is valid and saved to DB
		render status: CREATED
	}

    /**
	 * 
 	*/
    @Transactional
    def delete(Api apiInstance) {

        if (apiInstance == null) {
            render status: NOT_FOUND
            return
        }

        apiInstance.delete flush:true
        render status: NO_CONTENT
    }
}
