package labmmba

class Usuario_tesis {
    static belongsTo = [
            tesis: Tesis,
            usuario: Usuario
    ]
    Long id_tutor
    Long id_cotutor
    Long id_director


    static constraints = {
    }
}
