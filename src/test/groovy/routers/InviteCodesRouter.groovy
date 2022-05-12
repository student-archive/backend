package routers

import com.google.gson.Gson
import com.mashape.unirest.http.Unirest
import ru.zgz.star.backend.models.InviteCode
import ru.zgz.star.backend.responses.ErrorResponse
import spock.lang.Shared
import util.BaseRouterSpecification

class InviteCodesRouter extends BaseRouterSpecification {
  @Shared
          BASE_URL = "http://localhost:4567/inviteCodes"

  @Shared sampleInvite = new InviteCode("qwerty", true, null, null)

  def "GET request should return MethodNotAllowed"() {
    given:
      def response = Unirest.get("${BASE_URL}").asString()

    when:
      ErrorResponse error = new Gson().fromJson(response.body, ErrorResponse)

    then:
      response.getStatus() == 405
      error.message == "Method GET is not allowed for this resource"
  }

  def "POST request should create new record"() {
    given:
      def response = Unirest.post("${BASE_URL}").body(new Gson().toJson(sampleInvite)).asString()

    when:
      def inviteCode = new Gson().fromJson(response.body, InviteCode)

    then:
      response.getStatus() == 201
      inviteCode != null
      inviteCode.getInviteCode() == sampleInvite.getInviteCode()
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
}
