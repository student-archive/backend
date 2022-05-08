package database

import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.models.Account
import spock.lang.Specification

class AccountDAOSpecification extends Specification {
  def "Create new account in database and verify it"() {
    given: "Creating data access object"
      AccountDao dao = new AccountDao()
      def added = new Account("test@example.com", "someSuperDuperSecurePassword", 1234)

    when: "Adding new record"
      dao.add(added)

    then: "Fetching it and verifying"
      def fetched = dao.getByEmail("test@example.com")
      fetched.email == added.email
      fetched.passwordHash == added.passwordHash
      fetched.lastActiveDate == added.lastActiveDate
  }

  def "Select from accounts table should return 1 row"() {
    given: "Creating data access object"
      AccountDao dao = new AccountDao()

    when: "Fetching all records from account table"
      List<Account> accounts = dao.getAll()

    then: "Count of records in the table should be equal 1"
      accounts.size() == 1
  }

  def "Delete all records in account table"() {
    given: "Creating data access object"
      AccountDao dao = new AccountDao()

    when: "Deleting all records in table and fetching all records"
      dao.deleteAll()
      List<Account> accounts = dao.getAll()

    then: "Verifying that all records was deleted"
      accounts.size() == 0

  }
}
