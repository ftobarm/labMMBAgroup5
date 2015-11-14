package labmmba

class Keyword_publicacion_revista {
    static hasMany = [
            keyword: Keyword,
            publicacionRevista: Usuario_publicacion_revista
    ]
     static constraints = {
    }
}
