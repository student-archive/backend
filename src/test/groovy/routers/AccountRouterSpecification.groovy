package routers

import com.github.javafaker.Faker
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.mashape.unirest.http.Unirest
import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.models.Account
import ru.zgz.star.backend.responses.DeletedResponse
import spock.lang.Shared
import util.BaseRouterSpecification

class AccountRouterSpecification extends BaseRouterSpecification {
  @Shared
          BASE_URL = "http://localhost:4567/account"

  @Shared
          sampleAccount = null

  @Shared
          emailAddress = new Faker().internet().emailAddress()

  def setupSpec() {
    def dao = new AccountDao()
    dao.add(new Account()
            .setEmail(emailAddress)
            .setPasswordHash("superDuperSecurePassword")
            .setLastActiveDate(1234567))
    sampleAccount = dao.getByEmail(emailAddress)
  }

  def "GET request should return valid json"() {
    given:
      def response = Unirest.get("${BASE_URL}/${this.sampleAccount.id.toString()}").asString()

    when:
      def account = new Gson().fromJson(response.body, Account)

    then:
      response.getStatus() == 200
      account != null
      notThrown(JsonParseException)
  }

  def "GET request should return exactly one account"() {
    given:
      def response = Unirest.get("${BASE_URL}/${this.sampleAccount.id.toString()}").asString()

    when:
      new Gson().fromJson(response.body, Account)

    then:
      response.getStatus() == 200
      notThrown(IllegalStateException)
  }

  def "GET request should return account with requested id"() {
    given:
      def response = Unirest.get("${BASE_URL}/${this.sampleAccount.id.toString()}").asString()

    when:
      def account = new Gson().fromJson(response.body, Account)

    then:
      response.getStatus() == 200
      account != null
      account.id == sampleAccount.id
  }

  def "DELETE request should successfully delete one exact account"() {
    given:
      def response = Unirest.delete("${BASE_URL}/${this.sampleAccount.id.toString()}").asString()

    when:
      DeletedResponse deletedAccount = new Gson().fromJson(response.body, DeletedResponse)

    then:
      response.getStatus() == 200
      deletedAccount.deletedId == sampleAccount.id

  }

  def "DELETE request should fail with missing id"() {
    when:
      def response = Unirest.delete("${BASE_URL}/becc9be4-93c1-4b1a-8a6b-1c2c410e4207").asString()
    then:
      response.getStatus() == 404
  }

  def "DELETE request should fail with illegal id"() {
    when:
      def response = Unirest.delete("${BASE_URL}/1234").asString()

    then:
      response.getStatus() == 400
  }

  def "PATCH request should successfully update one exact account"() {
    given:
      def emailAddress = new Faker().internet().emailAddress()
      def response = Unirest.patch("${BASE_URL}/${this.sampleAccount.id.toString()}").body(new Gson().toJson(new Account().setEmail(emailAddress))).asString()

    when:
      Account updatedAccount = new Gson().fromJson(response.body, Account)

    then:
      response.getStatus() == 200
      updatedAccount.id == sampleAccount.id
      updatedAccount.email == emailAddress
  }

  def "PATCH request should fail with missing id"() {
    when:
      def response = Unirest.patch("${BASE_URL}/becc9be4-93c1-4b1a-8a6b-1c2c410e4207").body(new Gson().toJson(new Account().setEmail(emailAddress))).asString()
    then:
      response.getStatus() == 404
  }

  def "PATCH request should fail with illegal id"() {
    when:
      def response = Unirest.patch("${BASE_URL}/1234").body(new Gson().toJson(new Account().setEmail(emailAddress))).asString()

    then:
      response.getStatus() == 400
  }

  def cleanupSpec() {
    def dao = new AccountDao()
    dao.deleteAll()
  }
}
