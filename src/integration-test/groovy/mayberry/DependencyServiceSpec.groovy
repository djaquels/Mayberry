package mayberry

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DependencyServiceSpec extends Specification {

    DependencyService dependencyService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Dependency(...).save(flush: true, failOnError: true)
        //new Dependency(...).save(flush: true, failOnError: true)
        //Dependency dependency = new Dependency(...).save(flush: true, failOnError: true)
        //new Dependency(...).save(flush: true, failOnError: true)
        //new Dependency(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //dependency.id
    }

    void "test get"() {
        setupData()

        expect:
        dependencyService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Dependency> dependencyList = dependencyService.list(max: 2, offset: 2)

        then:
        dependencyList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dependencyService.count() == 5
    }

    void "test delete"() {
        Long dependencyId = setupData()

        expect:
        dependencyService.count() == 5

        when:
        dependencyService.delete(dependencyId)
        sessionFactory.currentSession.flush()

        then:
        dependencyService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Dependency dependency = new Dependency()
        dependencyService.save(dependency)

        then:
        dependency.id != null
    }
}
