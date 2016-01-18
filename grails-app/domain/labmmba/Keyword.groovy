package labmmba

class Keyword {
    static hasMany = [
            magazine: KeywordMagazine
    ]
    String name

    static constraints = {
    }
}
