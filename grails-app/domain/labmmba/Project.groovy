package labmmba

class Project {
    static hasMany = [
            user : UserProject
    ]
    String name
    String age
    String other
    static constraints = {
    }
}
