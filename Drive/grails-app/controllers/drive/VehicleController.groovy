package drive

import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController
import grails.transaction.Transactional

@Transactional(readOnly = true)

class VehicleController {

	static allowedMethods = [create: "POST", save: "POST", update: "PUT", delete: "DELETE"]


	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Vehicle.list(params), model:[vehicleInstanceCount: Vehicle.count()]
	}

	
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
		
		def vehicleInstanceCount = criteria.list() {
			projections {
				eq("make", params.id)
			}
		}
		
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
		def journeyCount = manufacturerStats.journeys as Set
		
		// Get the average vehicle age
		def vehicleAgeAverage = manufacturerStats.year.sum() / manufacturerStats.year.size()
		
		respond vehicleInstanceList, model:[vehicleInstanceCount: vehicleInstanceCount.size(), 
			make: vehicleInstanceList[0].make,
			vehicleCount: vehicleCount,
			modelCount: modelCount.size(),
			journeyCount: journeyCount.size() - 1,
			vehicleAgeAverage: vehicleAgeAverage]
	}

	def show(Vehicle vehicleInstance) {
		respond vehicleInstance
	}

	def create() {
		respond new Vehicle(params)
	}

	@Transactional
	def save(Vehicle vehicleInstance) {
		if (vehicleInstance == null) {
			notFound()
			return
		}

		if (vehicleInstance.hasErrors()) {
			respond vehicleInstance.errors, view:'create'
			return
		}

		vehicleInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [
					message(code: 'vehicle.label', default: 'Vehicle'),
					vehicleInstance.id
				])
				redirect vehicleInstance
			}
			'*' { respond vehicleInstance, [status: CREATED] }
		}
	}

	def edit(Vehicle vehicleInstance) {
		respond vehicleInstance
	}

	@Transactional
	def update(Vehicle vehicleInstance) {
		if (vehicleInstance == null) {
			notFound()
			return
		}

		if (vehicleInstance.hasErrors()) {
			respond vehicleInstance.errors, view:'edit'
			return
		}

		vehicleInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'Vehicle.label', default: 'Vehicle'),
					vehicleInstance.id
				])
				redirect vehicleInstance
			}
			'*'{ respond vehicleInstance, [status: OK] }
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
