package labmmba

class University {
    static hasMany = [
            study: Study,
            tesis: Tesis
    ]
    String name
    static constraints = {
    }
}
