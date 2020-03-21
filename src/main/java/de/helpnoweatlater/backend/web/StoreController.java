package de.helpnoweatlater.backend.web;

import de.helpnoweatlater.backend.domain.Store;
import de.helpnoweatlater.backend.service.StoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.function.Function;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RequestPredicates.POST;
import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.ok;

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
                request -> ok().body(storeService.retrieveAll()));
    }

    @Bean
    RouterFunction<ServerResponse> retrieveStoreById(){
        return route(GET(STORE_PATH_PREFIX + "/{id}"),
                request -> ok().body(storeService.retrieveById(request.pathVariable("id"))));
    }

    @Bean
    RouterFunction<ServerResponse> createStore() {
        return route(POST(STORE_PATH_PREFIX),
                request -> ok().body(storeService.create(request.body(Store.class))));
    }

    @Bean
    RouterFunction<ServerResponse> updateStore() {
        return route(GET(STORE_PATH_PREFIX + "/{id}"),
                request -> ok().body(storeService.update(
                        request.body(Store.class),
                        request.pathVariable("id"))));
    }

}
