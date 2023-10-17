package galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository;

import galaxy.hexagonal.arch.domain.rental.Renter;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Vehicle;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    String FREEZABLE_CRITERIA = "(v.rental IS NULL AND v.freeze IS NULL)";

    @Query("SELECT v FROM Vehicle v WHERE " + FREEZABLE_CRITERIA + " OR (v.rental.status <> 'OVERDUE' AND " +
            "v.rental.rentalEndDate < :targetStartDate)")
    List<Vehicle> findAvailableVehicles(@Param("targetStartDate") LocalDateTime targetStartDate);

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("SELECT v FROM Vehicle v WHERE v.product.sku = :sku AND " + FREEZABLE_CRITERIA + " LIMIT 1")
    Vehicle getVehicleToFreeze(@Param("sku") String sku);

    @Query("SELECT v FROM Vehicle v WHERE v.rental IS NULL AND v.freeze IS NOT NULL AND " +
            "v.freeze.freezeCode = :freezeCode")
    Vehicle findByFreezeCode(@Param("freezeCode") String freezeCode);

    Vehicle findByPlate(String plate);

    @Query("SELECT CASE WHEN (COUNT(v) > 0)  THEN TRUE ELSE FALSE END FROM Vehicle v WHERE v.plate = :plate AND " +
            "(v.rental IS NOT NULL AND v.rental.renter.idDocument = :#{#renter.getDni()} AND " +
            "v.rental.renter.origin = :#{#renter.getOrigin()} AND v.rental.renter.licence = :#{#renter.getLicence()})")
    boolean vehicleAndRenterMatch(@Param("plate") String plate, @Param("renter") Renter renter);

}
