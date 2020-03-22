package de.helpnoweatlater.backend.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PayPalConfiguration {


    @Bean
    @Profile("sandbox")
    public PayPalEnvironment payPalEnvironmentSandbox(PayPalProperties payPalProperties){

        return new PayPalEnvironment.Sandbox(payPalProperties.getClientId(), payPalProperties.getSecret());
    }

    @Bean
    @Profile("prod")
    public PayPalEnvironment payPalEnvironmentLive(PayPalProperties payPalProperties){
        return new PayPalEnvironment.Live(payPalProperties.getClientId(), payPalProperties.getSecret());
    }


    @Bean
    public PayPalHttpClient payPalHttpClient(PayPalEnvironment payPalEnvironment){
        return new PayPalHttpClient(payPalEnvironment);
    }


}
