import labmmba.UsuarioRol
import labmmba.Rol
import labmmba.Usuario

class BootStrap {

    def init = { servletContext ->
        if (!Usuario.findByEmail("admin@todopoderoso.com")) {
            def rolAdmin = new Rol("ROLE_ADMIN").save()
            def admin = new Usuario("admin@todopoderoso.com", "admin","pepe","ardiila").save()
            UsuarioRol.create admin, rolAdmin, true
        }

        if (!Usuario.findByEmail("director@todopoderoso.com")) {
            def rolDirector = new Rol("ROLE_DIRECTOR").save()
            def director = new Usuario("director@todopoderoso.com", "muysegura","juan","perez").save()
            UsuarioRol.create director, rolDirector,true
        }

    }

    def destroy = {
    }
}
