package client;

import org.junit.jupiter.api.Test;
import ru.qa.api.client.DefaultClient;
import ru.qa.api.client.DefaultHeader;
import ru.qa.api.client.DefaultRequest;
import ru.qa.api.client.enums.HttpMethod;

import java.util.List;
import java.util.Map;

public class ClientWithStringBodyTest {

    //https://aviationweather.gov/data/api/#schema
    @Test
    void getRequestTest() {
        DefaultRequest request = new DefaultRequest();

        request
                .setUri("https://aviationweather.gov/api/data/metar")
                .setQueries(Map.of(
                        "ids", "KMCI",
                        "format", "json"
                ))
                .setMethod(HttpMethod.GET);

        new DefaultClient()
                .execute(request)
                .shouldBeStatusCode(200);
    }

    @Test
    void postStringRequestTest() {
        DefaultRequest request = new DefaultRequest();

        request.setUri("https://petstore.swagger.io/v2/pet")
                .setBody("""
                        {
                        "id": 0,
                        "category": {
                          "id": 0,
                          "name": "string"
                        },
                        "name": "doggie",
                        "photoUrls": [
                          "string"
                        ],
                        "tags": [
                          {
                            "id": 0,
                            "name": "string"
                          }
                        ],
                        "status": "available"
                        }
                        """)
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setMethod(HttpMethod.POST);

        new DefaultClient()
                .execute(request)
                .shouldBeStatusCode(200);
    }

    @Test
    void putStringRequest(){
        DefaultRequest request = new DefaultRequest();

        request.setUri("https://petstore.swagger.io/v2/pet")
                .setBody("""
                        {
                          "id": 0,
                          "category": {
                            "id": 0,
                            "name": "string"
                          },
                          "name": "doggie",
                          "photoUrls": [
                            "string"
                          ],
                          "tags": [
                            {
                              "id": 0,
                              "name": "string"
                            }
                          ],
                          "status": "available"
                        }
                        """)
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setMethod(HttpMethod.PUT);

        new DefaultClient()
                .execute(request)
                .shouldBeStatusCode(200);
    }

    @Test
    void deleteRequest() {
        DefaultRequest request = new DefaultRequest();
        String id = "1";

        request.setUri("https://petstore.swagger.io/v2/pet/".concat(id))
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setMethod(HttpMethod.DELETE);

        new DefaultClient()
                .execute(request)
                .shouldBeStatusCode(200);
    }

    @Test
    void deleteRequestWithHeadersList() {
        DefaultRequest request = new DefaultRequest();
        String id = "2";

        request.setUri("https://petstore.swagger.io/v2/pet/".concat(id))
                .addHeaders(List.of(
                        new DefaultHeader("accept", "application/json"),
                        new DefaultHeader("Content-Type", "application/json")))
                .setMethod(HttpMethod.DELETE);

        new DefaultClient()
                .execute(request)
                .shouldBeStatusCode(200);
    }
}
