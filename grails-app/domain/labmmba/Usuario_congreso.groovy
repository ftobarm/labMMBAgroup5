package labmmba

class Usuario_congreso {
    static belongsTo = [
            congreso: Congreso,
            usuario: Usuario
    ]
    String nombre_paper
    String url_pdf
    static constraints = {
    }
}
