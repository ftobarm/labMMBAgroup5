package labmmba

class Publicacion_revista {
    static belongsTo = [
            usuarioPublicacion: Usuario_publicacion_revista
    ]
    String revista
    Integer año
    static constraints = {
    }
}
