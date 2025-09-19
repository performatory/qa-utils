package ru.qa.api.client.exceptions;

import org.opentest4j.AssertionFailedError;

public class APIAssertionError extends AssertionFailedError {
    public APIAssertionError(String message) {
        super(message);
    }

    public APIAssertionError(String message, Object expected, Object actual) {
        super(message, expected, actual);
    }

    public APIAssertionError(String message, Object expected, Object actual,  Throwable cause) {
        super(message, expected, actual, cause);
    }
}
