package routers


import com.google.gson.JsonParseException
import com.google.gson.JsonParser
import com.mashape.unirest.http.Unirest
import spock.lang.Shared
import spock.lang.Specification

class AccountRouterSpecification extends Specification {
    @Shared
            BASE_URL = "http://localhost:4567/account"
    @Shared
            id = "ebbce63a-ece0-4aec-9b95-0eefb63113e6"

    def "GET request should return valid json"() {
        given:
        def response = Unirest.get("${BASE_URL}/${id}").asJson()

        when:
        def account = JsonParser.parseString(response.getBody().toString()).getAsJsonObject()

        then:
        response.getStatus() == 200
        account != null
        notThrown(JsonParseException)
    }

    def "GET request should return exactly one account" () {
        given:
        def response = Unirest.get("${BASE_URL}/${id}").asJson()

        when:
        JsonParser.parseString(response.getBody().toString()).getAsJsonObject()

        then:
        response.getStatus() == 200
        notThrown(IllegalStateException)
    }


    def "GET request should return account with requested id"() {
        given:
        def response = Unirest.get("${BASE_URL}/${id}").asJson()

        when:
        def account = JsonParser.parseString(response.getBody().toString()).getAsJsonObject()

        then:
        response.getStatus() == 200
        account != null
        account.get("id").getAsString() == id.toString()
    }
}