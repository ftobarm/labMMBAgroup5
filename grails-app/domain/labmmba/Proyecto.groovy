package labmmba

class Proyecto {
    static hasMany = [
            proyecto: Usuario_proyecto,
    ]
    String nombre
    Integer año
    String otros
    static constraints = {
    }
}
