package labmmba

class Area_investigacion {
    static belongsTo = [
                publicacion: Usuario_publicacion_revista
    ]

    String nombre
    static constraints = {
    }
}
