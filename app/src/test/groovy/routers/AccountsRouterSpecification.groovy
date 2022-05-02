package routers

import com.google.gson.JsonParseException
import com.google.gson.JsonParser
import com.mashape.unirest.http.Unirest
import spock.lang.Shared

class AccountsRouterSpecification extends BaseRouterSpecification {
    @Shared
            BASE_URL = "http://localhost:4567/accounts"

    def "GET request should return valid json"() {
        given:
        def response = Unirest.get(BASE_URL).asJson()

        when:
        def account = JsonParser.parseString(response.getBody().toString()).getAsJsonArray()

        then:
        response.getStatus() == 200
        account != null
        notThrown(JsonParseException)
    }
}
