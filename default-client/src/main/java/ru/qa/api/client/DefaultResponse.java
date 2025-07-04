package ru.qa.api.client;

import ru.qa.api.client.interfaces.ResponseActions;

import java.net.http.HttpResponse;

public class DefaultResponse implements ResponseActions {

    public DefaultResponse(HttpResponse response) {
    }

    @Override
    public <T> T parseBodyAs(Class<T> entity) {
        return null;
    }

    @Override
    public <T> T getValueFromBodyByPath(String filter) {
        return null;
    }

    @Override
    public ResponseActions shouldBeStatusCode(int expectedStatusCode) {
        return null;
    }

    @Override
    public int getStatusCode() {
        return 0;
    }

    @Override
    public String getBody() {
        return "";
    }
}
