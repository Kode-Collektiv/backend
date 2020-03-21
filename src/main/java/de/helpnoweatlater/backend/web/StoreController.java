package de.helpnoweatlater.backend.web;

import de.helpnoweatlater.backend.domain.Store;
import de.helpnoweatlater.backend.service.StoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class StoreController {

    private static String STORE_PATH_PREFIX = "/stores";

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Bean
    RouterFunction<ServerResponse> retrieveAllStores() {
        return route(GET(STORE_PATH_PREFIX),
                request -> ok().body(storeService.retrieveAll(), Store.class));
    }

    @Bean
    RouterFunction<ServerResponse> retrieveStoreById(){
        return route(GET(STORE_PATH_PREFIX + "/{id}"),
                request -> ok().body(storeService.retrieveById(request.pathVariable("id")), Store.class));
    }

    @Bean
    RouterFunction<ServerResponse> createStore() {
        return route(POST(STORE_PATH_PREFIX),
                request -> ok().body(request.bodyToMono(Store.class)
                        .flatMap(store -> storeService.create(store)), Store.class));
    }

    @Bean
    RouterFunction<ServerResponse> updateStore() {
        return route(GET(STORE_PATH_PREFIX + "/{id}"),
                request -> ok().body(request.bodyToMono(Store.class)
                        .flatMap(store -> storeService.update(store, request.pathVariable("id"))), Store.class));
    }

}
