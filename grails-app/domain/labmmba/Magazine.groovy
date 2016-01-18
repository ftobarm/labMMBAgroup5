package labmmba

class Magazine {
    static hasMany = [
            user: UserMagazine,
            keyword: Keyword
    ]
    static belongsTo = [
            area: InvestigationArea
    ]
    Integer year
    String magazineName
    String paper
    String url
    static constraints = {
    }
}
