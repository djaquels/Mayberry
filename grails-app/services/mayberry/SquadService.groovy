package mayberry

import grails.gorm.transactions.Transactional

@Transactional
class SquadService {

    def serviceMethod() {

    }
    def list() {
        Squad.list()
    }
    def get(Long id){
        Squad.get(id)
    }
    
}
