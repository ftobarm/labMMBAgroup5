package labmmba

class Tesis {
    static belongsTo = [
            university : University,
            country : Country
    ]
    static hasMany=[
            user : UserTesis
    ]
    String name
    String url

    static constraints = {
        user nullable: true
    }
}
