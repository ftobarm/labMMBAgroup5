import labmmba.UsuarioRol
import labmmba.Rol
import labmmba.Usuario

class BootStrap {

    def init = { servletContext ->
        if (Usuario.count() < 1) {
            def rolAdmin = new Rol("ROLE_ADMIN").save()
            def admin = new Usuario("admin", "admin").save()

            UsuarioRol.create admin, rolAdmin, true
        }

    }

    def destroy = {
    }
}
