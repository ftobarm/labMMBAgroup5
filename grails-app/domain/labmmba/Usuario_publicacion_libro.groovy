package labmmba

class  Usuario_publicacion_libro {
    static belongsTo = [
            publicacion: Publicacion_libro,
            usuario: Usuario
    ]
    Boolean autor
    String url_libro
    static constraints = {
    }
}
