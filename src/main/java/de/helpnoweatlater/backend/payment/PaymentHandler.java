package de.helpnoweatlater.backend.payment;

import de.helpnoweatlater.backend.store.Store;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PaymentHandler {

    public static String PAYMENT_PATH_PREFIX = "/stores";
    public static String PAYMENT_ID_PATH = PAYMENT_PATH_PREFIX + "/{id}";

    Mono<ServerResponse> retrieveAll(ServerRequest request) {
        return Mono.empty();
    }

    Mono<ServerResponse> retrieve(ServerRequest request) {
        return Mono.empty();
    }

    Mono<ServerResponse> create(ServerRequest request) {
        return Mono.empty();
    }

    Mono<ServerResponse> update(ServerRequest request) {
        return Mono.empty();
    }

    Mono<ServerResponse> delete(ServerRequest request) {
        return Mono.empty();
    }

}
