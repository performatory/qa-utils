package ru.qa.api.client;

import com.google.gson.Gson;
import ru.qa.api.client.enums.Method;
import ru.qa.api.client.exceptions.APIAssertionError;
import ru.qa.api.client.interfaces.Header;
import ru.qa.api.client.interfaces.Request;
import ru.qa.api.client.interfaces.RequestAdapter;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class DefaultRequest implements Request, RequestAdapter{

    private HttpRequest.Builder builder;
    private URI uri;
    private Map<String, String> queries;
    private Method method;
    HttpRequest.BodyPublisher bodyPublisher = BodyPublishers.noBody();
    private List<Header> headers = new ArrayList<>();


    public DefaultRequest() {
            builder = HttpRequest.newBuilder();
    }

    @Override
    public Request setUri(String uri) {
        try {
            this.uri = new URI(uri);
        } catch (URISyntaxException e) {
            throw new APIAssertionError("Не удалось преобразовать "
                    .concat(uri)
                    .concat(" в URI"));
        }
        return this;
    }

    @Override
    public Request setQueries(Map<String, String> queries) {
        this.queries = queries;
        return this;
    }

    @Override
    public Request setBody(Path path) {
        try {
            bodyPublisher = BodyPublishers.ofFile(path);
        } catch (FileNotFoundException e) {
            throw new APIAssertionError("Файл для выполнения запроса не найден по пути ".concat(path.toString()));
        }
        return this;
    }

    @Override
    public Request setBody(byte[] body) {
        bodyPublisher = BodyPublishers.ofByteArray(body);
        return this;
    }

    @Override
    public Request setBody(String body) {
        bodyPublisher = BodyPublishers.ofString(body);
        return this;
    }

    @Override
    public Request setBodyAsJSON(Object objectBody) {
        bodyPublisher = BodyPublishers.ofString(new Gson().toJson(objectBody));
        return this;
    }

    @Override
    public Request setBodyAsStream(Supplier<? extends InputStream> streamSupplier) {
        bodyPublisher = BodyPublishers.ofInputStream(streamSupplier);
        return this;
    }


    @Override
    public Request setMethod(Method method) {
        this.method = method;
        return this;
    }

    @Override
    public Request addHeaders(List<Header> headers) {
        this.headers.addAll(headers);
        return this;
    }

    @Override
    public Request addHeader(String key, String value) {
        headers.add(new DefaultHeader(key, value));
        return this;
    }

    @Override
    public String getUri() {
        return uri.toString();
    }

    @Override
    public Map<String, String> getQueries() {
        return queries;
    }

    @Override
    @SuppressWarnings("unchecked")
    public HttpRequest performRequest() {
        builder.method(method.toString(), bodyPublisher);

        headers.forEach(header -> builder.setHeader(header.getKey(), header.getValue()));

        return builder.uri(uri).build();
    }
}
