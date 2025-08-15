package client;

import org.junit.jupiter.api.Test;
import ru.qa.api.client.DefaultClient;
import ru.qa.api.client.DefaultRequest;
import ru.qa.api.client.enums.HttpMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	void postBodyAsPathTest() {
		DefaultRequest request = new DefaultRequest();

		request.setUri("https://api87.ilovepdf.com/v1/upload")
				.setBody(Paths.get("src/test/resources", "mem.jpg"))
				.addHeader("accept", "application/json")
				.addHeader("origin", "https://www.ilovepdf.com")
				.setMethod(HttpMethod.POST);

		//Достаточно проверять, что не вываливается IOException, сам запрос не тестируем.
		assertDoesNotThrow(() -> new DefaultClient().execute(request));
	}


	@Test
	void postBodyAsByteArrayTest() throws IOException {
		DefaultRequest request = new DefaultRequest();

		request.setUri("https://api87.ilovepdf.com/v1/upload")
				.setBody(Files.readAllBytes(Paths.get("src/test/resources", "mem.jpg")))
				.addHeader("accept", "application/json")
				.addHeader("origin", "https://www.ilovepdf.com")
				.setMethod(HttpMethod.POST);

		//Достаточно проверять, что не вываливается IOException, сам запрос не тестируем.
		assertDoesNotThrow(() -> new DefaultClient().execute(request));
	}


	record Pet(long id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
	}

	record Category(long id, String name) {
	}

	record Tag(long id, String name) {
	}
}
