package mayberry

class SquadController {
    def squadService
    def index() { 
        def list = squadService.list() ///Component.list()
        render(view:'index',model:[squads:list])

    }
}
