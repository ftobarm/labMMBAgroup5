package labmmba

import grails.plugin.springsecurity.annotation.Secured
import labmmba.Usuario
@Secured(['IS_AUTHENTICATED_FULLY'])
//la clase solo es accible por usuarios logeados
class TesisController {
    //controlador de la pag principal
    def index(Usuario usuarioInstance) {
        respond usuarioInstance
    }
    //cotrolador que guarda el estudio de un usuario.
    def upload(Usuario usuarioInstance ) {
        def tesis=new Tesis()
        def tesisTutor=new UserTesis()
        def tesisAutor=new UserTesis()
        tesis.name=params.tesis
        tesis.country=Country.findOrSaveByName(params.country)
        tesis.university=University.findOrSaveByName(params.university)
        def f = request.getFile("filecsv")
        def webrootDir = servletContext.getRealPath("/") //app directory
        File fileDest = new File(webrootDir,"/tesis/${f.originalFilename}")
        tesis.url=fileDest.getAbsolutePath()
        tesis.save()
        tesisTutor.tesis=Tesis.findByName(params.tesis)
        tesisTutor.charge="Tutor"
        tesisTutor.user=Usuario.findById(params.tutor)
        tesisTutor.save()
        tesisAutor.tesis=Tesis.findByName(params.tesis)
        tesisAutor.charge="Autor"
        tesisAutor.user=Usuario.findById(params.id)
        tesisAutor.save()
        if(params.cotutor!="Sin Cotutor"){
            def tesisCotutor= new UserTesis()
            tesisCotutor.tesis=tesis
            tesisCotutor.charge="Cotutor"
            tesisCotutor.user=Usuario.findById(params.cotutor)
            tesisCotutor.save()
        }

        f.transferTo(fileDest)
        redirect(controller: 'tesis', action:"index", params:[id:usuarioInstance.id])
    }
}
