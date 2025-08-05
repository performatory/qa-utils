package ru.qa.api.client;

import com.google.gson.Gson;
import ru.qa.api.client.exceptions.APIAssertionError;
import ru.qa.api.client.interfaces.ResponseActions;

import java.net.http.HttpResponse;

public class DefaultResponse implements ResponseActions {

    HttpResponse<String> response;

    public DefaultResponse(HttpResponse response) {
        this.response = response;
    }

    @Override
    public <T> T parseBodyAs(Class<T> entity) {
        return new Gson().fromJson(response.body(), entity);
    }

    @Override
    public <T> T getValueFromBodyByPath(String filter) {
        throw new UnsupportedOperationException("На данный момент не реализовано");
    }

    @Override
    public ResponseActions shouldBeStatusCode(int expectedStatusCode) {
        if (response.statusCode() != expectedStatusCode)
            throw new APIAssertionError("Не совпадает код ответа");
        return this;
    }

    @Override
    public int getStatusCode() {
        return response.statusCode();
    }

    @Override
    public String getBody() {
        return response.body();
    }
}
