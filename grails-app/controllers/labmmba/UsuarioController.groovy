package labmmba



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
//le da acceso a los usuarios, admin y director a este controlador
@Secured(["ROLE_USUARIO","ROLE_ADMIN", "ROLE_DIRECTOR"])
class UsuarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    //controlador del a vista usuario retorna el usuario logeaado y una lista con sus estudios ademas lo envia
    //la vista edit para rellene los datos obligatorios si no lo ha hecho.
    def userView(Usuario usuarioInstance){
        if(usuarioInstance.area.name=="Empity" || usuarioInstance.charge.name=="Empity" || Study.countByUserAndGrade(usuarioInstance,"pregrade")==0){
            return  redirect(controller: 'usuario', action:"edit", params:[id:usuarioInstance.id])
        }
        [usuarioInstance: usuarioInstance, studies:Study.findAllByUser(usuarioInstance)]
    }
     //controlador creado por scaffold
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Usuario.list(params), model:[usuarioInstanceCount: Usuario.count()]
    }
    //controlador creado por scaffold
    @Transactional
    def save(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }

        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'create'
            return
        }

        usuarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect usuarioInstance
            }
            '*' { respond usuarioInstance, [status: CREATED] }
        }
    }
    //controlador creado por scaffold
    def edit(Usuario usuarioInstance) {
        respond usuarioInstance
    }

    @Transactional
    //controlador creado por scaffold
    def update(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }

        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'edit'
            return
        }

        usuarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect(controller: 'usuario', action:"userView", params:[id:usuarioInstance.id])
            }
            '*'{ respond usuarioInstance, [status: OK] }
        }
    }

    @Transactional
    //controlador creado por scaffold
    def delete(Usuario usuarioInstance) {

        if (usuarioInstance == null) {
            notFound()
            return
        }

        usuarioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Transactional
    //controlador usado para cambiar el el habilitar/deshabilitar un usuario
    def modificarEstado(long usuarioId){
        def usuario = Usuario.findById(usuarioId)
        if (usuario){
            usuario.enabled = !usuario.enabled
            usuario.save(flush: true)
            redirect(controller: "usuario", action: "admin", params: [max: 0] )
        }

    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    //controlador solo accesible por el usuario retorna una lista con todos los usuarios
    @Secured(["ROLE_ADMIN"])
    def admin() {
        respond Usuario.list(params)
    }
}
