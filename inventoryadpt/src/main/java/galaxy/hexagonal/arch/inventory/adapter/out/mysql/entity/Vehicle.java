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

@Entity
@Table(name = "vehicleitem")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Vehicle extends GenericStatusEntity {

    @Column
    private String plate;

    @Column
    private String origin;

    @OneToOne
    @JoinColumn(name = "vehicleproduct_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "freeze_id")
    private Freeze freeze;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

}
