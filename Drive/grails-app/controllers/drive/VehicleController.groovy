package drive

import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController
import grails.transaction.Transactional
import groovy.json.JsonBuilder
import java.text.DateFormat
import java.text.SimpleDateFormat

@Transactional(readOnly = true)

class VehicleController {
	
	def vehicleService

	static allowedMethods = [create: "POST", save: "POST", delete: "DELETE"]


	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Vehicle.list(params), model:[vehicleInstanceCount: Vehicle.count()]
	}

	/**
	* This method returns the list of all manufacturers.
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
	 * This method returns the list off all vehicle engine sizes.
	 */
	 def engineSizes() {
		 def criteria = Vehicle.createCriteria()
		 def vehicleInstanceList = criteria.list {
			 projections {
				 distinct('engineSize')
			 }
			 order('engineSize', 'desc')
		 }
		 		 
		 return [engineSizes: vehicleInstanceList]
	 }
	 
	 /**
	  * This method returns the list off all vehicle engine sizes.
	  * @param max - The max number of results return to the view.
	  * @param id - The make of car to fetch the data for.
	  */
	 def showEngineSize(Integer max) {
		 params.max = Math.min(max ?: 10, 100)
		 def criteria = Vehicle.createCriteria()
		 def vehicleInstanceList = criteria.list(params) {
			 projections {
				 eq("engineSize", params.id)
			 }
			 order('engineSize', 'desc')
		 }
		 
		 // Statistics Data
		 def vehicles = criteria.list() {
			 projections {
				 eq("engineSize", params.id)
			 }
		 }
		 			 			  
		 def statistics = vehicleService.getStatistics(vehicles)
		 
		 respond vehicleInstanceList, model:[vehicleInstanceCount: vehicles.size(),
			 engineSize: vehicleInstanceList[0].engineSize,
			 vehicleCount: statistics.vehicleCount,
			 modelCount: statistics.modelCount.size(),
			 journeyCount: statistics.journeyCount,
			 vehicleAgeAverage: statistics.vehicleAgeAverage,
			 totalHours: statistics.totalHours,
			 averageSpeed: statistics.averageSpeed,
			 averageRPM: statistics.averageRPM,
			 heavyAccelerationCount: statistics.heavyAccelerationCount,
			 heavyBrakingCount: statistics.heavyBrakingCount,
			 topSpeed: statistics.topSpeed,
			 topRPM: statistics.topRPM,
			 averageEngineLoad: statistics.averageEngineLoad,
			 averageThrottlePosition: statistics.averageThrottlePosition,
			 averagePercentageIdle: statistics.averagePercentageIdle,
			 averageGForce: statistics.averageGForce,
			 averagePercentageHighRPM: statistics.averagePercentageHighRPM,
			 topAccelerationGforce: statistics.topAccelerationGforce,
			 topDecelerationGforce: statistics.topDecelerationGforce,
			 averagePercentageCoasting: statistics.averagePercentageCoasting,
			 countries: statistics.countries,
			 genders: statistics.genders,
			 ages: statistics.ages]
	 }
	 
	 /**
	  * This method returns the list off all vehicle transmission types.
	  */
	  def transmissions() {
		  def criteria = Vehicle.createCriteria()
		  def vehicleInstanceList = criteria.list {
			  projections {
				  distinct('transmissionType')
			  }
			  order('transmissionType', 'desc')
		  }
				   
		  return [transmissions: vehicleInstanceList]
	  }
	  
	  /**
	   * This method returns the list off all vehicle transmission types.
	   * @param max - The max number of results return to the view.
	   * @param id - The make of car to fetch the data for.
	   */
	  def showTransmissionType(Integer max) {
		  params.max = Math.min(max ?: 10, 100)
		  def criteria = Vehicle.createCriteria()
		  def vehicleInstanceList = criteria.list(params) {
			  projections {
				  eq("transmissionType", params.id)
			  }
			  order('transmissionType', 'desc')
		  }
		  
		  // Statistics Data
		  def vehicles = criteria.list() {
			  projections {
				  eq("transmissionType", params.id)
			  }
		  }
			  						
		  def statistics = vehicleService.getStatistics(vehicles)
		  
		  respond vehicleInstanceList, model:[vehicleInstanceCount: vehicles.size(),
			  transmissionType: vehicleInstanceList[0].transmissionType,
			  vehicleCount: statistics.vehicleCount,
			  modelCount: statistics.modelCount.size(),
			  journeyCount: statistics.journeyCount,
			  vehicleAgeAverage: statistics.vehicleAgeAverage,
			  totalHours: statistics.totalHours,
			  averageSpeed: statistics.averageSpeed,
			  averageRPM: statistics.averageRPM,
			  heavyAccelerationCount: statistics.heavyAccelerationCount,
			  heavyBrakingCount: statistics.heavyBrakingCount,
			  topSpeed: statistics.topSpeed,
			  topRPM: statistics.topRPM,
			  averageEngineLoad: statistics.averageEngineLoad,
			  averageThrottlePosition: statistics.averageThrottlePosition,
			  averagePercentageIdle: statistics.averagePercentageIdle,
			  averageGForce: statistics.averageGForce,
			  averagePercentageHighRPM: statistics.averagePercentageHighRPM,
			  topAccelerationGforce: statistics.topAccelerationGforce,
			  topDecelerationGforce: statistics.topDecelerationGforce,
			  averagePercentageCoasting: statistics.averagePercentageCoasting,
			  countries: statistics.countries,
			  genders: statistics.genders,
			  ages: statistics.ages]
	  }
	 
	 /**
	  * This method returns the list off all vehicle style types.
	  */
	  def fuelTypes() {
		  def criteria = Vehicle.createCriteria()
		  def vehicleInstanceList = criteria.list {
			  projections {
				  distinct('fuelType')
			  }
			  order('fuelType', 'desc')
		  }
				   
		  return [fuelTypes: vehicleInstanceList]
	  }
	  
	  /**
	   * This method returns the list off all vehicle style types.
	   * @param max - The max number of results return to the view.
	   * @param id - The make of car to fetch the data for.
	   */
	  def showFuelType(Integer max) {
		  params.max = Math.min(max ?: 10, 100)
		  def criteria = Vehicle.createCriteria()
		  def vehicleInstanceList = criteria.list(params) {
			  projections {
				  eq("fuelType", params.id)
			  }
			  order('fuelType', 'desc')
		  }
		  
		  // Statistics Data
		  def vehicles = criteria.list() {
			  projections {
				  eq("fuelType", params.id)
			  }
		  }
			  						
		  def statistics = vehicleService.getStatistics(vehicles)
		  
		  respond vehicleInstanceList, model:[vehicleInstanceCount: vehicles.size(),
			  fuelType: vehicleInstanceList[0].fuelType,
			  vehicleCount: statistics.vehicleCount,
			  modelCount: statistics.modelCount.size(),
			  journeyCount: statistics.journeyCount,
			  vehicleAgeAverage: statistics.vehicleAgeAverage,
			  totalHours: statistics.totalHours,
			  averageSpeed: statistics.averageSpeed,
			  averageRPM: statistics.averageRPM,
			  heavyAccelerationCount: statistics.heavyAccelerationCount,
			  heavyBrakingCount: statistics.heavyBrakingCount,
			  topSpeed: statistics.topSpeed,
			  topRPM: statistics.topRPM,
			  averageEngineLoad: statistics.averageEngineLoad,
			  averageThrottlePosition: statistics.averageThrottlePosition,
			  averagePercentageIdle: statistics.averagePercentageIdle,
			  averageGForce: statistics.averageGForce,
			  averagePercentageHighRPM: statistics.averagePercentageHighRPM,
			  topAccelerationGforce: statistics.topAccelerationGforce,
			  topDecelerationGforce: statistics.topDecelerationGforce,
			  averagePercentageCoasting: statistics.averagePercentageCoasting,
			  countries: statistics.countries,
			  genders: statistics.genders,
			  ages: statistics.ages]
	  }
	  
	  /**
	   * This method returns the list off all vehicle style types.
	   */
	   def countries() {
		   def criteria = Vehicle.createCriteria()
		   def vehicleInstanceList = criteria.list {
			   createAlias('driver','driver')
			   projections {
				   distinct('driver.country')
			   }
			   order('driver.country', 'desc')
		   }
					
		   return [countries: vehicleInstanceList]
	   }
	   
	   /**
		* This method returns the list off all vehicle style types.
		* @param max - The max number of results return to the view.
		* @param id - The make of car to fetch the data for.
		*/
	   def showCountry(Integer max) {
		   params.max = Math.min(max ?: 10, 100)
		   def criteria = Vehicle.createCriteria()
		   def vehicleInstanceList = criteria.list(params) {
			   projections {
				   eq("driver", params.id)
			   }
			   order('driver', 'desc')
		   }
		   
		   // Statistics Data
		   def vehicles = criteria.list() {
			   projections {
				   eq("driver", params.id)
			   }
		   }
									   
		   def statistics = vehicleService.getStatistics(vehicles)
		   
		   respond vehicleInstanceList, model:[vehicleInstanceCount: vehicles.size(),
			   country: vehicleInstanceList[0].driver.country,
			   vehicleCount: statistics.vehicleCount,
			   modelCount: statistics.modelCount.size(),
			   journeyCount: statistics.journeyCount,
			   vehicleAgeAverage: statistics.vehicleAgeAverage,
			   totalHours: statistics.totalHours,
			   averageSpeed: statistics.averageSpeed,
			   averageRPM: statistics.averageRPM,
			   heavyAccelerationCount: statistics.heavyAccelerationCount,
			   heavyBrakingCount: statistics.heavyBrakingCount,
			   topSpeed: statistics.topSpeed,
			   topRPM: statistics.topRPM,
			   averageEngineLoad: statistics.averageEngineLoad,
			   averageThrottlePosition: statistics.averageThrottlePosition,
			   averagePercentageIdle: statistics.averagePercentageIdle,
			   averageGForce: statistics.averageGForce,
			   averagePercentageHighRPM: statistics.averagePercentageHighRPM,
			   topAccelerationGforce: statistics.topAccelerationGforce,
			   topDecelerationGforce: statistics.topDecelerationGforce,
			   averagePercentageCoasting: statistics.averagePercentageCoasting,
			   countries: statistics.countries,
			   genders: statistics.genders,
			   ages: statistics.ages]
	   }
	
	/**
	 * This method returns the list off all vehicle style types.
	 */
	 def styles() {
		 def criteria = Vehicle.createCriteria()
		 def vehicleInstanceList = criteria.list {
			 projections {
				 distinct('vehicleStyle')
			 }
			 order('vehicleStyle', 'desc')
		 }
		 
		 return [styles: vehicleInstanceList]
	 }
	 
	 /**
	  * This method returns the list off all vehicle style types.
	  * @param max - The max number of results return to the view.
	  * @param id - The make of car to fetch the data for.
	  */
	 def showStyle(Integer max) {
		 params.max = Math.min(max ?: 10, 100)
		 def criteria = Vehicle.createCriteria()
		 def vehicleInstanceList = criteria.list(params) {
			 projections {
				 eq("vehicleStyle", params.id)
			 }
			 order('vehicleStyle', 'desc')
		 }
		 
		 // Statistics Data
		 def vehicles = criteria.list() {
			 projections {
				 eq("vehicleStyle", params.id)
			 }
		 }
		 		 
		 def statistics = vehicleService.getStatistics(vehicles)
		 
		 respond vehicleInstanceList, model:[vehicleInstanceCount: vehicles.size(),
			 style: vehicleInstanceList[0].vehicleStyle,
			 vehicleCount: statistics.vehicleCount,
			 modelCount: statistics.modelCount.size(),
			 journeyCount: statistics.journeyCount,
			 vehicleAgeAverage: statistics.vehicleAgeAverage,
			 totalHours: statistics.totalHours,
			 averageSpeed: statistics.averageSpeed,
			 averageRPM: statistics.averageRPM,
			 heavyAccelerationCount: statistics.heavyAccelerationCount,
			 heavyBrakingCount: statistics.heavyBrakingCount,
			 topSpeed: statistics.topSpeed,
			 topRPM: statistics.topRPM,
			 averageEngineLoad: statistics.averageEngineLoad,
			 averageThrottlePosition: statistics.averageThrottlePosition,
			 averagePercentageIdle: statistics.averagePercentageIdle,
			 averageGForce: statistics.averageGForce,
			 averagePercentageHighRPM: statistics.averagePercentageHighRPM,
			 topAccelerationGforce: statistics.topAccelerationGforce,
			 topDecelerationGforce: statistics.topDecelerationGforce,
			 averagePercentageCoasting: statistics.averagePercentageCoasting,
			 countries: statistics.countries,
			 genders: statistics.genders,
			 ages: statistics.ages]
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
		def vehicles = criteria.list() {
			projections {
				eq("make", params.id)
			}
		}
		
		def statistics = vehicleService.getStatistics(vehicles)
		
		respond vehicleInstanceList, model:[vehicleInstanceCount: vehicles.size(), 
			make: vehicleInstanceList[0].make,
			vehicleCount: statistics.vehicleCount,
			modelCount: statistics.modelCount.size(),
			journeyCount: statistics.journeyCount,
			vehicleAgeAverage: statistics.vehicleAgeAverage,
			totalHours: statistics.totalHours,
			averageSpeed: statistics.averageSpeed,
			averageRPM: statistics.averageRPM,
			heavyAccelerationCount: statistics.heavyAccelerationCount,
			heavyBrakingCount: statistics.heavyBrakingCount,
			topSpeed: statistics.topSpeed,
			topRPM: statistics.topRPM,
			averageEngineLoad: statistics.averageEngineLoad,
			averageThrottlePosition: statistics.averageThrottlePosition,
			averagePercentageIdle: statistics.averagePercentageIdle,
			averageGForce: statistics.averageGForce,
			averagePercentageHighRPM: statistics.averagePercentageHighRPM,
			topAccelerationGforce: statistics.topAccelerationGforce,
			topDecelerationGforce: statistics.topDecelerationGforce,
			averagePercentageCoasting: statistics.averagePercentageCoasting,
			countries: statistics.countries,
			genders: statistics.genders,
			ages: statistics.ages]
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


	/**
	 * This method deletes a specific car based on Identifier.
	 * @param vehicleInstance - The vehicle to delete.
	 */
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
}
