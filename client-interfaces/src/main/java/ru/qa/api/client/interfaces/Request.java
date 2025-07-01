package ru.qa.api.client.interfaces;

import ru.qa.api.client.enums.HttpMethod;
import ru.qa.api.client.enums.Method;

import java.util.List;
import java.util.Map;

public interface Request {
    Request setUrl(String url);
    Request setQueries(Map<String, String> queries);
    Request setStringBody(String body);
    Request setBody(Object body);
    Request setMethod(Method method);
    Request addHeaders(List<Header> headers);
    Request addHeader(String key, String value);
    String getUrl();
    Map<String, String> getQueries();
}
