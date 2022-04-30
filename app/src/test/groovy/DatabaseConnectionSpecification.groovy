import ru.zgz.star.backend.util.HibernateUtil
import spock.lang.Specification

class DatabaseConnectionSpecification extends Specification{
    def "should create HibernateUtil without exceptions" () {
        when:
        new HibernateUtil()
        then:
        notThrown(ExceptionInInitializerError)
    }
}
