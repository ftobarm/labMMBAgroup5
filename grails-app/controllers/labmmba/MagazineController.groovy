package labmmba

import grails.plugin.springsecurity.annotation.Secured
import labmmba.Usuario

@Secured(['IS_AUTHENTICATED_FULLY'])
//la clase solo es accible por usuarios logeados
class MagazineController {
    //controlador de la pag principal
    def index(Usuario usuarioInstance) {
        [usuarioInstance: usuarioInstance, magazines:UserMagazine.findAllByUser(usuarioInstance)]
    }
    def register(Usuario usuarioInstance) {
        respond usuarioInstance
    }
    //cotrolador que guarda el estudio de un usuario.
    def upload(Usuario usuarioInstance ) {
        def magazine=new Magazine()
        magazine.area=InvestigationArea.findOrSaveByName(params.area)
        magazine.year=params.int("year")
        magazine.magazineName=params.magazine
        magazine.paper=params.paper
        def f = request.getFile("filecsv")
        def webrootDir = servletContext.getRealPath("/") //app directory
        File fileDest = new File(webrootDir,"/magazine/${f.originalFilename}")
        magazine.url=fileDest.getAbsolutePath()
        magazine.save()
        def int i
        def Keyword keyword
        for (i =1; i <=params.int("keywords"); i++) {
            keyword= Keyword.findOrSaveByName(params.get("keyword"+i))
            KeywordMagazine.findOrSaveByMagazineAndKeyword(magazine, keyword)
        }
        UserMagazine.findOrSaveByMagazineAndUser(magazine,usuarioInstance)
        for (i =1; i <=params.int("autors"); i++) {
            UserMagazine.findOrSaveByMagazineAndUser(magazine,Usuario.findById(params.int("autor"+i)))
        }
        f.transferTo(fileDest)
        redirect(controller: 'magazine', action:"index", params:[id:usuarioInstance.id])
    }
}
