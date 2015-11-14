package labmmba

class Congreso {
    static hasMany = [
            congreso: Usuario_congreso
    ]
    String nombre
    Date fecha_inicio
    Date fecha_termino
    String ciudad
    String pais
    static constraints = {
    }
}
