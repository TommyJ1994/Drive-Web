package drive



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SensorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Sensor.list(params), model:[sensorInstanceCount: Sensor.count()]
    }

    def show(Sensor sensorInstance) {
        respond sensorInstance
    }

    def create() {
        respond new Sensor(params)
    }

    @Transactional
    def save(Sensor sensorInstance) {
        if (sensorInstance == null) {
            notFound()
            return
        }

        if (sensorInstance.hasErrors()) {
            respond sensorInstance.errors, view:'create'
            return
        }

        sensorInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sensor.label', default: 'Sensor'), sensorInstance.id])
                redirect sensorInstance
            }
            '*' { respond sensorInstance, [status: CREATED] }
        }
    }

    def edit(Sensor sensorInstance) {
        respond sensorInstance
    }

    @Transactional
    def update(Sensor sensorInstance) {
        if (sensorInstance == null) {
            notFound()
            return
        }

        if (sensorInstance.hasErrors()) {
            respond sensorInstance.errors, view:'edit'
            return
        }

        sensorInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Sensor.label', default: 'Sensor'), sensorInstance.id])
                redirect sensorInstance
            }
            '*'{ respond sensorInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Sensor sensorInstance) {

        if (sensorInstance == null) {
            notFound()
            return
        }

        sensorInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Sensor.label', default: 'Sensor'), sensorInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sensor.label', default: 'Sensor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
