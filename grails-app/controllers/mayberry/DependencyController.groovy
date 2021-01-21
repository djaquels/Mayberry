package mayberry

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DependencyController {

    DependencyService dependencyService
    ComponentService componentService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def newDependency(){
        def grade = params.grade.toInteger()
        def idC1 = params.c1.toInteger()
        def idC2  = params.c2.toInteger()
        def detail = params.detail.toString()
        def mensaje = "New Depedency created."
        def componentsList = componentService.list()
        def db = new Dependency(grade: grade, idC1: idC1, idC2: idC2, detail:detail)
        dependencyService.save(db)
        render(view:'index',model:[list: componentsList, mensaje: mensaje])

    }
    def index(Integer max) {
        def list = dependencyService.list() ///Component.list()
        render(view:'index',model:[dependencies:list])
    }

    def show(Long id) {
        respond dependencyService.get(id)
    }

    def create(){
        def componentsList = componentService.list()
        [ list: componentsList]
    }

    def save(Dependency dependency) {
        if (dependency == null) {
            notFound()
            return
        }

        try {
            dependencyService.save(dependency)
        } catch (ValidationException e) {
            respond dependency.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dependency.label', default: 'Dependency'), dependency.id])
                redirect dependency
            }
            '*' { respond dependency, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond dependencyService.get(id)
    }

    def update(Dependency dependency) {
        if (dependency == null) {
            notFound()
            return
        }

        try {
            dependencyService.save(dependency)
        } catch (ValidationException e) {
            respond dependency.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dependency.label', default: 'Dependency'), dependency.id])
                redirect dependency
            }
            '*'{ respond dependency, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dependencyService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dependency.label', default: 'Dependency'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dependency.label', default: 'Dependency'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
