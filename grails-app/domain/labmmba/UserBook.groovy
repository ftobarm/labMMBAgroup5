package labmmba

class UserBook {
    static belongsTo = [
            user : Usuario,
            book : Book
    ]
    static constraints = {
    }
}
