package labmmba

class Comentario {
     static belongsTo = [
             tesis: Tesis
     ]

    String comentario
    Long id_comentador
    String url_archivo
    static constraints = {
    }
}
