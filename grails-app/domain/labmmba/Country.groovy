package labmmba

class Country {
    static hasMany = [
            tesis: Tesis,
            study: Study,
            congress:Congress
    ]
    String name
    static constraints = {
    }
}
