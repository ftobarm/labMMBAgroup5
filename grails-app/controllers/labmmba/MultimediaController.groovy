package labmmba

import grails.plugin.springsecurity.annotation.Secured
import labmmba.Usuario

@Secured(['IS_AUTHENTICATED_FULLY'])
//la clase solo es accible por usuarios logeados
class MultimediaController {
    //controlador de la pag principal
    def index(Usuario usuarioInstance) {
        [usuarioInstance: usuarioInstance, multis: Multimedia.findAllByUser(usuarioInstance)]
    }
    def upload(Usuario usuarioInstance ) {
        def multi= new Multimedia()
        multi.type=params.type
        multi.user=usuarioInstance
        def f = request.getFile("filecsv")
        def webrootDir = servletContext.getRealPath("/") //app directory
        File fileDest = new File(webrootDir,"/multimedia/${f.originalFilename}")
        multi.url=fileDest.getAbsolutePath()
        multi.save()
        f.transferTo(fileDest)
        redirect(controller: 'multimedia', action:"index", params:[id:usuarioInstance.id,multis: Multimedia.findAllByUser(usuarioInstance)])
    }
}
