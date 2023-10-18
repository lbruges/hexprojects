package galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.generics.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "model")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Model extends GenericEntity {

    @Column
    private String code;

    @Column
    private String type;

    @Column
    private String brand;

    @Column
    private int year;

    @Column
    private String model;

}
