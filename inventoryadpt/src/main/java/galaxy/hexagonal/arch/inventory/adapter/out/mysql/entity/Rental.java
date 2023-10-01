package galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.generics.GenericStatusEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "rental")
public class Rental extends GenericStatusEntity {

    @Column(name="rental_time")
    private LocalDateTime rentalTime;

    @Column(name = "rental_period_days")
    private int rentalPeriodInDays;

    //TODO: review foreign keys
    private Renter renter;
}
