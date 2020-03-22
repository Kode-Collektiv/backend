package de.helpnoweatlater.backend.paypal;

import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;
import com.paypal.orders.OrdersGetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class PayPalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayPalService.class);

    private final PayPalHttpClient payPalHttpClient;


    public PayPalService(PayPalHttpClient payPalHttpClient) {
        this.payPalHttpClient = payPalHttpClient;
    }

    public Mono<Void> verifyPayment(final String orderId) {
        OrdersGetRequest request = new OrdersGetRequest(orderId);

        HttpResponse<Order> response = null;
        try {
            response = payPalHttpClient.execute(request);

            Order order = response.result();

            LOGGER.info(response.result().toString());

            return Mono.empty();
        } catch (IOException e) {
            LOGGER.error("Failed to verify payment with orderId {}", orderId);
        }

        return Mono.empty();

    }



    /*public HttpResponse<Order> requestOrder(OrderRequest orderRequest) throws IOException, JSONException {

        OrdersCreateRequest ordersCreateRequest = new OrdersCreateRequest();
        ordersCreateRequest.requestBody(orderRequest);
        ordersCreateRequest.prefer("return=representation");

        HttpResponse<Order> response = payPalHttpClient.execute(ordersCreateRequest);
        if (response.statusCode() == 201) {
            System.out.println("Order with Complete Payload: ");
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Status: " + response.result().status());
            System.out.println("Order ID: " + response.result().id());
            System.out.println("Intent: " + response.result().checkoutPaymentIntent());
            System.out.println("Links: ");
            for (LinkDescription link : response.result().links()) {
                System.out.println("\t" + link.rel() + ": " + link.href() + "\tCall Type: " + link.method());
            }
            System.out.println("Total Amount: " + response.result().purchaseUnits().get(0).amountWithBreakdown().currencyCode()
                    + " " + response.result().purchaseUnits().get(0).amountWithBreakdown().value());
            System.out.println("Full response body:");
            System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));
        }
        return response;

    }

    public OrderRequest buildOrderRequest(final String email,
                                          final String firstName,
                                          final String lastName,
                                          final String brandName,
                                          final String failureUrl,
                                          final String successUrl) {

        // Payer Information
        Payer payer = new Payer();
        payer.email(email);
        payer.name();
        payer.name(new Name().surname(firstName).givenName(lastName));

        Payee payee = new Payee();
        payee.email("mail@gutburgerlich.de");


        ApplicationContext applicationContext = new ApplicationContext()
                .brandName(brandName)
                .landingPage("BILLING")
                .locale("DE")
                .returnUrl(successUrl)
                .cancelUrl(failureUrl)
                .userAction("PAY_NOW");

        List<PurchaseUnitRequest> purchaseUnitRequests = new ArrayList<>();

        PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest()
                .referenceId("REFERENCE_ID")
                .payee(payee)
                .description("HelpNowEatLater")
                .amountWithBreakdown(new AmountWithBreakdown()
                        .currencyCode("EUR")
                        .value("10.20"));

        purchaseUnitRequests.add(purchaseUnitRequest);

        // Order Request Information
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.payer(payer);
        orderRequest.checkoutPaymentIntent("CAPTURE");
        orderRequest.purchaseUnits(purchaseUnitRequests);
        return orderRequest;
    }*/


}
