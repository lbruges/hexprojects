package galaxy.hexagonal.arch.inventory.application.configuration;

import galaxy.hexagonal.arch.inventory.adapter.out.InventoryAdapter;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.MySqlInventoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mysql")
public class MySqlConfig {

    @Autowired
    private MySqlInventoryAdapter mySqlInventoryAdapter;

    @Bean
    public InventoryAdapter inventoryAdapter() {
        return mySqlInventoryAdapter;
    }

}
