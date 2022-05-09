package routers

import com.github.javafaker.Faker
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.mashape.unirest.http.Unirest
import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.models.Account
import spock.lang.Shared
import util.BaseRouterSpecification

class AccountsRouterSpecification extends BaseRouterSpecification {
  @Shared
          BASE_URL = "http://localhost:4567/accounts"

  @Shared
          sampleAccount = null

  @Shared
          emailAddress = new Faker().internet().emailAddress()

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
      def response = Unirest.post("${BASE_URL}").body(new Gson().toJson(sampleAccount)).asString()

    when:
      def account = new Gson().fromJson(response.body, Account)

    then:
      response.getStatus() == 201
      account != null
      account.getEmail() == sampleAccount.getEmail()
  }

  def cleanup() {
    def dao = new AccountDao()
    dao.deleteAll()
  }
}
