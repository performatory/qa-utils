package ru.qa.api.client.interfaces;

import ru.qa.api.client.enums.HttpMethod;

import java.util.Map;

public interface Request {
    Request setUrl(String url);
    Request setQueries(Map<String, String> queries);
    Request setStringBody(String body);
    Request setBody(Object body);
    Request setMethod(HttpMethod method);
    Request addHeaders(Map<String, String> headers);
    Request addHeader(String key, String value);
    String getUrl();
    Map<String, String> getQueries();
}
