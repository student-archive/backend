import ru.zgz.star.backend.models.Account
import ru.zgz.star.backend.repository.DAO
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

    def "Select from accounts table should return 14 rows"() {
        given:
        DAO<Account> dao = new DAO<>(Account.class)

        when:
        List<Account> accounts = dao.findAll()

        then:
        accounts.size() == 14
    }
}
