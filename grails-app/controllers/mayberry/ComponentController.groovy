package mayberry

class ComponentController {
    def componentService
    def index() { 
        def list = componentService.list() ///Component.list()
        render(view:'index',model:[components:list])
    }
}
