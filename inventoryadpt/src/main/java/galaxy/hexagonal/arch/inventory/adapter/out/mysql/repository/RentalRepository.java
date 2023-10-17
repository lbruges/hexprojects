package galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
