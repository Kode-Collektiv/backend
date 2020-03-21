package de.helpnoweatlater.backend.config;

import com.paypal.base.rest.APIContext;
import de.helpnoweatlater.backend.properties.PayPalProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayPalConfiguration {


    @Bean
    public APIContext apiContext(PayPalProperties payPalProperties) {
        return new APIContext(payPalProperties.getClientId(), payPalProperties.getSecret(), payPalProperties.getMode());
    }

}
