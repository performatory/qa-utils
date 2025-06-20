package ru.qa.api.client.interfaces;

public interface ClientBuilder {
    Client getDefaultClient();
    ClientBuilder custom();
    ClientBuilder passwordAuthentication(String userName, String password);
    Client build();
    RequestBuilder getRequestBuilder();
}
