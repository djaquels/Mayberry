package mayberry

import grails.gorm.transactions.Transactional

@Transactional
class ComponentService {

    def serviceMethod() {

    }
    def list() {
        Component.list()
    }
    def get(Long id){
        Component.get(id)
    }
}
