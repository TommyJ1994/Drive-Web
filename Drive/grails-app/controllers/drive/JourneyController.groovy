package drive



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class JourneyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Journey.list(params), model:[journeyInstanceCount: Journey.count()]
    }

    def show(Journey journeyInstance) {
        respond journeyInstance
    }

    def create() {
        respond new Journey(params)
    }

    @Transactional
    def save(Journey journeyInstance) {
        if (journeyInstance == null) {
            notFound()
            return
        }

        if (journeyInstance.hasErrors()) {
            respond journeyInstance.errors, view:'create'
            return
        }

        journeyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'journey.label', default: 'Journey'), journeyInstance.id])
                redirect journeyInstance
            }
            '*' { respond journeyInstance, [status: CREATED] }
        }
    }

    def edit(Journey journeyInstance) {
        respond journeyInstance
    }

    @Transactional
    def update(Journey journeyInstance) {
        if (journeyInstance == null) {
            notFound()
            return
        }

        if (journeyInstance.hasErrors()) {
            respond journeyInstance.errors, view:'edit'
            return
        }

        journeyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Journey.label', default: 'Journey'), journeyInstance.id])
                redirect journeyInstance
            }
            '*'{ respond journeyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Journey journeyInstance) {

        if (journeyInstance == null) {
            notFound()
            return
        }

        journeyInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Journey.label', default: 'Journey'), journeyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'journey.label', default: 'Journey'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
