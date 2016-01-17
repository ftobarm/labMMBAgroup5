package labmmba

import grails.plugin.springsecurity.annotation.Secured
import labmmba.Usuario

@Secured(['IS_AUTHENTICATED_FULLY'])
//la clase solo es accible por usuarios logeados
class CongressController {
    //controlador de la pag principal
    def index(Usuario usuarioInstance) {
        [usuarioInstance: usuarioInstance, congress:UserCongress.findAllByUser(usuarioInstance)]
    }
    def register(Usuario usuarioInstance) {
        respond usuarioInstance
    }
    //cotrolador que guarda el estudio de un usuario.
    def upload(Usuario usuarioInstance ) {
        def congress= new Congress()
        def userCongress= new UserCongress()
        congress.name=params.name
        congress.country=Country.findOrSaveByName(params.country)
        congress.city=params.city
        congress.startDate=params.startDate
        congress.endDate=params.endDate
        congress.save()
        def f = request.getFile("filecsv")
        def webrootDir = servletContext.getRealPath("/") //app directory
        File fileDest = new File(webrootDir,"/congressFiles/${f.originalFilename}")
        userCongress.url=fileDest.getAbsolutePath()
        userCongress.paper=params.paper
        userCongress.congress=congress
        userCongress.user= usuarioInstance
        userCongress.save()
        f.transferTo(fileDest)
        redirect(controller: 'congress', action:"index", params:[id:usuarioInstance.id])
    }
}
