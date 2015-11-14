package labmmba

class Estudio {
    static belongsTo = [
            usuario: Usuario
    ]
    String carerra
    String Universidad
    String pais
    Boolean tipo

    static constraints = {
    }
}
