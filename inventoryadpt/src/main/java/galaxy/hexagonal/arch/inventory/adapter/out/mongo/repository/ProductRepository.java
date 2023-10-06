package galaxy.hexagonal.arch.inventory.adapter.out.mongo.repository;

import galaxy.hexagonal.arch.inventory.adapter.out.mongo.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query(value = "{sku:?'0'}", fields = "{id:1}")
    String findIdBySku(String sku);

}
