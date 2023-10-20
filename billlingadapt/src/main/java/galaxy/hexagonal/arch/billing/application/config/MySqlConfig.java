package galaxy.hexagonal.arch.billing.application.config;

import galaxy.hexagonal.arch.billing.adapter.out.mysql.MySqlBillAdapter;
import galaxy.hexagonal.arch.billing.adapter.out.mysql.mapper.BillMapper;
import galaxy.hexagonal.arch.billing.adapter.out.mysql.repository.MySqlBillRepository;
import galaxy.hexagonal.arch.billing.application.port.out.GenericBillPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("mysql")
@Configuration
public class MySqlConfig {

    @Bean
    public BillMapper billMapper() {
        return new BillMapper();
    }

    @Bean
    public GenericBillPort genericBillPort(MySqlBillRepository mySqlBillRepository) {
        return new MySqlBillAdapter(mySqlBillRepository, billMapper());
    }

}
