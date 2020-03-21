package de.helpnoweatlater.backend.web;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import de.helpnoweatlater.backend.domain.Donation;
import de.helpnoweatlater.backend.service.PayPalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping(PaymentController.PAYMENT_API_ENDPOINT)
public class PaymentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);
    public static final String PAYMENT_API_ENDPOINT = "/payments";
    public static final String DEFAULT_CURRENCY = "EUR";
    public static final String DEFAULT_METHOD = "PAYPAL";

    private final PayPalService payPalService;


    public PaymentController(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @PostMapping("/donation")
    public Mono<Void> createDonation(@RequestBody Donation donation, ServerHttpResponse serverHttpResponse) {
        try {
            Payment payment = payPalService.createPayment(donation.getTotal(), DEFAULT_CURRENCY, DEFAULT_METHOD, "Intent", donation.getDescription());
            Links redirect = payment.getLinks()
                    .stream()
                    .filter(l -> l.getRel().equals("approval_url"))
                    .findFirst().get();
            serverHttpResponse.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
            serverHttpResponse.getHeaders().setLocation(URI.create(redirect.getHref()));
            return serverHttpResponse.setComplete();
        } catch (PayPalRESTException e) {
            LOGGER.error("Failed to find redirect for paypal", e);
        }
        serverHttpResponse.setStatusCode(HttpStatus.NOT_FOUND);
        serverHttpResponse.setComplete();
        return serverHttpResponse.setComplete();
    }


    @GetMapping("/success")
    public Mono<Void> paymentSuccessCallback(ServerHttpResponse serverHttpResponse) {
        serverHttpResponse.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        serverHttpResponse.getHeaders().setLocation(URI.create("http://www.google.de"));
        return serverHttpResponse.setComplete();
    }

    @GetMapping("/failure")
    public Mono<Void> paymentFailureCallback(ServerHttpResponse serverHttpResponse) {
        serverHttpResponse.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        serverHttpResponse.getHeaders().setLocation(URI.create("http://www.google.de"));
        return serverHttpResponse.setComplete();
    }


}
