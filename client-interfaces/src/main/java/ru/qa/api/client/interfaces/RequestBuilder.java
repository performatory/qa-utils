package ru.qa.api.client.interfaces;

import ru.qa.api.client.enums.HttpMethod;

import java.util.Map;

public interface RequestBuilder {
    RequestBuilder setMethod(HttpMethod method);
    RequestBuilder addHeader(String key, String value);
    RequestBuilder setUrl(String url);
    RequestBuilder setQueries(Map<String, String> queries);
    RequestBuilder setBody(Object body);
    RequestBuilder setStringBody(String body);
    RequestBuilder setContentType(String contentType);
    Request build();
}
