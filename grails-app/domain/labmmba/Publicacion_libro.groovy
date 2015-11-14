package labmmba

class Publicacion_libro {
    static hasMany = [
            publicacion: Usuario_publicacion_libro,
    ]
    String Titulo
    Integer año
    String ISBN
    String editorial
    static constraints = {
    }
}
