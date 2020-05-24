package mayberry

class Component {
    Integer id
    String name
    String url
    Integer port
    static mapping = {
        table 'component'
        version false
        id column: 'id'
        name column: 'name'
        url column: 'url'
        port column: 'port'
    }
}
