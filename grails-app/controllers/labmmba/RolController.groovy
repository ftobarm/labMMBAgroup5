package labmmba



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured


@Transactional(readOnly = true)
@Secured(["ROLE_ADMIN","ROLE_DIRECTOR"])
class RolController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Transactional
    def save(Rol rolInstance) {
        if (rolInstance == null) {
            notFound()
            return
        }

        if (rolInstance.hasErrors()) {
            respond rolInstance.errors, view:'create'
            return
        }

        rolInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rol.label', default: 'Rol'), rolInstance.id])
                redirect rolInstance
            }
            '*' { respond rolInstance, [status: CREATED] }
        }
    }

    @Transactional
    def update(Rol rolInstance) {
        if (rolInstance == null) {
            notFound()
            return
        }

        if (rolInstance.hasErrors()) {
            respond rolInstance.errors, view:'edit'
            return
        }

        rolInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Rol.label', default: 'Rol'), rolInstance.id])
                redirect rolInstance
            }
            '*'{ respond rolInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Rol rolInstance) {

        if (rolInstance == null) {
            notFound()
            return
        }

        rolInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Rol.label', default: 'Rol'), rolInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rol.label', default: 'Rol'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
