package drive



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PointController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Point.list(params), model:[pointInstanceCount: Point.count()]
    }

    def show(Point pointInstance) {
        respond pointInstance
    }

    def create() {
        respond new Point(params)
    }

    @Transactional
    def save(Point pointInstance) {
        if (pointInstance == null) {
            notFound()
            return
        }

        if (pointInstance.hasErrors()) {
            respond pointInstance.errors, view:'create'
            return
        }

        pointInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'point.label', default: 'Point'), pointInstance.id])
                redirect pointInstance
            }
            '*' { respond pointInstance, [status: CREATED] }
        }
    }

    def edit(Point pointInstance) {
        respond pointInstance
    }

    @Transactional
    def update(Point pointInstance) {
        if (pointInstance == null) {
            notFound()
            return
        }

        if (pointInstance.hasErrors()) {
            respond pointInstance.errors, view:'edit'
            return
        }

        pointInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Point.label', default: 'Point'), pointInstance.id])
                redirect pointInstance
            }
            '*'{ respond pointInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Point pointInstance) {

        if (pointInstance == null) {
            notFound()
            return
        }

        pointInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Point.label', default: 'Point'), pointInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'point.label', default: 'Point'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
