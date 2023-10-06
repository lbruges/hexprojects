package galaxy.hexagonal.arch.inventory.adapter.out.mongo.repository;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.document.Model;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModelRepository extends MongoRepository<Model, String> {

    String FIND_MODEL_QUERY = "{type:#{#model.type().name()},brand:#{#model.brand()},year:#{#model.year()},model:#{#model.model()}}";

    @Query(FIND_MODEL_QUERY)
    Model findModel(@Param("model") VehicleModel domainModel);
    @Query(value=FIND_MODEL_QUERY, fields = "{id:1}")
    String findModelId(@Param("model") VehicleModel domainModel);

}
