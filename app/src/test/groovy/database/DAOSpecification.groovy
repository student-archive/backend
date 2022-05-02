package database

import ru.zgz.star.backend.models.Account
import ru.zgz.star.backend.repository.DAO
import spock.lang.Specification

class DAOSpecification extends Specification {
    def "Select from accounts table should return 14 rows"() {
        given:
        DAO<Account> dao = new DAO<>(Account.class)

        when:
        List<Account> accounts = dao.findAll()

        then:
        accounts.size() == 14
    }
}
