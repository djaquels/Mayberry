package mayberry

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class FrameworkSpec extends Specification implements DomainUnitTest<Framework> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
