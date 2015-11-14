package labmmba

class Tesis {
    static hasMany = [
            usuario: Usuario_tesis,
            comentario: Comentario
    ]
    String nombre
    String Universidad
    String pais
    String url_pdf

    static constraints = {
    }
}
