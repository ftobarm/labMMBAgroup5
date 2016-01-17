package labmmba

import grails.plugin.springsecurity.annotation.Secured
import labmmba.Usuario
@Secured(['IS_AUTHENTICATED_FULLY'])
//la clase solo es accible por usuarios logeados
class StudyController {
    //controlador de la pag principal
    def index(Usuario usuarioInstance) {
        respond usuarioInstance
    }
    //cotrolador que guarda el estudio de un usuario.
    def register() {
        def country=Country.findOrSaveByName(params.country)
        def university=University.findOrSaveByName(params.university)
        def study= new Study()
        study.country=Country.findOrSaveByName(params.country)
        study.university=University.findOrSaveByName(params.university)
        study.user=Usuario.findById(params.id)
        study.name=params.carrera
        study.grade=params.grade
        study.save()
        redirect(controller: 'usuario', action: 'userView', params:[id: params.id])
    }
}
