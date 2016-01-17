package labmmba.registro

import grails.plugin.springsecurity.annotation.Secured
import labmmba.Rol
import labmmba.Usuario
import labmmba.UsuarioRol
import labmmba.Charge
import labmmba.InvestigationArea

@Secured(["IS_AUTHENTICATED_ANONYMOUSLY"])

class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {
    @Override
    //contralador generado por plugin
    def index() {
        def copy = [:] + (flash.chainedParams ?: [:])
        copy.remove 'controller'
        copy.remove 'action'
        [command: new Command(copy)]
    }
    //controlador para registar un nuevo usuario, aqui se hacen algunas verificaciones
    //de los datos de entrada
    def register(Command command) {
        if (!checkPasswordsEqual(command.password, command.password2)) {
            flash.message = "Las contraseñas no coinciden"
            return redirect(controller: 'register', action: 'index')
        }

        if (Usuario.findByEmail(command.email)){
            flash.message = "Ya existe un usuario con este email"
            return redirect(controller: 'register', action: 'index')
        }
        if( command.email==null || command.nombre==null || command.apellido==null || command.password==null  ){
            flash.message = "Se deben llenar todos los campos"
            return redirect(controller: 'register', action: 'index')
        }
        def usuario = new Usuario(
                command.email,
                command.password,
                command.nombre,
                command.apellido,
                false,
                null
        ).save()

        def rol = Rol.findByAuthority("ROLE_USUARIO")


        UsuarioRol.create usuario, rol, true

        redirect(controller: 'inicio', action: 'index')


    }

    boolean checkPasswordsEqual(String p1, String p2) {
        return p1 == p2
    }
}
//clase auxiliar para recibir datos de la vista
class Command {

    String email
    String password
    String password2
    String nombre
    String apellido

    def grailsApplication

    static constraints = {
        email blank: false, email: true
        password2 blank: false
        nombre blank: false
        apellido blank: false
    }

}