package routers

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.mashape.unirest.http.Unirest
import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.daos.InviteCodeDao
import ru.zgz.star.backend.models.InviteCode
import ru.zgz.star.backend.responses.DeletedResponse
import ru.zgz.star.backend.responses.ErrorResponse
import spock.lang.Shared
import util.BaseRouterSpecification

class InviteCodeSpecification extends BaseRouterSpecification {

  @Shared
          BASE_URL = "http://localhost:4567/inviteCode"
  @Shared
          sampleInviteCode = null

  def setupSpec() {
    def accountDao = new AccountDao()
    accountDao.deleteAll()
  }

  def "GET request should return one record"() {
    given:
      def dao = new InviteCodeDao()
      dao.add(new InviteCode("123456", true, null, null))
      sampleInviteCode = dao.getByCode("123456")
      def response = Unirest.get("${BASE_URL}/${this.sampleInviteCode.id.toString()}").asString()

    when:
      def inviteCode = new Gson().fromJson(response.body, InviteCode)

    then:
      response.getStatus() == 200
      inviteCode != null
      notThrown(JsonParseException)
  }

  def "GET request with nonexistent code should return 404"() {
    given:
      def response = Unirest.get("${BASE_URL}/89877b52-67d3-4769-bf92-ec5ff8b79b14").asString()

    when:
      def inviteCode = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 404
      inviteCode.message == "InviteCode id=89877b52-67d3-4769-bf92-ec5ff8b79b14 not found"
  }

  def "GET request with invalid code should return 400"() {
    given:
      def response = Unirest.get("${BASE_URL}/12345").asString()

    when:
      def inviteCode = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 400
      inviteCode.message == "Given UUID (12345) is not valid"
  }

  def "DELETE request should delete one record"() {
    given:
      def response = Unirest.delete("${BASE_URL}/${this.sampleInviteCode.id.toString()}").asString()
      def dao = new InviteCodeDao()

    when:
      DeletedResponse inviteCode = new Gson().fromJson(response.body, DeletedResponse)

    then:
      !dao.findById(inviteCode.deletedId)
  }

  def "DELETE request with nonexistent code should return 404"() {
    given:
      def response = Unirest.delete("${BASE_URL}/89877b52-67d3-4769-bf92-ec5ff8b79b14").asString()

    when:
      def inviteCode = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 404
      inviteCode.message == "InviteCode id=89877b52-67d3-4769-bf92-ec5ff8b79b14 not found"
  }

  def "DELETE request with invalid code should return 400"() {
    given:
      def response = Unirest.delete("${BASE_URL}/12345").asString()

    when:
      def inviteCode = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 400
      inviteCode.message == "Given UUID (12345) is not valid"

  }

  def "POST request should return 405"() {
    given:
      def response = Unirest.post("${BASE_URL}/12345").asString()

    when:
      def inviteCode = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 405
      inviteCode.message == "Method POST is not allowed for this resource"
  }

  def "PUT request should return 405"() {
    given:
      def response = Unirest.put("${BASE_URL}/12345").asString()

    when:
      def inviteCode = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 405
      inviteCode.message == "Method PUT is not allowed for this resource"

  }

  def "PATCH request should return 405"() {
    given:
      def response = Unirest.patch("${BASE_URL}/12345").asString()

    when:
      def inviteCode = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 405
      inviteCode.message == "Method PATCH is not allowed for this resource"

  }

}
