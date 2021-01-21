package mayberry

class Dependency {
    
    Integer grade
    Integer idC1
    Integer idC2
    Integer id
    String detail
    static mapping = {
        table 'dependencies'
        version false
        id generator: 'identity'
        grade column: 'grade'
        idC1 column: 'id_c1'
        idC2 column: 'id_c2'
        detail  column: 'detail'

    }
}
