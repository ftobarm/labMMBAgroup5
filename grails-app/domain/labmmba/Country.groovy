package labmmba

class Country {
    static hasMany = [
            tesis: Tesis,
            study: Study
    ]
    String name
    static constraints = {
    }
}
