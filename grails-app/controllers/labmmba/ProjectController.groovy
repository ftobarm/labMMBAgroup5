package labmmba

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
//la clase solo es accible por usuarios logeados
class ProjectController {
    //controlador de la pag principal
    def index(Usuario usuarioInstance) {
        [usuarioInstance: usuarioInstance, projects:UserProject.findAllByUser(usuarioInstance)]
    }
    def register(Usuario usuarioInstance){
        respond usuarioInstance

    }
    //cotrolador que guarda el estudio de un usuario.
    def save() {
        def project=new Project()
        project.age=params.age
        project.name=params.name
        project.other=params.other
        project.save()
        def userProject=new UserProject()
        userProject.project=project
        userProject.charge=params.charge
        userProject.user=Usuario.findById(params.id)
        userProject.save()
        redirect(controller: 'project', action: 'index', params:[id: params.id])
    }
}
