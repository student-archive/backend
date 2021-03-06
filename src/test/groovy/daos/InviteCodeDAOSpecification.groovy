package daos

import com.github.javafaker.Faker
import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.daos.InviteCodeDao
import ru.zgz.star.backend.models.Account
import ru.zgz.star.backend.models.InviteCode
import spock.lang.Shared
import spock.lang.Specification

import java.time.Instant

class InviteCodeDAOSpecification extends Specification {

  @Shared
  def emailAddress = new Faker().internet().emailAddress()

  @Shared
  UUID inviteId

  def setupSpec() {
    def dao = new InviteCodeDao()
    dao.deleteAll()
  }

  def "Create new invite code and verify it"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()
      def added_invite = new InviteCode().setInviteCode("qwerty").setIsValid(true)

    when: "Create new invite code"
      invite_dao.add(added_invite)
      def fetched_invite = invite_dao.getByCode("qwerty")
      inviteId = fetched_invite.id as UUID

    then: "Verify that invite code is created correctly"
      fetched_invite.id != null
      fetched_invite.inviteCode == "qwerty"
      fetched_invite.isValid
      fetched_invite.activationDate == 0
      fetched_invite.account == null


  }

  def "Create used invite code"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()
      def account_dao = new AccountDao()
      def activationDate = Instant.now().getEpochSecond() as Integer
      def added_account = new Account().setEmail(emailAddress).setPasswordHash("super_secret").setLastActiveDate(Instant.now().getEpochSecond() as Integer)
      def added_invite = new InviteCode().setInviteCode("ytrewq").setIsValid(false).setActivationDate(activationDate)

    when: "Create invalid invite code"
      account_dao.add(added_account)
      def account = account_dao.getByEmail(emailAddress)
      added_invite.setAccount(account.id)
      invite_dao.add(added_invite)

    then: "Verify that invite code is created correctly"
      def fetched_invite = invite_dao.getByCode("ytrewq")
      fetched_invite.id != null
      fetched_invite.inviteCode == "ytrewq"
      !fetched_invite.isValid
      fetched_invite.activationDate == activationDate
      fetched_invite.account == account.id
  }

  def "Create invalid invite code (used, but no account passed)"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()
      def added_invite = new InviteCode().setInviteCode("dsfgh").setIsValid(false)

    when: "Create invalid invite code"
      invite_dao.add(added_invite)

    then: "Should IllegalArgumentException be thrown"
      def e = thrown(IllegalArgumentException)
      e.message == "Invalid invite code must have account"
  }

  def "Create invalid invite code (used, but no activation date passed)"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()
      def added_invite = new InviteCode().setInviteCode("dsfgh").setIsValid(false)
      def account_dao = new AccountDao()
      def account = account_dao.getByEmail(emailAddress)
      added_invite.setAccount(account.id)

    when: "Create invalid invite code"
      invite_dao.add(added_invite)

    then: "Should IllegalArgumentException be thrown"
      def e = thrown(IllegalArgumentException)
      e.message == "Invalid invite code must have activation date"
  }

  def "Create invalid invite code (unused, but account passed)"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()
      def account_dao = new AccountDao()
      def account = account_dao.getByEmail(emailAddress)
      def added_invite = new InviteCode().setInviteCode("dcfvgbhnjmk").setIsValid(true).setAccount(account.id)

    when: "Create invalid invite code"
      invite_dao.add(added_invite)

    then: "Should IllegalArgumentException be thrown"
      def e = thrown(IllegalArgumentException)
      e.message == "Valid invite code must not have account"
  }

  def "Create invalid invite code (unused, but activation date passed)"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()
      def added_invite = new InviteCode().setInviteCode("dsfgh").setIsValid(true).setActivationDate(Instant.now().getEpochSecond() as Integer)

    when: "Create invalid invite code"
      invite_dao.add(added_invite)

    then: "Should IllegalArgumentException be thrown"
      def e = thrown(IllegalArgumentException)
      e.message == "Valid invite code must not have activation date"
  }

  def "Get by id should return same invite code as get by code"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()

    when: "Fetch invite code by id and by code"
      def got_by_code = invite_dao.getByCode("qwerty")
      def invite_id = invite_dao.getById(got_by_code.id as String)

    then: "Fetched invite codes should be the same"
      got_by_code.id == invite_id.id
      got_by_code.inviteCode == invite_id.inviteCode
      got_by_code.isValid == invite_id.isValid
      got_by_code.activationDate == invite_id.activationDate
      got_by_code.account == invite_id.account
  }

  def "Select from invite code should return 2 row"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()

    when: "Select from invite code"
      def invite_code = invite_dao.getAll()

    then: "Should return 2 row"
      invite_code.size() == 2
  }


  def "Update invite code"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()

    when: "Update invite code"
      def invite_code = invite_dao.getByCode("qwerty")
      invite_code.setInviteCode("qwerty2")
      invite_dao.update(invite_code)

    then: "Should return updated invite code"
      def updated_invite_code = invite_dao.getByCode("qwerty2")
      updated_invite_code.id == invite_code.id
      updated_invite_code.inviteCode == "qwerty2"
      updated_invite_code.isValid == invite_code.isValid
      updated_invite_code.activationDate == invite_code.activationDate
      updated_invite_code.account == invite_code.account

  }

  def "Update invalid invite code (used, but no account passed)"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()

    when: "Update invalid invite code"
      def invite_code = invite_dao.getByCode("qwerty2")
      invite_code.setIsValid(false)
      invite_dao.update(invite_code)

    then: "Should IllegalArgumentException be thrown"
      def e = thrown(IllegalArgumentException)
      e.message == "Invalid invite code must have account"
  }

  def "Update invalid invite code (used, but no activation date passed)"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()
      def account_dao = new AccountDao()

    when: "Update invalid invite code"
      def invite_code = invite_dao.getByCode("qwerty2")
      def account = account_dao.getByEmail(emailAddress)
      invite_code.setIsValid(false).setAccount(account.id)
      invite_dao.update(invite_code)

    then: "Should IllegalArgumentException be thrown"
      def e = thrown(IllegalArgumentException)
      e.message == "Invalid invite code must have activation date"
  }

  def "Update invalid invite code (unused, but account passed)"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()
      def account_dao = new AccountDao()

    when: "Update invalid invite code"
      def invite_code = invite_dao.getByCode("qwerty2")
      def account = account_dao.getByEmail(emailAddress)
      invite_code.setIsValid(true).setAccount(account.id)
      invite_dao.update(invite_code)

    then: "Should IllegalArgumentException be thrown"
      def e = thrown(IllegalArgumentException)
      e.message == "Valid invite code must not have account"
  }

  def "Update invalid invite code (unused, but activation date passed)"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()

    when: "Update invalid invite code"
      def invite_code = invite_dao.getByCode("qwerty2")
      invite_code.setIsValid(true).setActivationDate(Instant.now().getEpochSecond() as Integer)
      invite_dao.update(invite_code)

    then: "Should IllegalArgumentException be thrown"
      def e = thrown(IllegalArgumentException)
      e.message == "Valid invite code must not have activation date"
  }


  def "Delete invite code"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()

    when: "Delete invite code"
      invite_dao.deleteById(inviteId)

    then: "Should return false"
      !invite_dao.findById(inviteId)

  }

  def "Delete all records in invite code table"() {
    given: "Create data access object"
      def invite_dao = new InviteCodeDao()

    when: "Delete all records in invite code table"
      invite_dao.deleteAll()
      def invite_codes = invite_dao.getAll()

    then: "Should return 0 rows"
      invite_codes.size() == 0
  }

}
