package de.helpnoweatlater.backend.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import de.helpnoweatlater.backend.properties.PayPalProperties;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class PayPalService {

    private final PayPalProperties payPalProperties;
    private final APIContext apiContext;

    public PayPalService(PayPalProperties payPalProperties, APIContext apiContext) {
        this.payPalProperties = payPalProperties;
        this.apiContext = apiContext;
    }


    public Payment createPayment(Double total,
                                 String currency,
                                 String method,
                                 String intent,
                                 String description
    ) throws PayPalRESTException {
        total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
        Amount amount = new Amount(currency, String.format("%.2f", total));

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method);

        Payment payment = new Payment();
        payment.setIntent(intent);
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(payPalProperties.getFailureUrl());
        redirectUrls.setReturnUrl(payPalProperties.getSuccessUrl());

        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }


    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecution);
    }


}
