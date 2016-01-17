package labmmba

class UserProject {
    static belongsTo = [
            user : Usuario,
            project: Project
    ]
    String charge
    static constraints = {
    }
}
