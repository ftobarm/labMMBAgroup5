package labmmba

class Book {
    static hasMany = [
            user: UserBook
    ]
    String title
    Integer year
    String isbn
    String editorial
    String url

    static constraints = {
    }
}
