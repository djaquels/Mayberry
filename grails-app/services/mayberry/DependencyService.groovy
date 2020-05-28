package mayberry

import grails.gorm.transactions.Transactional

@Transactional
class DependencyService {

    def serviceMethod() {

    }
    def list() {
        Dependency.list()
    }
    def get(Long id){
        Dependency.get(id)
    }
    def delete(Long id){
        def dependency = Dependency.get(id)
        dependency.delete()
    }
    def save(Dependency dependency){
        dependency.save()
    }

}
