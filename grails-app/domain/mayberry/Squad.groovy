package mayberry

class Squad {

    Integer id
    String name
    static mapping = {
        table 'squad'
        version false
        id column: 'id'
        name column: 'name'
    }
}
