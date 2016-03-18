package drive

import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController
import grails.transaction.Transactional
import groovy.json.JsonBuilder
import java.text.DateFormat
import java.text.SimpleDateFormat

@Transactional(readOnly = true)

class VehicleController {

	static allowedMethods = [create: "POST", save: "POST", delete: "DELETE"]


	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Vehicle.list(params), model:[vehicleInstanceCount: Vehicle.count()]
	}

	/**
	* This method returns data for all manufacturers.
	*/
	def manufacturers() {
		def criteria = Vehicle.createCriteria()
		def vehicleInstanceList = criteria.list {
		    projections {
		        distinct('make')
		    }
			order('make', 'desc')
		}
		
		return [makes: vehicleInstanceList]
	}

	/**
	 * This method returns data about a specific make of car - ie. Audi.
	 * @param max - The max number of results return to the view.
	 * @param id - The make of car to fetch the data for.
	 */
	def manufacturer(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		def criteria = Vehicle.createCriteria()
		def vehicleInstanceList = criteria.list(params) {
		    projections {
		        eq("make", params.id)
		    }
			order('model', 'desc')
		}
		
		// Statistics Data
		def manufacturerStats = criteria.list() {
			projections {
				eq("make", params.id)
			}
		}
		
		// Get the number of vehicles of the make
		def vehicleCount = manufacturerStats.size()
		
		// Get the number of models of a make
		def modelCount = manufacturerStats.model as Set
		
		// Get the number of models of a make
		def journeyCount = 0
		
		for(int i = 0; i < manufacturerStats.journeys.size(); i++)
		{
			if(manufacturerStats.journeys[i] != null)
			{
				journeyCount += manufacturerStats.journeys[i].size();
			}
		}
		
		def overallStatistics = manufacturerStats.overallStatistics as Set
						
		// Get the average vehicle age
		def vehicleAgeAverage = manufacturerStats.year.sum() / manufacturerStats.year.size()
		
		// Get the total driven hours for the vehicle make
		def totalHours = (overallStatistics.totalTimeLength.sum() / 3600)
		
		// Get the top speed for the vehicle make
		def averageSpeed = overallStatistics.averageSpeed.sum() / overallStatistics.averageSpeed.size()
		
		// Get the top recorded speed for the vehicle make
		def topSpeed = overallStatistics.topSpeed.max()
		
		// Get the average rpm for the vehicle make
		def averageRPM = overallStatistics.averageRPM.sum() / overallStatistics.averageRPM.size()
		
		// Get the top recorded  rpm for the vehicle make
		def topRPM = overallStatistics.topRPM.max()
		
		// Get the heavy acceleration count for the vehicle make
		def heavyAccelerationCount = overallStatistics.heavyAccelerationCount.sum()
		
		// Get the heavy braking count for the vehicle make
		def heavyBrakingCount = overallStatistics.heavyBrakingCount.sum()
		
		// Get the average engine load for the vehicle make
		def averageEngineLoad = overallStatistics.averageEngineLoad.sum() / overallStatistics.averageEngineLoad.size()
		
		// Get the average engine load for the vehicle make
		def averageThrottlePosition = overallStatistics.averageThrottlePosition.sum() / overallStatistics.averageThrottlePosition.size()
		
		// Get the average engine load for the vehicle make
		def averagePercentageIdle = overallStatistics.averagePercentageIdle.sum() / overallStatistics.averagePercentageIdle.size()
		
		// Get the average engine load for the vehicle make
		def averageGForce = overallStatistics.averageGForce.sum() / overallStatistics.averageGForce.size()
		
		// Get the top recorded  rpm for the vehicle make
		def topAccelerationGforce = overallStatistics.topAccelerationGforce.max()
		
		// Get the top recorded  rpm for the vehicle make
		def topDecelerationGforce = overallStatistics.topDecelerationGforce.max()
		
		// Get the average engine load for the vehicle make
		def averagePercentageCoasting = overallStatistics.averagePercentageCoasting.sum() / overallStatistics.averagePercentageCoasting.size()
		
		// Get the unique list of countries and their counts
		def countryList = manufacturerStats.driver.country as Set
		def countries = []
		
		for(int i = 0; i < countryList.size(); i++)
		{
			def entry = [countryList[i], manufacturerStats.driver.country.count(countryList[i])]
			countries << entry
		}
		
		// Get the unique list of countries and their counts
		def genderList = manufacturerStats.driver.gender as Set
		def genders = []
		
		for(int i = 0; i < countryList.size(); i++)
		{
			def entry = [genderList[i], manufacturerStats.driver.gender.count(genderList[i])]
			genders << entry
		}
		
		// Get the unique list of ages
		def ageList = manufacturerStats.driver.year as Set
		def ages = []
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		for(int i = 0; i < ageList.size(); i++)
		{
			def entry = [currentYear - ageList[i], manufacturerStats.driver.year.count(ageList[i])]
			ages << entry
		}
		
		respond vehicleInstanceList, model:[vehicleInstanceCount: manufacturerStats.size(), 
			make: vehicleInstanceList[0].make,
			vehicleCount: vehicleCount,
			modelCount: modelCount.size(),
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
			averageGForce: averageGForce,
			topAccelerationGforce: topAccelerationGforce,
			topDecelerationGforce: topDecelerationGforce,
			averagePercentageCoasting: averagePercentageCoasting,
			countries: countries,
			genders: genders,
			ages: ages]
	}

	/**
	 * This method returns data about a specific car based on Identifier.
	 * @param max - The max number of results return to the view.
	 * @param id - The make of car to fetch the data for.
	 */
	def show(Integer max) {
		def criteria = Vehicle.createCriteria()
		def vehicleInstance = criteria.list() {
			projections {
				eq("identifier", params.id)
			}
		}
		
		if(vehicleInstance[0] == null)
		{
			render(view:'/404')
		}
		else
		{
			respond vehicleInstance[0], model:[journeys: vehicleInstance[0].journeys.sort{it.startTime}.reverse()]
		}
	}


	@Transactional
	def delete(Vehicle vehicleInstance) {

		if (vehicleInstance == null) {
			notFound()
			return
		}

		vehicleInstance.delete flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'Vehicle.label', default: 'Vehicle'),
					vehicleInstance.id
				])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}

	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'vehicle.label', default: 'Vehicle'),
					params.id
				])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
