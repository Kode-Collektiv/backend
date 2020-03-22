package de.helpnoweatlater.backend.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntityNotFoundException extends ResponseStatusException {

    public static final String DEFAULT_EXCEPTION_MESSAGE = "Entity could not be found";

    public EntityNotFoundException(HttpStatus status) {
        super(status);
    }

    public EntityNotFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public EntityNotFoundException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
}
