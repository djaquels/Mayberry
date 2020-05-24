package mayberry

class Component {
    Integer id
    String name
    String url
    Integer port
    String discoverName
    Integer idSquad
    static mapping = {
        table 'component'
        id generator: 'identity'
        version false
        name column: 'name'
        url column: 'url'
        port column: 'port'
        discoverName column: 'discover_name'
        idSquad column: 'id_squad'
    }
}
