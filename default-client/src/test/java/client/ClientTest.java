package client;

import org.junit.jupiter.api.Test;
import ru.qa.api.client.DefaultClient;
import ru.qa.api.client.DefaultRequest;
import ru.qa.api.client.enums.HttpMethod;
import java.util.Map;

public class ClientTest {

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
}
