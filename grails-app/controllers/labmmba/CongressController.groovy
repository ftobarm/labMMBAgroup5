package labmmba



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CongressController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Congress.list(params), model:[congressInstanceCount: Congress.count()]
    }

    def show(Congress congressInstance) {
        respond congressInstance
    }

    def create() {
        respond new Congress(params)
    }

    @Transactional
    def save(Congress congressInstance) {
        if (congressInstance == null) {
            notFound()
            return
        }

        if (congressInstance.hasErrors()) {
            respond congressInstance.errors, view:'create'
            return
        }

        congressInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'congress.label', default: 'Congress'), congressInstance.id])
                redirect congressInstance
            }
            '*' { respond congressInstance, [status: CREATED] }
        }
    }

    def edit(Congress congressInstance) {
        respond congressInstance
    }

    @Transactional
    def update(Congress congressInstance) {
        if (congressInstance == null) {
            notFound()
            return
        }

        if (congressInstance.hasErrors()) {
            respond congressInstance.errors, view:'edit'
            return
        }

        congressInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Congress.label', default: 'Congress'), congressInstance.id])
                redirect congressInstance
            }
            '*'{ respond congressInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Congress congressInstance) {

        if (congressInstance == null) {
            notFound()
            return
        }

        congressInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Congress.label', default: 'Congress'), congressInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'congress.label', default: 'Congress'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
