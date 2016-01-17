package labmmba

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
//la clase solo es accible por usuarios logeados
class ProyectController {
    //controlador de la pag principal
    def index(Usuario usuarioInstance) {
        [usuarioInstance: usuarioInstance, proyects:UserProyect.findAllByUser(usuarioInstance)]
    }
    def register(Usuario usuarioInstance){
        respond usuarioInstance

    }
    //cotrolador que guarda el estudio de un usuario.
    def save() {
        def proyect=new Proyect()
        proyect.age=params.age
        proyect.name=params.name
        proyect.other=params.other
        proyect.save()
        def userProyect=new UserProyect()
        userProyect.proyect=proyect
        userProyect.charge=params.charge
        userProyect.user=Usuario.findById(params.id)
        userProyect.save()
        redirect(controller: 'proyect', action: 'index', params:[id: params.id])
    }
}
