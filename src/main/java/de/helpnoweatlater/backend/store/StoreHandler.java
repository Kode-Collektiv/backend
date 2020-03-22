package de.helpnoweatlater.backend.store;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class StoreHandler {

    private final StoreService storeService;

    public StoreHandler(StoreService storeService) {
        this.storeService = storeService;
    }

    Mono<ServerResponse> retrieveAll(ServerRequest request) {
        return defaultReadResponse(storeService.retrieveAll());
    }

    Mono<ServerResponse> retrieve(ServerRequest request) {
        return defaultReadResponse(storeService.retrieve(request.pathVariable("id")));
    }

    Mono<ServerResponse> create(ServerRequest request) {
        return null;
    }

    Mono<ServerResponse> update(ServerRequest request) {
        Mono<Store> id = request.bodyToMono(Store.class)
                .flatMap(p -> this.storeService.update(p, request.pathVariable("id")));
        return defaultReadResponse(id);
    }

    Mono<ServerResponse> delete(ServerRequest request) {
        return defaultWriteVoidResponse(this.storeService.deleteById(request.pathVariable("id")));
    }

    private static Mono<ServerResponse> defaultWriteVoidResponse(Publisher<Void> voidPublisher) {
        return Mono.
                from(voidPublisher)
                .flatMap(p -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .build()
                );
    }

    private static Mono<ServerResponse> defaultWriteResponse(Publisher<Store> store) {
        return Mono
                .from(store)
                .flatMap(p -> ServerResponse
                        .created(URI.create("/profiles/" + p.getId()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .build());
    }

    private static Mono<ServerResponse> defaultReadResponse(Publisher<Store> store) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(store, Store.class);
    }
}
