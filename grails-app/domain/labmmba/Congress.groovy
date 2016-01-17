package labmmba

class Congress {
    static belongsTo = [
            country : Country
    ]
    static hasMany=[
            user : UserCongress
    ]
    String name
    String startDate
    String endDate
    String city

    static constraints = {
        user nullable: true
    }
}
