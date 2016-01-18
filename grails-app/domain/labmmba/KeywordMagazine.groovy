package labmmba

class KeywordMagazine {
    static belongsTo = [
            magazine: Magazine,
            keyword: Keyword
    ]
    static constraints = {
    }
}
