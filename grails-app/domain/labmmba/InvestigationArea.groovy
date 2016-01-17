package labmmba

class InvestigationArea {
    static hasMany = [
            user: Usuario
    ]
    String name
    InvestigationArea(String name) {
        this()
        this.name = name
    }
    static constraints = {
    }
}
