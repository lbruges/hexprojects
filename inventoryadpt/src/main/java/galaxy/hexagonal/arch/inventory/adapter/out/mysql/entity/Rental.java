package galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.generics.GenericStatusEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "rental")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Rental extends GenericStatusEntity {

    @Column(name="rental_start_date")
    private LocalDateTime rentalStartDate;

    @Column(name="rental_end_date")
    private LocalDateTime rentalEndDate;

    @OneToOne
    @JoinColumn(name = "renter_id")
    private Renter renter;
}
