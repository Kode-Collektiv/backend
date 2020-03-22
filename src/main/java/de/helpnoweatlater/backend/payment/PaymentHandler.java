package de.helpnoweatlater.backend.payment;

import de.helpnoweatlater.backend.paypal.PayPalService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PaymentHandler {

    public static String PAYMENT_PATH_PREFIX = "/stores";
    public static String PAYMENT_ID_PATH = PAYMENT_PATH_PREFIX + "/{id}";

    private final PayPalService payPalService;

    public PaymentHandler(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    public Mono<ServerResponse> verifyPayment(ServerRequest request) {
        return Mono
                .from(payPalService.verifyPayment(request.pathVariable("id")))
                .flatMap(p -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .build());
    }


}
