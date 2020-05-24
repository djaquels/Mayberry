package mayberry

class ComponentController {
    def componentService
    def squadService
    def index() { 
        def list = componentService.list() ///Component.list()
        render(view:'index',model:[components:list])
    }
    def create(){
        //https://gitlab.com/heptorsj/spring-seed.git
        String seed = "https://gitlab.com/heptorsj/spring-seed.git"
        def tech = params.framework
        def squads = squadService.list()
        [seed: seed ,framework: tech, squads: squads]
    }

    def view(Long id){
        def component = componentService.get(id)
        render(view:'view',model:[component:component])
    }
    def newComponent(){
        def list = componentService.list() ///Component.list()
        // here the component is created
        def name = params.name
        def url = params.url
        def port = params.port
        def dname = params.discoverName
        def squad = params.idSquad
        def token = params.token
        def mensaje = "Component " + name + " created."
        def service = new Component(name: name, url: url, port: port, discoverName: dname, idSquad: squad)
        service.save()
        render(view:'index',model:[components:list, mensaje: mensaje])
    }
}
