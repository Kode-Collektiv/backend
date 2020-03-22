package de.helpnoweatlater.backend;

import com.paypal.orders.OrderRequest;
import de.helpnoweatlater.backend.paypal.PayPalProperties;
import de.helpnoweatlater.backend.paypal.PayPalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

@SpringBootTest
@ActiveProfiles(profiles = {"private", "sandbox"})
public class PayPalServiceTests {

    @Autowired
    private PayPalService payPalService;

    @Autowired
    private PayPalProperties payPalProperties;

    @Test
    public void shouldVerifyPayment() throws IOException, JSONException {
        payPalService.verifyPayment("9609673421976173D");
    }

}
