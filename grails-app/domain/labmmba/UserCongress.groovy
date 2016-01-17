package labmmba

class UserCongress {
    static belongsTo = [
            congress: Congress,
            user: Usuario
    ]
    String paper
    String url

    static constraints = {
    }
}
