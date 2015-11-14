package labmmba

class Usuario_publicacion_revista {
    static belongsTo = [
            keywordPublicacion: Keyword_publicacion_revista
    ]
    static hasMany = [
            area: Area_investigacion,
            publicacion: Publicacion_revista
    ]
    String titulo
    Boolean autor
    static constraints = {
    }
}
