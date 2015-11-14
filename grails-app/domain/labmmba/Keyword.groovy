package labmmba

class Keyword {
    static belongsTo = [
            keywordPublicacionRevista: Keyword_publicacion_revista
    ]

    String keyword
    static constraints = {
    }
}
