package mayberry

class PortsController {
    def componentService
    def index() { 
        def list = componentService.list() ///Component.list()
        render(view:'index',model:[components:list])

    }
    def view(Long id){
        def squad = squadService.get(id)
        render(view:'view',model:[squad:squad])
    }
}
