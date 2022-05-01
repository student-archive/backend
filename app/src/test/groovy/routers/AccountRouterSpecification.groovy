package routers


import com.google.gson.JsonParseException
import com.google.gson.JsonParser
import com.mashape.unirest.http.Unirest
import spock.lang.Shared
import spock.lang.Specification

class AccountRouterSpecification extends Specification {
    @Shared
            BASE_URL = "http://localhost:4567/account"

    def "GET request should return exactly one account"() {
        given:
        def id = "ebbce63a-ece0-4aec-9b95-0eefb63113e6"
        def response = Unirest.get("${BASE_URL}/${id}").asJson()

        when:
        def account = JsonParser.parseString(response.getBody().toString()).getAsJsonObject()

        then:
        response.getStatus() == 200
        notThrown(JsonParseException)
        notThrown(IllegalStateException)
        account != null
        account.get("id").getAsString() == id.toString()
    }
}