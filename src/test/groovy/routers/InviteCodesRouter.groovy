package routers

import com.google.gson.Gson
import com.mashape.unirest.http.Unirest
import ru.zgz.star.backend.models.InviteCode
import spock.lang.Shared
import util.BaseRouterSpecification

class InviteCodesRouter extends BaseRouterSpecification {
  @Shared
          BASE_URL = "http://localhost:4567/inviteCodes"

  @Shared sampleInvite = new InviteCode("qwerty", true, null, null)

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
}
