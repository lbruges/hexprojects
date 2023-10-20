package galaxy.hexagonal.arch.billing.application.config;

import galaxy.hexagonal.arch.billing.adapter.out.mongo.MongoBillAdapter;
import galaxy.hexagonal.arch.billing.adapter.out.mongo.mapper.BillMapper;
import galaxy.hexagonal.arch.billing.adapter.out.mongo.repository.BillRepository;
import galaxy.hexagonal.arch.billing.application.port.out.GenericBillPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Configuration
public class MongoConfig {

    @Bean
    public BillMapper billMapper() {
        return new BillMapper();
    }

    @Bean
    public GenericBillPort genericBillPort(BillRepository billRepository) {
        return new MongoBillAdapter(billRepository, billMapper());
    }

}
