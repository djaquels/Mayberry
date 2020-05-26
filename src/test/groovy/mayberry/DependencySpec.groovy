package mayberry

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DependencySpec extends Specification implements DomainUnitTest<Dependency> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
