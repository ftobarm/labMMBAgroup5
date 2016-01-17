package labmmba

class Study {
    static belongsTo = [
            user : Usuario,
            country : Country,
            university: University
    ]
    String name
    String grade
    static constraints = {
    }
}
