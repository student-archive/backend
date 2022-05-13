package routers

import com.github.javafaker.Faker
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.mashape.unirest.http.Unirest
import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.models.Account
import ru.zgz.star.backend.responses.ErrorResponse
import spock.lang.Shared
import util.BaseRouterSpecification

class AccountsRouterSpecification extends BaseRouterSpecification {
  @Shared
          BASE_URL = "http://localhost:4567/accounts"

  @Shared
          sampleAccount = null

  @Shared
          emailAddress = new Faker().internet().emailAddress()

  def setupSpec() {
    def dao = new AccountDao()
    dao.deleteAll()
  }

  def setup() {
    def dao = new AccountDao()
    dao.add(new Account()
            .setEmail(emailAddress)
            .setPasswordHash("superDuperSecurePassword")
            .setLastActiveDate(1234567))
    sampleAccount = dao.getByEmail(emailAddress)
  }

  def "GET request should return valid json"() {
    given:
      def response = Unirest.get("${BASE_URL}").asString()

    when:
      def account = new Gson().fromJson(response.body, List<Account>)

    then:
      response.getStatus() == 200
      account != null
      notThrown(JsonParseException)
  }

  def "POST request should create new account"() {
    given:
      def newAccount = new Account().setEmail(new Faker().internet().emailAddress()).setPasswordHash("sdafgbhj").setLastActiveDate(0)
      def response = Unirest.post("${BASE_URL}").body(new Gson().toJson(newAccount)).asString()

    when:
      def account = new Gson().fromJson(response.body, Account)

    then:
      response.getStatus() == 201
      account != null
      account.getEmail() == newAccount.getEmail()
  }

  def "PUT request should return MethodNotAllowed"() {
    given:
      def response = Unirest.put("${BASE_URL}").asString()

    when:
      ErrorResponse error = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 405
      error.message == "Method PUT is not allowed for this resource"
  }

  def "PATCH request should return MethodNotAllowed"() {
    given:
      def response = Unirest.patch("${BASE_URL}").asString()

    when:
      ErrorResponse error = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 405
      error.message == "Method PATCH is not allowed for this resource"
  }

  def "DELETE request should return MethodNotAllowed"() {
    given:
      def response = Unirest.delete("${BASE_URL}").asString()

    when:
      ErrorResponse error = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 405
      error.message == "Method DELETE is not allowed for this resource"
  }

  def cleanup() {
    def dao = new AccountDao()
    dao.deleteAll()
  }

  def cleanupSpec() {
    cleanup()
  }
}
