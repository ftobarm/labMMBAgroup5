package labmmba

class Multimedia {
    static belongsTo = [
            usuario: Usuario
    ]
    Integer tipo
    String  url_multi
    static constraints = {
    }
}
