package routers

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.mashape.unirest.http.Unirest
import ru.zgz.star.backend.daos.AccountDao
import ru.zgz.star.backend.daos.InviteCodeDao
import ru.zgz.star.backend.models.InviteCode
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
}
