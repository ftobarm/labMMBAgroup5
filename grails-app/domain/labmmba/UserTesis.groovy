package labmmba

class UserTesis {
    static belongsTo = [
            tesis: Tesis,
            user: Usuario
    ]
    String charge

    static constraints = {
    }
}
