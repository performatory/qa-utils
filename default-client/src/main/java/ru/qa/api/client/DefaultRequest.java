package ru.qa.api.client;

import ru.qa.api.client.enums.Method;
import ru.qa.api.client.interfaces.Header;
import ru.qa.api.client.interfaces.Request;
import ru.qa.api.client.interfaces.RequestAdapter;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultRequest implements Request, RequestAdapter{

    private HttpRequest request;
    private HttpRequest.Builder builder;
    private URI uri;
    private Map<String, String> queries;
    private String stringBody;
    private Object body;
    private Method method;
    private List<Header> headers = new ArrayList<>();


    public DefaultRequest() {
            builder = HttpRequest.newBuilder();
    }

    @Override
    public Request setUri(String uri) {
        try {
            this.uri = new URI(uri);
        } catch (URISyntaxException e) {
            //TODO выбросить обычное исключение с осмысленным сообщением об ошибке
            throw new RuntimeException(e);
        }
        return this;
    }

    @Override
    public Request setQueries(Map<String, String> queries) {
        this.queries = queries;
        return this;
    }

    @Override
    public Request setStringBody(String stringBody) {
        this.stringBody = stringBody;
        return this;
    }

    @Override
    public Request setBody(Object body) {
        this.body = body;
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
    public HttpRequest performRequest() {
        if (method.isGet()) builder.GET();

        if (headers != null && !headers.isEmpty())
            headers.forEach(header -> builder.setHeader(header.getKey(), header.getValue()));

        return builder.uri(uri).build();
    }
}
