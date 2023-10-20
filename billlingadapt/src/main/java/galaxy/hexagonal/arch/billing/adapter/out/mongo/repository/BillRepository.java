package galaxy.hexagonal.arch.billing.adapter.out.mongo.repository;

import galaxy.hexagonal.arch.billing.adapter.out.mongo.document.BillDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends MongoRepository<BillDocument, String> {
}
