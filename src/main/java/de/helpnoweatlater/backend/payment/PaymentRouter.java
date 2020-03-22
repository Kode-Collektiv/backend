package de.helpnoweatlater.backend.payment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PaymentRouter {

    public static String PAYMENT_PATH_PREFIX = "/stores";
    public static String PAYMENT_ID_PATH = PAYMENT_PATH_PREFIX + "/{id}";


    private final PaymentHandler paymentHandler;

    public PaymentRouter(PaymentHandler paymentHandler) {
        this.paymentHandler = paymentHandler;
    }

    @Bean
    RouterFunction<ServerResponse> paymentRoutes(){
        return route(GET(PAYMENT_PATH_PREFIX), paymentHandler::retrieveAll)
                .andRoute(GET(PAYMENT_ID_PATH), paymentHandler::retrieve)
                .andRoute(POST(PAYMENT_PATH_PREFIX), paymentHandler::create)
                .andRoute(PUT(PAYMENT_ID_PATH), paymentHandler::update)
                .andRoute(DELETE(PAYMENT_ID_PATH), paymentHandler::delete);
    }


}
