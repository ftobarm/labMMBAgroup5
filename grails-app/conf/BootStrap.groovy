import labmmba.Charge
import labmmba.UsuarioRol
import labmmba.Rol
import labmmba.Usuario
import labmmba.InvestigationArea

class BootStrap {

    def init = { servletContext ->
        def area=InvestigationArea.findOrSaveByName("Empity")
        InvestigationArea.findOrSaveByName("Biotecnología vegetal")
        InvestigationArea.findOrSaveByName("Compuestos bioactivo")
        InvestigationArea.findOrSaveByName("Microbiología")
        InvestigationArea.findOrSaveByName("Biotecnología Ambiental")
        def adminCharge=Charge.findOrSaveByName("Admin")
        def directorCharge=Charge.findOrSaveByName("Jefe de Laboratorio")
        Charge.findOrSaveByName("Empity")
        Charge.findOrSaveByName("Estudiante de pregrado")
        Charge.findOrSaveByName("Estudiante de Postgrado")
        Charge.findOrSaveByName("Trabajador")
        Charge.findOrSaveByName("Colaborador")
        if (!Usuario.findByEmail("admin")) {
            def rolAdmin = new Rol("ROLE_ADMIN").save()
            def admin = new Usuario("admin", "admin", "pepe", "ardiila", true, area, adminCharge).save()
            UsuarioRol.create admin, rolAdmin, true
        }

        if (!Usuario.findByEmail("director@todopoderoso.com")) {
            def rolDirector = new Rol("ROLE_DIRECTOR").save()
            def director = new Usuario("director@todopoderoso.com", "muysegura", "juan", "perez", true, area, directorCharge).save()
            UsuarioRol.create director, rolDirector,true

        }
        if(!Rol.findByAuthority("ROLE_USUARIO")){
            new Rol("ROLE_USUARIO").save(flush: true)
        }


    }

    def destroy = {
    }
}
