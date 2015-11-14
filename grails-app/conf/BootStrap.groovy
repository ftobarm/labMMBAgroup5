import labmmba.UsuarioRol
import labmmba.Rol
import labmmba.Usuario

class BootStrap {

    def init = { servletContext ->
        if (!Usuario.findByEmail("admin")) {
            def rolAdmin = new Rol("ROLE_ADMIN").save()
            def admin = new Usuario("admin", "admin","pepe","ardiila",true).save()
            UsuarioRol.create admin, rolAdmin, true
        }

        if (!Usuario.findByEmail("director@todopoderoso.com")) {
            def rolDirector = new Rol("ROLE_DIRECTOR").save()
            def director = new Usuario("director@todopoderoso.com", "muysegura","juan","perez",true).save()
            UsuarioRol.create director, rolDirector,true

        }
        if(!Rol.findByAuthority("ROLE_USUARIO")){
            new Rol("ROLE_USUARIO").save(flush: true)
        }


    }

    def destroy = {
    }
}
