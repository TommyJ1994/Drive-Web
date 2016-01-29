package drive

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import groovy.json.JsonSlurper

@Transactional(readOnly = false)
class ApiController {
	
	def vehicleService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [addNewJourney: "POST", addNewVehicle: "POST",save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Api.list(params), [status: OK]
    }
	
	// NEW ### curl -i -X POST -H "Cache-Control: no-cache" -H "Content-Type: application/json" -d '{"age": 59, "dateOfBirth": 1994-11-11, "country":italy}' localhost:8080/Drive/api/addNewVehicle
	
	
	@Transactional
	def addNewVehicle(String properties) 
	{
		def data = request.JSON										// Data contains vehicle + driver information 
		
		def dateOfBirth = data.dateOfBirth;
		def gender = data.gender;
		def country = data.country;
		
		def jsonSlurper = new JsonSlurper()
		def carData = data.carData
						
		String id = vehicleService.generateUniqueID();
		
		if (dateOfBirth == null | gender == null | country == null | carData.year.year == null) {
			render status: NOT_ACCEPTABLE							// Send 405, some of the data is null
			return
		}
				
		def driver = new Driver("gender": gender, "dateOfBirth": Date.parse( 'dd-MM-yyyy', dateOfBirth ), "country": country)
		driver.save()
		
		def colourNames = []
		def colourCodes = []
		
		for(int i = 0; i < carData.colors.size(); i++)
		{
			for(int j = 0; j < carData.colors[i].options.size(); j++)
			{
				colourNames[i] = carData.colors[i].options[j].name
				colourCodes[i] = carData.colors[i].options[j].colorChips?.primary?.hex
			}

		}
		
		def features = []
		
		for(int i = 0; i < carData.options.size(); i++)
		{
			for(int j = 0; j < carData.options[i].options.size(); j++)
			{
				features[i] = carData.options[i].options[j].name
			}
		}
		
			
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
		
		vehicle.validate()
		if (vehicle.hasErrors()) {
			render status: NOT_ACCEPTABLE
			println vehicle.errors
			return
		}
		
		vehicle.save()		
			
		render status: CREATED											// Send 200 OK, all data is 
	}
	
	@Transactional
	def addNewJourney(String vehicleData)
	{
		def data = request.JSON	
		
		println data
				
		render status: CREATED										// Send 200 OK, all data is
	}
	
    @Transactional
    def save(Api apiInstance) {
        if (apiInstance == null) {
            render status: NOT_FOUND
            return
        }

        apiInstance.validate()
        if (apiInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }
		
        apiInstance.save flush:true
        respond apiInstance, [status: CREATED]
    }

    @Transactional
    def update(Api apiInstance) {
        if (apiInstance == null) {
            render status: NOT_FOUND
            return
        }

        apiInstance.validate()
        if (apiInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        apiInstance.save flush:true
        respond apiInstance, [status: OK]
    }

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
