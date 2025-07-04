package ru.qa.api.client;

import ru.qa.api.client.interfaces.Client;
import ru.qa.api.client.interfaces.Request;
import ru.qa.api.client.interfaces.ResponseActions;

import java.io.IOException;
import java.net.http.HttpClient;

import static java.net.http.HttpClient.newHttpClient;

public class DefaultClient implements Client {
    @Override
    public ResponseActions execute(Request request) {
        HttpClient client = newHttpClient();
        try {
            return new DefaultResponse(client.send(null, null));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
