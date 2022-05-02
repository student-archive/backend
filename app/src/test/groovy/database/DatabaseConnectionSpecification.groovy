package database


import ru.zgz.star.backend.util.HibernateUtil
import spock.lang.Specification
import spock.lang.Title

@Title("Tests connection to database and DAO")
class DatabaseConnectionSpecification extends Specification {
    def "Should create HibernateUtil without exceptions"() {
        when:
        new HibernateUtil()
        then:
        notThrown(ExceptionInInitializerError)
    }
}
