package mayberry

import grails.gorm.services.Service

@Service(Dependency)
interface DependencyService {

    Dependency get(Serializable id)

    def list(Map args)

    Long count()

    void delete(Serializable id)

    Dependency save(Dependency dependency)

}