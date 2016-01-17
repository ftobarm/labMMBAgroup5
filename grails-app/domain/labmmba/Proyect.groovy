package labmmba

class Proyect {
    static hasMany = [
            user : UserProyect
    ]
    String name
    String age
    String other
    static constraints = {
    }
}
