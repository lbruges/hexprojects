package galaxy.hexagonal.arch.inventory.application.config;

import galaxy.hexagonal.arch.inventory.adapter.out.rest.BillingClientAdapter;
import galaxy.hexagonal.arch.inventory.adapter.out.rest.client.BillingClient;
import galaxy.hexagonal.arch.inventory.application.port.out.billing.GenericBillingPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GenericBillingPort genericBillingPort(BillingClient client) {
        return new BillingClientAdapter(client);
    }

}
