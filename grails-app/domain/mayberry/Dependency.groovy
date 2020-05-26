package mayberry

class Dependency {
    
    Integer grade
    Integer idC1
    Integer idC2
    static mapping = {
        table 'dependencies'
        version false
        grade column: 'grade'
        idC1 column: 'id_c1'
        idC2 column: 'id_c2'
    }
    static constraints = {
    }
}
