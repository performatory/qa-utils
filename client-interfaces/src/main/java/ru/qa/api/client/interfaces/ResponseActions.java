package ru.qa.api.client.interfaces;

public interface ResponseActions {
    <T> T parseBodyAs(Class<T> entity);
    <T> T getValueFromBodyByPath(String filter);
    ResponseActions shouldBeStatusCode(int expectedStatusCode);
    int getStatusCode();
    String getBody();
}
