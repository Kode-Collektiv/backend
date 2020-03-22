package de.helpnoweatlater.backend.paypal;

import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;
import com.paypal.orders.OrdersGetRequest;
import de.helpnoweatlater.backend.mail.MailService;
import de.helpnoweatlater.backend.payment.Payment;
import de.helpnoweatlater.backend.payment.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class PayPalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayPalService.class);
    private static final String STATUS_COMPLETED = "COMPLETED";
    private final PayPalHttpClient payPalHttpClient;
    private final PaymentRepository paymentRepository;
    private final MailService mailService;

    public PayPalService(PayPalHttpClient payPalHttpClient, PaymentRepository paymentRepository, MailService mailService) {
        this.payPalHttpClient = payPalHttpClient;
        this.paymentRepository = paymentRepository;
        this.mailService = mailService;
    }

    public Mono<Order> verifyPayment(final String orderId) {
        OrdersGetRequest request = new OrdersGetRequest(orderId);

        HttpResponse<Order> response = null;
        try {
            response = payPalHttpClient.execute(request);

            Order order = response.result();

            Payment payment = Payment.fromOrder(order);

            if (payment.getStatus().equals(STATUS_COMPLETED)){
                if(!paymentRepository.existsByOrderId(payment.getOrderId()).block()){
                    paymentRepository.save(payment);
                    mailService.sendVoucherConfirmation(payment);
                }
            }

            return Mono.just(order);
        } catch (IOException e) {
            LOGGER.error("Failed to verify payment with orderId {}", orderId);
        }

        return Mono.empty();

    }


}
