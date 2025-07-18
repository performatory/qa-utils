package ru.qa.api.client.exceptions;

import org.opentest4j.AssertionFailedError;

public class APIAssertionError extends AssertionFailedError {
    public APIAssertionError(String message) {
        super(message);
    }
}
