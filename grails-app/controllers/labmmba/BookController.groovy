package labmmba

import grails.plugin.springsecurity.annotation.Secured
import labmmba.Usuario

@Secured(['IS_AUTHENTICATED_FULLY'])
//la clase solo es accible por usuarios logeados
class BookController {
    //controlador de la pag principal
    def index(Usuario usuarioInstance) {
        [usuarioInstance: usuarioInstance, books:UserBook.findAllByUser(usuarioInstance)]
    }
    def register(Usuario usuarioInstance) {
        respond usuarioInstance
    }
    //cotrolador que guarda el estudio de un usuario.
    def upload(Usuario usuarioInstance ) {
        def book=new Book()
        book.editorial=params.editorial
        book.title=params.title
        book.isbn=params.isbn
        book.year=params.int("year")
        def f = request.getFile("filecsv")
        def webrootDir = servletContext.getRealPath("/") //app directory
        File fileDest = new File(webrootDir,"/publication/${f.originalFilename}")
        book.url=fileDest.getAbsolutePath()
        book.save()
        UserBook.findOrSaveByBookAndUser(book,usuarioInstance)
        def int i
        for (i =1; i <=params.int("autors"); i++) {
            UserBook.findOrSaveByBookAndUser(book,Usuario.findById(params.int("autor"+i)))
        }
        f.transferTo(fileDest)
        redirect(controller: 'book', action:"index", params:[id:usuarioInstance.id])
    }
}
