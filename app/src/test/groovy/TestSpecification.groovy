import spock.lang.Specification

class TestSpecification extends Specification {
    def "simple assertion" () {
        expect:
            1 == 1
    }
}
