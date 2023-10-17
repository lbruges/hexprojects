package galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenterRepository extends JpaRepository<Renter, Integer> {

    Renter findByIdDocumentAndOriginAndLicence(String idDocument, String origin, String licence);

}
