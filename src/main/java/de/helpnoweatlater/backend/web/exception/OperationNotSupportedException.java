package de.helpnoweatlater.backend.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OperationNotSupportedException extends ResponseStatusException {

    public static final String DEFAULT_EXCEPTION_MESSAGE = "Operation is currently not supported";

    public OperationNotSupportedException(HttpStatus status) {
        super(status);
    }

    public OperationNotSupportedException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public OperationNotSupportedException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
}
