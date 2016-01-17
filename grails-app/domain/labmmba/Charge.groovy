package labmmba

class Charge {
    static hasMany = [
            user: Usuario
    ]
    String name

    Charge(String name) {
        this()
        this.name = name
    }
    static constraints = {
    }
}
