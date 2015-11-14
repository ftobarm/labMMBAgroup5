package labmmba

class Usuario_proyecto {
    static belongsTo = [
            proyecto: Proyecto,
            usuario: Usuario
    ]
    String Cargo
    static constraints = {
    }
}
