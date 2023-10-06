package galaxy.hexagonal.arch.inventory.adapter.out.mongo.repository;

import galaxy.hexagonal.arch.inventory.adapter.out.mongo.document.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
