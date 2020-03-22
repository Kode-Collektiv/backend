package de.helpnoweatlater.backend.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class StoreRouter {

    private static String STORE_PATH_PREFIX = "/stores";
    private static String STORE_ID_PATH = STORE_PATH_PREFIX + "/{id}";

    @Bean
    RouterFunction<ServerResponse> routes(StoreHandler storeHandler){
        return route(GET(STORE_PATH_PREFIX), storeHandler::retrieveAll)
                .andRoute(GET(STORE_ID_PATH), storeHandler::retrieve)
                .andRoute(POST(STORE_PATH_PREFIX), storeHandler::create)
                .andRoute(PUT(STORE_ID_PATH), storeHandler::update)
                .andRoute(DELETE(STORE_ID_PATH), storeHandler::delete);

    }

}
