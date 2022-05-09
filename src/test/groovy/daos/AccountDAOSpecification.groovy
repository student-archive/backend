package daos

import com.github.javafaker.Faker
import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.models.Account
import spock.lang.Shared
import spock.lang.Specification

class AccountDAOSpecification extends Specification {

  @Shared
          emailAddress = new Faker().internet().emailAddress()
  
  def "Create new account in database and verify it"() {
    given: "Creating data access object"
      AccountDao dao = new AccountDao()
      def added = new Account(emailAddress, "someSuperDuperSecurePassword", 1234)

    when: "Adding new record"
      dao.add(added)

    then: "Fetching it and verifying"
      def fetched = dao.getByEmail(emailAddress)
      fetched.email == added.email
      fetched.passwordHash == added.passwordHash
      fetched.lastActiveDate == added.lastActiveDate
  }

  def "Get by Id should return same Account as get by email"() {
    given: "Creating data access object"
      AccountDao dao = new AccountDao()

    when: "Fetching account by id and by email"
      Account gotByEmail = dao.getByEmail(emailAddress)
      Account gotById = dao.getById((String)gotByEmail.id.toString())

    then: "Fetched accounts should match"
      gotByEmail.id == gotById.id
      gotByEmail.email == gotById.email
      gotByEmail.passwordHash == gotById.passwordHash
      gotByEmail.lastActiveDate == gotById.lastActiveDate

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
