package client;

import org.junit.jupiter.api.Test;
import ru.qa.api.client.DefaultClient;
import ru.qa.api.client.DefaultRequest;
import ru.qa.api.client.enums.HttpMethod;

import java.util.List;

public class ClientWithObjectBodyTest {
    @Test
    void postObjectBodyTest() {

        Pet pet = new Pet(0,
                new Category(0, "string"),
                "doggie",
                List.of("string"),
                List.of(new Tag(0, "string")),
                "available");

        DefaultRequest request = new DefaultRequest();

        request.setUri("https://petstore.swagger.io/v2/pet")
                .setBodyAsJSON(pet)
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setMethod(HttpMethod.POST);

        new DefaultClient()
                .execute(request)
                .shouldBeStatusCode(200);
    }

    record Pet (long id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status){}
    record Category(long id, String name){}
    record Tag(long id, String name){}
}
