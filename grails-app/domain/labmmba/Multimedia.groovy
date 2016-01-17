package labmmba

class Multimedia {
    static belongsTo = [
            user: Usuario
    ]
    String type
    String url

    static constraints = {
    }
}
