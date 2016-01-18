import labmmba.Charge
import labmmba.Keyword
import labmmba.Study
import labmmba.UsuarioRol
import labmmba.Rol
import labmmba.Usuario
import labmmba.InvestigationArea
import labmmba.University
import labmmba.Country
class BootStrap {

    def init = { servletContext ->
        University.findOrSaveByName("UTFSM")
        Keyword.findOrSaveByName("holi")
        def university=University.findOrSaveByName("UFRO")
        def country=Country.findOrSaveByName("Chile")
        Country.findOrSaveByName("EEUU")
        InvestigationArea.findOrSaveByName("Biotecnología vegetal")
        def area=InvestigationArea.findOrSaveByName("Compuestos bioactivo")
        InvestigationArea.findOrSaveByName("Microbiología")
        InvestigationArea.findOrSaveByName("Biotecnología Ambiental")
        def adminCharge=Charge.findOrSaveByName("Admin")
        def directorCharge=Charge.findOrSaveByName("Jefe de Laboratorio")
        def pregrade=Charge.findOrSaveByName("Estudiante de pregrado")
        Charge.findOrSaveByName("Estudiante de Postgrado")
        Charge.findOrSaveByName("Trabajador")
        Charge.findOrSaveByName("Colaborador")
        if (!Usuario.findByEmail("admin")) {
            def rolAdmin = new Rol("ROLE_ADMIN").save()
            def admin = new Usuario("admin", "admin", "pepe", "ardiila", true, adminCharge).save()
            UsuarioRol.create admin, rolAdmin, true
        }

        if (!Usuario.findByEmail("director@todopoderoso.com")) {
            def rolDirector = new Rol("ROLE_DIRECTOR").save()
            def director = new Usuario("director@todopoderoso.com", "muysegura", "juan", "perez", true, directorCharge).save()
            UsuarioRol.create director, rolDirector,true

        }
        if (!Usuario.findByEmail("a@a")) {
            def rolUser=new Rol("ROLE_USUARIO").save(flush: true)
            def user1 = new Usuario("a@a", "aaa", "test", "user1", true, pregrade)
            user1.area=area
            user1.save()
            def study = new Study()
            study.country=country
            study.grade="pregrado"
            study.name="ing en algo"
            study.university=university
            study.user=user1
            study.save()
            UsuarioRol.create user1, rolUser,true

        }

    }

    def destroy = {
    }
}
