package drive

import grails.converters.JSON
import grails.test.spock.IntegrationSpec
import groovy.json.JsonSlurper

class ApiIntegrationSpec extends IntegrationSpec {

	def setup() {
		Vehicle.findAll().each { it.delete() }
		Driver.findAll().each { it.delete() }
		OverallStatistics.findAll().each { it.delete() }
		Point.findAll().each { it.delete() }
		Sensor.findAll().each { it.delete() }
		Journey.findAll().each { it.delete() }
	}

	def cleanup() {
		Vehicle.findAll().each { it.delete() }
		Driver.findAll().each { it.delete() }
		OverallStatistics.findAll().each { it.delete() }
		Point.findAll().each { it.delete() }
		Sensor.findAll().each { it.delete() }
		Journey.findAll().each { it.delete() }
	}

	void testAddNewVehicleSuccess() {
		when: "We pass data to the addNewVehicle() method"

		def apiController = new ApiController()
		apiController.request.json = '{"dateOfBirth":{"year":1994,"month":2,"dayOfMonth":13},"gender":"female","country":"Ireland","carData":{"make":{"id":200000001,"name":"Audi","niceName":"audi"},"model":{"id":"Audi_200","name":"200","niceName":"200"},"engine":{"id":"200654469","name":"Engine","equipmentType":"ENGINE","compressionRatio":9,"cylinder":5,"size":2.2,"configuration":"inline","fuelType":"regular unleaded","horsepower":217,"torque":228,"type":"gas","code":"5ITCG2.2","compressorType":"turbocharger","rpm":{"horsepower":5700,"torque":1950}},"transmission":{"id":"200654468","name":"5M","equipmentType":"TRANSMISSION","transmissionType":"MANUAL","numberOfSpeeds":"5"},"drivenWheels":"all wheel drive","numOfDoors":"4","options":[],"colors":[{"category":"Exterior","options":[{"id":"200654483","name":"Titanium Gray Metallic","equipmentType":"COLOR","manufactureOptionName":"Titanium Gray Metallic","manufactureOptionCode":"000"},{"id":"200654482","name":"Amarena Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Amarena Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654477","name":"Indigo Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Indigo Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654486","name":"Pearl White Metallic","equipmentType":"COLOR","manufactureOptionName":"Pearl White Metallic","manufactureOptionCode":"000"},{"id":"200654472","name":"Bamboo Metallic","equipmentType":"COLOR","manufactureOptionName":"Bamboo Metallic","manufactureOptionCode":"000"},{"id":"200654485","name":"Zycalm Red Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Zycalm Red Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654484","name":"Tornado Red","equipmentType":"COLOR","manufactureOptionName":"Tornado Red","manufactureOptionCode":"000"},{"id":"200654479","name":"Opal Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Opal Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654478","name":"Lago Blue Metallic","equipmentType":"COLOR","manufactureOptionName":"Lago Blue Metallic","manufactureOptionCode":"000"},{"id":"200654475","name":"Crystal Silver Metallic","equipmentType":"COLOR","manufactureOptionName":"Crystal Silver Metallic","manufactureOptionCode":"000"},{"id":"200654476","name":"Glacier Blue Metallic","equipmentType":"COLOR","manufactureOptionName":"Glacier Blue Metallic","manufactureOptionCode":"000"},{"id":"200654481","name":"Alpine White","equipmentType":"COLOR","manufactureOptionName":"Alpine White","manufactureOptionCode":"000"},{"id":"200654470","name":"Papyrus Metallic","equipmentType":"COLOR","manufactureOptionName":"Papyrus Metallic","manufactureOptionCode":"000"},{"id":"200654480","name":"Panther Black Metallic","equipmentType":"COLOR","manufactureOptionName":"Panther Black Metallic","manufactureOptionCode":"000"},{"id":"200654473","name":"Black","equipmentType":"COLOR","manufactureOptionName":"Black","manufactureOptionCode":"000"},{"id":"200654471","name":"Aquamarine Metallic","equipmentType":"COLOR","manufactureOptionName":"Aquamarine Metallic","manufactureOptionCode":"000"},{"id":"200654474","name":"Cayenne Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Cayenne Pearl Metallic","manufactureOptionCode":"000"}]}],"price":{"usedTmvRetail":2000,"usedPrivateParty":1063,"usedTradeIn":500,"estimateTmv":false},"categories":{"market":"Luxury,Performance","EPAClass":"MIDSIZE_CARS","vehicleSize":"Midsize","primaryBodyType":"Car","vehicleStyle":"Sedan","vehicleType":"Car"},"id":17824,"name":"quattro Turbo 4dr Sedan AWD","year":{"id":3301,"year":1991},"submodel":{"body":"Sedan","modelName":"200 Sedan","niceName":"sedan"},"trim":"quattro","states":["USED"],"squishVins":["WAUGE544MN"],"MPG":{"highway":"22","city":"16"},"hashKey":"object:1891"}}'
		apiController.addNewVehicle()

		then: "Then a new driver, vehicle and overallStatistics should be created"
		def response = apiController.response.json
		response.status.name == "CREATED"
		response.id != null
	}

	void testAddNewVehicleFailure() {
		when: "We pass data to the addNewVehicle() method"

		def apiController = new ApiController()
		apiController.request.json = '{"dateOfBirth":{"year":1994,"month":2,"dayOfMonth":13},"gender":21,"country":"Ireland","carData":{"make":{"id":200000001,"name":"Audi","niceName":"audi"},"model":{"id":"Audi_200","name":"200","niceName":"200"},"engine":{"id":"200654469","name":"Engine","equipmentType":"ENGINE","compressionRatio":9,"cylinder":5,"size":2.2,"configuration":"inline","fuelType":"regular unleaded","horsepower":217,"torque":228,"type":"gas","code":"5ITCG2.2","compressorType":"turbocharger","rpm":{"horsepower":5700,"torque":1950}},"transmission":{"id":"200654468","name":"5M","equipmentType":"TRANSMISSION","transmissionType":"MANUAL","numberOfSpeeds":"5"},"drivenWheels":"all wheel drive","numOfDoors":"4","options":[],"colors":[{"category":"Exterior","options":[{"id":"200654483","name":"Titanium Gray Metallic","equipmentType":"COLOR","manufactureOptionName":"Titanium Gray Metallic","manufactureOptionCode":"000"},{"id":"200654482","name":"Amarena Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Amarena Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654477","name":"Indigo Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Indigo Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654486","name":"Pearl White Metallic","equipmentType":"COLOR","manufactureOptionName":"Pearl White Metallic","manufactureOptionCode":"000"},{"id":"200654472","name":"Bamboo Metallic","equipmentType":"COLOR","manufactureOptionName":"Bamboo Metallic","manufactureOptionCode":"000"},{"id":"200654485","name":"Zycalm Red Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Zycalm Red Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654484","name":"Tornado Red","equipmentType":"COLOR","manufactureOptionName":"Tornado Red","manufactureOptionCode":"000"},{"id":"200654479","name":"Opal Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Opal Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654478","name":"Lago Blue Metallic","equipmentType":"COLOR","manufactureOptionName":"Lago Blue Metallic","manufactureOptionCode":"000"},{"id":"200654475","name":"Crystal Silver Metallic","equipmentType":"COLOR","manufactureOptionName":"Crystal Silver Metallic","manufactureOptionCode":"000"},{"id":"200654476","name":"Glacier Blue Metallic","equipmentType":"COLOR","manufactureOptionName":"Glacier Blue Metallic","manufactureOptionCode":"000"},{"id":"200654481","name":"Alpine White","equipmentType":"COLOR","manufactureOptionName":"Alpine White","manufactureOptionCode":"000"},{"id":"200654470","name":"Papyrus Metallic","equipmentType":"COLOR","manufactureOptionName":"Papyrus Metallic","manufactureOptionCode":"000"},{"id":"200654480","name":"Panther Black Metallic","equipmentType":"COLOR","manufactureOptionName":"Panther Black Metallic","manufactureOptionCode":"000"},{"id":"200654473","name":"Black","equipmentType":"COLOR","manufactureOptionName":"Black","manufactureOptionCode":"000"},{"id":"200654471","name":"Aquamarine Metallic","equipmentType":"COLOR","manufactureOptionName":"Aquamarine Metallic","manufactureOptionCode":"000"},{"id":"200654474","name":"Cayenne Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Cayenne Pearl Metallic","manufactureOptionCode":"000"}]}],"price":{"usedTmvRetail":2000,"usedPrivateParty":1063,"usedTradeIn":500,"estimateTmv":false},"categories":{"market":"Luxury,Performance","EPAClass":"MIDSIZE_CARS","vehicleSize":"Midsize","primaryBodyType":"Car","vehicleStyle":"Sedan","vehicleType":"Car"},"id":17824,"name":"quattro Turbo 4dr Sedan AWD","year":{"id":3301,"year":1991},"submodel":{"body":"Sedan","modelName":"200 Sedan","niceName":"sedan"},"trim":"quattro","states":["USED"],"squishVins":["WAUGE544MN"],"MPG":{"highway":"22","city":"16"},"hashKey":"object:1891"}}'
		apiController.addNewVehicle()

		then: "Then a new driver, vehicle and overallStatistics should not be created"
		def response = apiController.response.json
		response.status.name == "NOT_ACCEPTABLE"
		response.id == null
	}

	void testAddNewVehicleFailure2() {
		when: "We pass data to the addNewVehicle() method"

		def apiController = new ApiController()
		apiController.request.json = '{"dateOfBirth":{"year":null,"month":2,"dayOfMonth":13},"gender":"female","country":"Ireland","carData":{"make":{"id":200000001,"name":"Audi","niceName":"audi"},"model":{"id":"Audi_200","name":"200","niceName":"200"},"engine":{"id":"200654469","name":"Engine","equipmentType":"ENGINE","compressionRatio":9,"cylinder":5,"size":2.2,"configuration":"inline","fuelType":"regular unleaded","horsepower":217,"torque":228,"type":"gas","code":"5ITCG2.2","compressorType":"turbocharger","rpm":{"horsepower":5700,"torque":1950}},"transmission":{"id":"200654468","name":"5M","equipmentType":"TRANSMISSION","transmissionType":"MANUAL","numberOfSpeeds":"5"},"drivenWheels":"all wheel drive","numOfDoors":"4","options":[],"colors":[{"category":"Exterior","options":[{"id":"200654483","name":"Titanium Gray Metallic","equipmentType":"COLOR","manufactureOptionName":"Titanium Gray Metallic","manufactureOptionCode":"000"},{"id":"200654482","name":"Amarena Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Amarena Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654477","name":"Indigo Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Indigo Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654486","name":"Pearl White Metallic","equipmentType":"COLOR","manufactureOptionName":"Pearl White Metallic","manufactureOptionCode":"000"},{"id":"200654472","name":"Bamboo Metallic","equipmentType":"COLOR","manufactureOptionName":"Bamboo Metallic","manufactureOptionCode":"000"},{"id":"200654485","name":"Zycalm Red Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Zycalm Red Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654484","name":"Tornado Red","equipmentType":"COLOR","manufactureOptionName":"Tornado Red","manufactureOptionCode":"000"},{"id":"200654479","name":"Opal Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Opal Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654478","name":"Lago Blue Metallic","equipmentType":"COLOR","manufactureOptionName":"Lago Blue Metallic","manufactureOptionCode":"000"},{"id":"200654475","name":"Crystal Silver Metallic","equipmentType":"COLOR","manufactureOptionName":"Crystal Silver Metallic","manufactureOptionCode":"000"},{"id":"200654476","name":"Glacier Blue Metallic","equipmentType":"COLOR","manufactureOptionName":"Glacier Blue Metallic","manufactureOptionCode":"000"},{"id":"200654481","name":"Alpine White","equipmentType":"COLOR","manufactureOptionName":"Alpine White","manufactureOptionCode":"000"},{"id":"200654470","name":"Papyrus Metallic","equipmentType":"COLOR","manufactureOptionName":"Papyrus Metallic","manufactureOptionCode":"000"},{"id":"200654480","name":"Panther Black Metallic","equipmentType":"COLOR","manufactureOptionName":"Panther Black Metallic","manufactureOptionCode":"000"},{"id":"200654473","name":"Black","equipmentType":"COLOR","manufactureOptionName":"Black","manufactureOptionCode":"000"},{"id":"200654471","name":"Aquamarine Metallic","equipmentType":"COLOR","manufactureOptionName":"Aquamarine Metallic","manufactureOptionCode":"000"},{"id":"200654474","name":"Cayenne Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Cayenne Pearl Metallic","manufactureOptionCode":"000"}]}],"price":{"usedTmvRetail":2000,"usedPrivateParty":1063,"usedTradeIn":500,"estimateTmv":false},"categories":{"market":"Luxury,Performance","EPAClass":"MIDSIZE_CARS","vehicleSize":"Midsize","primaryBodyType":"Car","vehicleStyle":"Sedan","vehicleType":"Car"},"id":17824,"name":"quattro Turbo 4dr Sedan AWD","year":{"id":3301,"year":1991},"submodel":{"body":"Sedan","modelName":"200 Sedan","niceName":"sedan"},"trim":"quattro","states":["USED"],"squishVins":["WAUGE544MN"],"MPG":{"highway":"22","city":"16"},"hashKey":"object:1891"}}'
		apiController.addNewVehicle()

		then: "Then a new driver, vehicle and overallStatistics should not be created"
		def response = apiController.response.json
		response.status.name == "NOT_ACCEPTABLE"
		response.id == null
	}
	
//	void testGetVehicleInfoSuccess() {
//		when: "We pass data to the addNewVehicle() method and then request that vehicles data"
//
//		def apiController = new ApiController()
//		apiController.request.json = '{"dateOfBirth":{"year":1994,"month":2,"dayOfMonth":13},"gender":"female","country":"Ireland","carData":{"make":{"id":200000001,"name":"Audi","niceName":"audi"},"model":{"id":"Audi_200","name":"200","niceName":"200"},"engine":{"id":"200654469","name":"Engine","equipmentType":"ENGINE","compressionRatio":9,"cylinder":5,"size":2.2,"configuration":"inline","fuelType":"regular unleaded","horsepower":217,"torque":228,"type":"gas","code":"5ITCG2.2","compressorType":"turbocharger","rpm":{"horsepower":5700,"torque":1950}},"transmission":{"id":"200654468","name":"5M","equipmentType":"TRANSMISSION","transmissionType":"MANUAL","numberOfSpeeds":"5"},"drivenWheels":"all wheel drive","numOfDoors":"4","options":[],"colors":[{"category":"Exterior","options":[{"id":"200654483","name":"Titanium Gray Metallic","equipmentType":"COLOR","manufactureOptionName":"Titanium Gray Metallic","manufactureOptionCode":"000"},{"id":"200654482","name":"Amarena Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Amarena Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654477","name":"Indigo Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Indigo Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654486","name":"Pearl White Metallic","equipmentType":"COLOR","manufactureOptionName":"Pearl White Metallic","manufactureOptionCode":"000"},{"id":"200654472","name":"Bamboo Metallic","equipmentType":"COLOR","manufactureOptionName":"Bamboo Metallic","manufactureOptionCode":"000"},{"id":"200654485","name":"Zycalm Red Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Zycalm Red Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654484","name":"Tornado Red","equipmentType":"COLOR","manufactureOptionName":"Tornado Red","manufactureOptionCode":"000"},{"id":"200654479","name":"Opal Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Opal Pearl Metallic","manufactureOptionCode":"000"},{"id":"200654478","name":"Lago Blue Metallic","equipmentType":"COLOR","manufactureOptionName":"Lago Blue Metallic","manufactureOptionCode":"000"},{"id":"200654475","name":"Crystal Silver Metallic","equipmentType":"COLOR","manufactureOptionName":"Crystal Silver Metallic","manufactureOptionCode":"000"},{"id":"200654476","name":"Glacier Blue Metallic","equipmentType":"COLOR","manufactureOptionName":"Glacier Blue Metallic","manufactureOptionCode":"000"},{"id":"200654481","name":"Alpine White","equipmentType":"COLOR","manufactureOptionName":"Alpine White","manufactureOptionCode":"000"},{"id":"200654470","name":"Papyrus Metallic","equipmentType":"COLOR","manufactureOptionName":"Papyrus Metallic","manufactureOptionCode":"000"},{"id":"200654480","name":"Panther Black Metallic","equipmentType":"COLOR","manufactureOptionName":"Panther Black Metallic","manufactureOptionCode":"000"},{"id":"200654473","name":"Black","equipmentType":"COLOR","manufactureOptionName":"Black","manufactureOptionCode":"000"},{"id":"200654471","name":"Aquamarine Metallic","equipmentType":"COLOR","manufactureOptionName":"Aquamarine Metallic","manufactureOptionCode":"000"},{"id":"200654474","name":"Cayenne Pearl Metallic","equipmentType":"COLOR","manufactureOptionName":"Cayenne Pearl Metallic","manufactureOptionCode":"000"}]}],"price":{"usedTmvRetail":2000,"usedPrivateParty":1063,"usedTradeIn":500,"estimateTmv":false},"categories":{"market":"Luxury,Performance","EPAClass":"MIDSIZE_CARS","vehicleSize":"Midsize","primaryBodyType":"Car","vehicleStyle":"Sedan","vehicleType":"Car"},"id":17824,"name":"quattro Turbo 4dr Sedan AWD","year":{"id":3301,"year":1991},"submodel":{"body":"Sedan","modelName":"200 Sedan","niceName":"sedan"},"trim":"quattro","states":["USED"],"squishVins":["WAUGE544MN"],"MPG":{"highway":"22","city":"16"},"hashKey":"object:1891"}}'
//		apiController.addNewVehicle()
//		def apiController2 = new ApiController()
//		def response = apiController.response.json
//		def slurper = new JsonSlurper()
//		def result = slurper.parseText('{"id": ' + respons.id + '}')
//		apiController2.request.json = result
//		apiController2.getVehicleInfo()
//		def response2 = apiController2.response.json
//
//		then: "Then a new driver, vehicle and overallStatistics should be created"
//		apiController2.response.status.name == "CREATED"
//	}
	
	void testAddNewJourneySuccess() {
		when: "A new vehicle is created"

		def driver = new Driver(gender: 'female',
			dateOfBirth: new Date(),
			country: 'United States',
			year: 1974)
		
		driver.save(flush: true)
		
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
		
		overallStatistics.save(flush: true)
		
		def vehicle = new Vehicle("identifier": 'Fofm2hGFk',
		"driver": driver,
		"overallStatistics": overallStatistics,
		"year": 2006,
		"make": 'BMW',
		"model": '320d',
		"engineConfiguration": 'inline',
		"compressionRatio": 9.5,
		"engineDisplacement": 1999,
		"engineSize": 2.0,
		"cylinders": 4,
		"manufacturerEngineCode": 'ARC',
		"fuelType": 'regular unleaded',
		"horsepower": 170,
		"torque": 170,
		"totalEngineValves": 16,
		"transmissionType": 'MANUAL',
		"numberOfSpeeds": 5,
		"drivenWheels": 'rear',
		"vehicleClass": 'Compact Cars',
		"vehicleStyle": 'Coupe',
		"numOfDoors": 2,
		"mpgHighway": 24,
		"mpgCity": 18,
		"newPrice": 43423,
		"usedPrice": 25838,
		"colourNames": [],
		"colourCodes": [],
		"features": [])
		
		then: "the vehicle is saved"
		vehicle.save(flush: true)
								
		when: "We pass journey data, vehicle id and driver data to the addNewJourney() method"
		def apiController = new ApiController()
		apiController.request.json = '{"vehicleID":"Fofm2hGFk","journeyData":["410C1120","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D29","41140000","41150000","411100","4104EF","410D2E","41140000","41150000","411100","4104EF","410D33","41140000","41150000","411100","410C1120","4104EF","410D38","41140000","41150000","411100","410C1120","4104EF","410D3E","41140000","41150000","411100","410C1120","4104EF","410D44","41140000","41150000","411100","410C1120","4104EF","410D49","41140000","41150000","411100","410C1120","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","410C1194","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","410C121C","4104EF","410D4A","41140000","41150000","411100","4300","410C1250","4104EF","410D4A","41140000","41150000","411100","410C1294","4104EF","410D4A","41140000","41150000","411100","410C12C4","4104EF","410D4A","41140000","41150000","411100","410C12CC","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","410C3F0C","4104EF","410D4A","41140000","41150000","411100","410C3F24","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","410C3FAC","4104EF","410D4A","41140000","41150000","411100","410C3FF0","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","410C4078","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4F","41140000","41150000","411100","410C40A8","4104EF","410D51","41140000","41150000","411100","410C40A8","4104EF","410D52","41140000","41150000","411100","410C40A8","4104EF","410D52","41140000","41150000","41110A","4104EF","410D52","41140000","41150000","411102","410C40A8","4104EF","410D52","41140000","41150000","411107","410C40A8","4104EF","410D52","41140000","41150000","41110A","410C40A8","4104EF","410D52","41140000","41150000","411105","410C40A8","4104EF","410D52","41140000","41150000","41110A","410C40A8","4104EF","410D52","41140000","41150000","411107","410C40A8","4104EF","410D52","41140000","41150000","411105","410C40A8","4104EF","410D52","41140000","41150000","41110A","410C40A8","4104EF","410D52","41140000","41150000","411107","410C40A8","4104EF","410D51","41140000","41150000","411105","410C40A8","4104EF","410D4E","41140000","41150000","411105","410C40A8","4104EF","410D42","41140000","41150000","411105","4104EF","410D31","41140000","41150000","411105","410C40A8","4104EF","410D20","41140000","41150000","411105","410C40A8","4104EF","410D14","41140000","41150000","411105","410C40A8","4104EF","410D03","41140000","41150000","411105","410C40A8","4104EF","410D00","41140000","41150000","411105","410C40A8","4104EF","410D01","41140000","41150000","411105","4104EF","410D02","41140000","41150000","411105","410C40A8","4104EF","410D09","41140000","41150000","411105","4104EF","410D0B","41140000","41150000","411105","410C40A8","4104EF","410D0C","41140000","41150000","411105","410C40A8","4104EF","410D0B","41140000","41150000","411105","410C40A8","4104EF","410D07","41140000","41150000","411105","4162AF","4300","410C40A8","4104EF","410D03","41140000","41150000","411105","410C40A8","4104EF","410D02","41140000","41150000","411105","410C40A8","4104EF","410D01","41140000","41150000","411105","4104EF","410D00","41140000","41150000","411100","41058C","410C40A8","4104EF","410D00","41140000","41150000","411100","410C40A8","4104EF","410D00","41140000","41150000","411102","410C40A8","4104EF","410D02","41140000","41150000","411100","410C40A8","4104EF","410D04","41140000","41150000","411100","410C40A8","4104EF","410D0A","41140000","41150000","411100","410C40A8","4104EF","410D0D","41140000","41150000","411100","410C40A8","4104EF","410D0D","41140000","41150000","411102","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410A32","410F55","410C40A8","4104EF","410D0D","41140000","41150000","41110F","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","4300","410C40A8","4104EF","410D0D","41140000","41150000","41110F","4104EF","410D0D","41140000","41150000","41110F","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F"],"startTime":{"year":2016,"month":3,"dayOfMonth":10,"hourOfDay":10,"minute":33,"second":50},"endTime":{"year":2016,"month":3,"dayOfMonth":10,"hourOfDay":10,"minute":35,"second":50}}'
		apiController.addNewJourney()


		then: "Then a new driver and a journey should be created"
		def response = apiController.response.json
		response.status.name == "CREATED"
		Vehicle.list().size() == 1
		OverallStatistics.list().size() == 1
		Driver.list().size() == 1
		Journey.list().size() == 1
		Sensor.list().size() >= 1
		Point.list().size() >= 1
		def savedOverallStatistics = OverallStatistics.list()[0];
		savedOverallStatistics.heavyBrakingCount == 1
		savedOverallStatistics.heavyAccelerationCount == 0
		savedOverallStatistics.averagePercentageIdle == 10
		savedOverallStatistics.averageGForce == 0.0
		savedOverallStatistics.topAccelerationGforce == 0.0
		savedOverallStatistics.topDecelerationGforce == 0.0
		savedOverallStatistics.topSpeed == 82
		savedOverallStatistics.averageSpeed == 42
		savedOverallStatistics.topRPM == 4138
		savedOverallStatistics.averageRPM == 3252
		savedOverallStatistics.averagePercentageHighRPM == 70
		savedOverallStatistics.averageEngineLoad == 93
		savedOverallStatistics.averageThrottlePosition == 1
		savedOverallStatistics.averagePercentageCoasting == 68
	}
	
	void testAddNewJourneySuccess2() {
		when: "A new vehicle is created"

		def driver = new Driver(gender: 'male',
			dateOfBirth: new Date(),
			country: 'Ireland',
			year: 1993)
		
		driver.save(flush: true)
		
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
		
		overallStatistics.save(flush: true)
		
		def vehicle = new Vehicle("identifier": 'SyZ8UCSJf',
		"driver": driver,
		"overallStatistics": overallStatistics,
		"year": 2002,
		"make": 'Honda',
		"model": 'Civic',
		"engineConfiguration": 'inline',
		"compressionRatio": 9.5,
		"engineDisplacement": 1398,
		"engineSize": 1.4,
		"cylinders": 4,
		"manufacturerEngineCode": 'HC',
		"fuelType": 'regular unleaded',
		"horsepower": 90,
		"torque": 110,
		"totalEngineValves": 16,
		"transmissionType": 'MANUAL',
		"numberOfSpeeds": 5,
		"drivenWheels": 'rear',
		"vehicleClass": 'Compact Cars',
		"vehicleStyle": '2dr Hatchback',
		"numOfDoors": 2,
		"mpgHighway": 34,
		"mpgCity": 28,
		"newPrice": 13423,
		"usedPrice": 8838,
		"colourNames": [],
		"colourCodes": [],
		"features": [])
		
		then: "the vehicle is saved"
		vehicle.save(flush: true)
								
		when: "We pass journey data, vehicle id and driver data to the addNewJourney() method"
		def apiController = new ApiController()
		apiController.request.json = '{"vehicleID":"SyZ8UCSJf","journeyData":["410C438C","410C438C","4104A8","410D85","41140000","41150000","4111BA","410C438C","4104A8","410D85","41140000","41150000","4111BA","410C438C","4104A8","410D21","41140000","41150000","4111BA","410C438C","4104A8","410D21","41140000","41150000","4111BA","410C438C","4104A8","410D22","41140000","41150000","4111BA","410C438C","4104A8","410D21","41140000","41150000","4111BA","410C438C","4104A8","410D21","41140000","41150000","4111BA","410C438C","4104A8","410D22","41140000","41150000","4111BA","410C438C","4104A8","410D21","41140000","41150000","4111BA","4104A8","410D26","41140000","41150000","4111BA","4104A8","410D32","41140000","41150000","4111BA","410C438C","4104A8","410D3E","41140000","41150000","4111BA","410C438C","4104A8","410D4F","41140000","41150000","4111BA","410C438C","4104A8","410D5B","41140000","41150000","4111BA","410C438C","4104A8","410D6C","41140000","41150000","4111BA","410C438C","4104A8","410D7D","41140000","41150000","4111BA","4104A8","410D7A","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C4390","4104A8","410D7D","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C43C8","4104A8","410D7C","41140000","41150000","4111BA","4300","410C4410","4104A8","410D7C","41140000","41150000","4111BA","410C4440","4104A8","410D7C","41140000","41150000","4111BA","410C4470","4104A8","410D7C","41140000","41150000","4111BA","410C44B4","4104A8","410D7C","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C4528","4104A8","410D7C","41140000","41150000","4111BA","410C456C","4104A8","410D7C","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C45E0","4104A8","410D7C","41140000","41150000","4111BA","410C4624","4104A8","410D7C","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C4698","4104A8","410D7C","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C470C","4104A8","410D7C","41140000","41150000","4111BA","410C473C","4104A8","410D7C","41140000","41150000","4111BA","410C4780","4104A8","410D7C","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C47C8","4104A8","410D7C","41140000","41150000","4111BA","410C47D0","4104A8","410D7C","41140000","41150000","4111BA","410C47CC","4104A8","410D7C","41140000","41150000","4111BA","410C1918","4104A8","410D7C","41140000","41150000","4111BA","410C191C","4104A8","410D7C","41140000","41150000","4111BA","410C192C","4104A8","410D7C","41140000","41150000","4111BA","410C192C","4104A8","410D7C","41140000","41150000","4111BA","410C192C","4104A8","410D7C","41140000","41150000","4111BA","410C192C","41049B","410D7C","41140000","41150000","4111BA","410C192C","410489","410D7C","41140000","41150000","4111BA","410C192C","41045E","410D7C","41140000","41150000","4111BA","410433","410D7C","41140000","41150000","4111BA","410C192C","410414","410D7C","41140000","41150000","4111BA","410C192C","410400","410D7C","41140000","41150000","4111BA","410C192C","410400","410D7C","41140000","41150000","4111BA","410C192C","410400","410D7C","41140000","41150000","4111BA","410C192C","410400","410D7C","41140000","41150000","4111BA","410400","410D7C","41140000","41150000","4111BA","410C192C","410400","410D7C","41140000","41150000","41116B","410400","410D7C","41140000","41150000","411100","410C192C","410400","410D7C","41140000","41150000"],"startTime":{"year":2016,"month":3,"dayOfMonth":10,"hourOfDay":14,"minute":15,"second":51},"endTime":{"year":2016,"month":3,"dayOfMonth":10,"hourOfDay":14,"minute":17,"second":14}}'
		apiController.addNewJourney()


		then: "Then a new driver and a journey should be created"
		def response = apiController.response.json
		response.status.name == "CREATED"
		Vehicle.list().size() == 1
		OverallStatistics.list().size() == 1
		Driver.list().size() == 1
		Journey.list().size() == 1
		Sensor.list().size() >= 1
		Point.list().size() >= 1
		def savedOverallStatistics = OverallStatistics.list()[0];
		savedOverallStatistics.heavyBrakingCount == 1
		savedOverallStatistics.heavyAccelerationCount == 1
		savedOverallStatistics.averagePercentageIdle == 0
		savedOverallStatistics.averageGForce == 0.1
		savedOverallStatistics.topAccelerationGforce == 0.0
		savedOverallStatistics.topDecelerationGforce == 4.0
		savedOverallStatistics.topSpeed == 133
		savedOverallStatistics.averageSpeed == 108
		savedOverallStatistics.topRPM == 4596
		savedOverallStatistics.averageRPM == 3510
		savedOverallStatistics.averagePercentageHighRPM == 68
		savedOverallStatistics.averageEngineLoad == 53
		savedOverallStatistics.averageThrottlePosition == 70
		savedOverallStatistics.averagePercentageCoasting == 1
	}
	
	void testAddNewJourneySuccess3() {
		when: "A new vehicle is created"

		def driver = new Driver(gender: 'female',
			dateOfBirth: new Date(),
			country: 'United States',
			year: 1974)
		
		driver.save(flush: true)
		
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
		
		overallStatistics.save(flush: true)
		
		def vehicle = new Vehicle("identifier": 'TRZ8UCSJf',
		"driver": driver,
		"overallStatistics": overallStatistics,
		"year": 2006,
		"make": 'BMW',
		"model": '320d',
		"engineConfiguration": 'inline',
		"compressionRatio": 9.5,
		"engineDisplacement": 1999,
		"engineSize": 2.0,
		"cylinders": 4,
		"manufacturerEngineCode": 'ARC',
		"fuelType": 'regular unleaded',
		"horsepower": 170,
		"torque": 170,
		"totalEngineValves": 16,
		"transmissionType": 'MANUAL',
		"numberOfSpeeds": 5,
		"drivenWheels": 'rear',
		"vehicleClass": 'Compact Cars',
		"vehicleStyle": 'Coupe',
		"numOfDoors": 2,
		"mpgHighway": 24,
		"mpgCity": 18,
		"newPrice": 43423,
		"usedPrice": 25838,
		"colourNames": [],
		"colourCodes": [],
		"features": [])
		
		then: "the vehicle is saved"
		vehicle.save(flush: true)
								
		when: "We pass journey data, vehicle id and driver data to the addNewJourney() method"
		def apiController = new ApiController()
		apiController.request.json = '{"vehicleID":"TRZ8UCSJf","journeyData":["410C1120","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D28","41140000","41150000","411100","410C1120","4104EF","410D29","41140000","41150000","411100","4104EF","410D2E","41140000","41150000","411100","4104EF","410D33","41140000","41150000","411100","410C1120","4104EF","410D38","41140000","41150000","411100","410C1120","4104EF","410D3E","41140000","41150000","411100","410C1120","4104EF","410D44","41140000","41150000","411100","410C1120","4104EF","410D49","41140000","41150000","411100","410C1120","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","410C1194","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","410C121C","4104EF","410D4A","41140000","41150000","411100","4300","410C1250","4104EF","410D4A","41140000","41150000","411100","410C1294","4104EF","410D4A","41140000","41150000","411100","410C12C4","4104EF","410D4A","41140000","41150000","411100","410C12CC","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","410C3F0C","4104EF","410D4A","41140000","41150000","411100","410C3F24","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","410C3FAC","4104EF","410D4A","41140000","41150000","411100","410C3FF0","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4A","41140000","41150000","411100","410C4078","4104EF","410D4A","41140000","41150000","411100","4104EF","410D4F","41140000","41150000","411100","410C40A8","4104EF","410D51","41140000","41150000","411100","410C40A8","4104EF","410D52","41140000","41150000","411100","410C40A8","4104EF","410D52","41140000","41150000","41110A","4104EF","410D52","41140000","41150000","411102","410C40A8","4104EF","410D52","41140000","41150000","411107","410C40A8","4104EF","410D52","41140000","41150000","41110A","410C40A8","4104EF","410D52","41140000","41150000","411105","410C40A8","4104EF","410D52","41140000","41150000","41110A","410C40A8","4104EF","410D52","41140000","41150000","411107","410C40A8","4104EF","410D52","41140000","41150000","411105","410C40A8","4104EF","410D52","41140000","41150000","41110A","410C40A8","4104EF","410D52","41140000","41150000","411107","410C40A8","4104EF","410D51","41140000","41150000","411105","410C40A8","4104EF","410D4E","41140000","41150000","411105","410C40A8","4104EF","410D42","41140000","41150000","411105","4104EF","410D31","41140000","41150000","411105","410C40A8","4104EF","410D20","41140000","41150000","411105","410C40A8","4104EF","410D14","41140000","41150000","411105","410C40A8","4104EF","410D03","41140000","41150000","411105","410C40A8","4104EF","410D00","41140000","41150000","411105","410C40A8","4104EF","410D01","41140000","41150000","411105","4104EF","410D02","41140000","41150000","411105","410C40A8","4104EF","410D09","41140000","41150000","411105","4104EF","410D0B","41140000","41150000","411105","410C40A8","4104EF","410D0C","41140000","41150000","411105","410C40A8","4104EF","410D0B","41140000","41150000","411105","410C40A8","4104EF","410D07","41140000","41150000","411105","4162AF","4300","410C40A8","4104EF","410D03","41140000","41150000","411105","410C40A8","4104EF","410D02","41140000","41150000","411105","410C40A8","4104EF","410D01","41140000","41150000","411105","4104EF","410D00","41140000","41150000","411100","41058C","410C40A8","4104EF","410D00","41140000","41150000","411100","410C40A8","4104EF","410D00","41140000","41150000","411102","410C40A8","4104EF","410D02","41140000","41150000","411100","410C40A8","4104EF","410D04","41140000","41150000","411100","410C40A8","4104EF","410D0A","41140000","41150000","411100","410C40A8","4104EF","410D0D","41140000","41150000","411100","410C40A8","4104EF","410D0D","41140000","41150000","411102","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410A32","410F55","410C40A8","4104EF","410D0D","41140000","41150000","41110F","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","4300","410C40A8","4104EF","410D0D","41140000","41150000","41110F","4104EF","410D0D","41140000","41150000","41110F","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F","410C40A8","4104EF","410D0D","41140000","41150000","41110F"],"startTime":{"year":2016,"month":3,"dayOfMonth":10,"hourOfDay":10,"minute":33,"second":50},"endTime":{"year":2016,"month":3,"dayOfMonth":10,"hourOfDay":10,"minute":35,"second":50}}'
		apiController.addNewJourney()

		then: "Then a new driver and a journey should be created"
		def response = apiController.response.json
		response.status.name == "CREATED"
		Vehicle.list().size() == 1
		OverallStatistics.list().size() == 1
		Driver.list().size() == 1
		Journey.list().size() == 1
		Sensor.list().size() >= 1
		Point.list().size() >= 1
		def savedOverallStatistics = OverallStatistics.list()[0];
		savedOverallStatistics.heavyBrakingCount == 1
		savedOverallStatistics.heavyAccelerationCount == 0
		savedOverallStatistics.averagePercentageIdle == 10
		savedOverallStatistics.averageGForce == 0.0
		savedOverallStatistics.topAccelerationGforce == 0.0
		savedOverallStatistics.topDecelerationGforce == 0.0
		savedOverallStatistics.topSpeed == 82
		savedOverallStatistics.averageSpeed == 42
		savedOverallStatistics.topRPM == 4138
		savedOverallStatistics.averageRPM == 3252
		savedOverallStatistics.averagePercentageHighRPM == 70
		savedOverallStatistics.averageEngineLoad == 93
		savedOverallStatistics.averageThrottlePosition == 1
		savedOverallStatistics.averagePercentageCoasting == 68
				
		when: "We pass journey data, vehicle id and driver data to the addNewJourney() method"
		def apiController2 = new ApiController()
		apiController2.request.json = '{"vehicleID":"TRZ8UCSJf","journeyData":["4104A8","410D21","41140000","41150000","4111BA","410C438C","4104A8","410D21","41140000","41150000","4111BA","410C438C","4104A8","410D22","41140000","41150000","4111BA","410C438C","4104A8","410D21","41140000","41150000","4111BA","410C438C","4104A8","410D21","41140000","41150000","4111BA","410C438C","4104A8","410D22","41140000","41150000","4111BA","410C438C","4104A8","410D21","41140000","41150000","4111BA","4104A8","410D26","41140000","41150000","4111BA","4104A8","410D32","41140000","41150000","4111BA","410C438C","4104A8","410D3E","41140000","41150000","4111BA","410C438C","4104A8","410D4F","41140000","41150000","4111BA","410C438C","4104A8","410D5B","41140000","41150000","4111BA","410C438C","4104A8","410D6C","41140000","41150000","4111BA","410C438C","4104A8","410D7D","41140000","41150000","4111BA","4104A8","410D7A","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C4390","4104A8","410D7D","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C43C8","4104A8","410D7C","41140000","41150000","4111BA","4300","410C4410","4104A8","410D7C","41140000","41150000","4111BA","410C4440","4104A8","410D7C","41140000","41150000","4111BA","410C4470","4104A8","410D7C","41140000","41150000","4111BA","410C44B4","4104A8","410D7C","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C4528","4104A8","410D7C","41140000","41150000","4111BA","410C456C","4104A8","410D7C","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C45E0","4104A8","410D7C","41140000","41150000","4111BA","410C4624","4104A8","410D7C","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C4698","4104A8","410D7C","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C470C","4104A8","410D7C","41140000","41150000","4111BA","410C473C","4104A8","410D7C","41140000","41150000","4111BA","410C4780","4104A8","410D7C","41140000","41150000","4111BA","4104A8","410D7C","41140000","41150000","4111BA","410C47C8","4104A8","410D7C","41140000","41150000","4111BA","410C47D0","4104A8","410D7C","41140000","41150000","4111BA","410C47CC","4104A8","410D7C","41140000","41150000","4111BA","410C1918","4104A8","410D7C","41140000","41150000","4111BA","410C191C","4104A8","410D7C","41140000","41150000","4111BA","410C192C","4104A8","410D7C","41140000","41150000","4111BA","410C192C","4104A8","410D7C","41140000","41150000","4111BA","410C192C","4104A8","410D7C","41140000","41150000","4111BA","410C192C","41049B","410D7C","41140000","41150000","4111BA","410C192C","410489","410D7C","41140000","41150000","4111BA","410C192C","41045E","410D7C","41140000","41150000","4111BA","410433","410D7C","41140000","41150000","4111BA","410C192C","410414","410D7C","41140000","41150000","4111BA","410C192C","410400","410D7C","41140000","41150000","4111BA","410C192C","410400","410D7C","41140000","41150000","4111BA","410C192C","410400","410D7C","41140000","41150000","4111BA","410C192C","410400","410D7C","41140000","41150000","4111BA","410400","410D7C","41140000","41150000","4111BA","410C192C","410400","410D7C","41140000","41150000","41116B","410400","410D7C","41140000","41150000","411100","410C192C","410400","410D7C","41140000","41150000"],"startTime":{"year":2016,"month":3,"dayOfMonth":10,"hourOfDay":14,"minute":15,"second":51},"endTime":{"year":2016,"month":3,"dayOfMonth":10,"hourOfDay":14,"minute":17,"second":14}}'
		apiController2.addNewJourney()

		then: "Then a new driver and a journey should be created"
		def response2 = apiController.response.json
		response2.status.name == "CREATED"
		Vehicle.list().size() == 1
		OverallStatistics.list().size() == 1
		Driver.list().size() == 1
		Journey.list().size() == 2
		Sensor.list().size() >= 1
		Point.list().size() >= 1
		def savedOverallStatistics2 = OverallStatistics.list()[0];
		savedOverallStatistics2.heavyBrakingCount == 2
		savedOverallStatistics2.heavyAccelerationCount == 0
		savedOverallStatistics2.averagePercentageIdle == 10
		savedOverallStatistics2.averageGForce == 0.0
		savedOverallStatistics2.topAccelerationGforce == 0.0
		savedOverallStatistics2.topDecelerationGforce == 0.0
		savedOverallStatistics2.topSpeed == 82
		savedOverallStatistics2.averageSpeed == 42
		savedOverallStatistics2.topRPM == 4138
		savedOverallStatistics2.averageRPM == 3252
		savedOverallStatistics2.averagePercentageHighRPM == 70
		savedOverallStatistics2.averageEngineLoad == 93
		savedOverallStatistics2.averageThrottlePosition == 1
		savedOverallStatistics2.averagePercentageCoasting == 68
	}
	
}
