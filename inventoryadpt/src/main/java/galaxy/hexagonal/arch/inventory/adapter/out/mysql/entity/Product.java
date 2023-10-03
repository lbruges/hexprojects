package galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.generics.GenericStatusEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicleproduct")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Product extends GenericStatusEntity {

    @Column
    private String sku;

    @Column
    private float price;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
