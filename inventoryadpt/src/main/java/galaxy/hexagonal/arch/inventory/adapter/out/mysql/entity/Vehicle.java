package galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.generics.GenericStatusEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicleitem")
public class Vehicle extends GenericStatusEntity {

    private String plate;
    private String origin;
    private Product product;
    private Freeze freeze;
    private Rental rental;

}
