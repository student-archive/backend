package routers

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.mashape.unirest.http.Unirest
import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.models.Account
import spock.lang.Shared

class AccountRouterSpecification extends BaseRouterSpecification {
  @Shared
          BASE_URL = "http://localhost:4567/account"

  @Shared
          sampleAccount = null

  def setup() {
    def dao = new AccountDao()
    dao.add(new Account()
            .setEmail("test@example.com")
            .setPasswordHash("superDuperSecurePassword")
            .setLastActiveDate(1234567))
    sampleAccount = dao.getByEmail("test@example.com")
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

  def cleanup() {
    def dao = new AccountDao()
    dao.deleteAll()
  }
}
