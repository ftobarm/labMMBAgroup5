package labmmba

class UserProyect {
    static belongsTo = [
            user : Usuario,
            proyect: Proyect
    ]
    String charge
    static constraints = {
    }
}
