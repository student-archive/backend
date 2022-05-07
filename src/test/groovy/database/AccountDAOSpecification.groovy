package database

import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.models.Account
import spock.lang.Specification

class AccountDAOSpecification extends Specification {
  def "Select from accounts table should return 14 rows"() {
    given:
      AccountDao dao = new AccountDao()
      List<Account> accounts = dao.getAll()

    expect:
      accounts.size() == 14
  }
}
