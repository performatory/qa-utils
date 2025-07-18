package ru.qa.api.client;

import ru.qa.api.client.interfaces.Client;
import ru.qa.api.client.interfaces.RequestAdapter;
import ru.qa.api.client.interfaces.ResponseActions;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

public class DefaultClient implements Client {
    @Override
    public ResponseActions execute(RequestAdapter request) {
        try (HttpClient client = newHttpClient()){
            return new DefaultResponse(client.send(request.performRequest(),  HttpResponse.BodyHandlers.ofString()));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
