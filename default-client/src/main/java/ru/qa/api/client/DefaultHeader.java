package ru.qa.api.client;

import ru.qa.api.client.interfaces.Header;

public class DefaultHeader implements Header {
    private final String key;
    private final String value;

    public DefaultHeader(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}
