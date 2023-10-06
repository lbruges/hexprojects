package galaxy.hexagonal.arch.inventory.application.config;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Profile("mongo")
@EnableMongoRepositories
public class MongoReactiveApplication {

}
