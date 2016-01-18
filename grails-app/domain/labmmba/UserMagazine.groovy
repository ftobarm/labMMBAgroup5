package labmmba

class UserMagazine {
    static belongsTo = [
            user: Usuario,
            magazine: Magazine
    ]

    static constraints = {
    }
}
