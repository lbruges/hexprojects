package galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.generics;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper=true)
public abstract class GenericStatusEntity extends GenericEntity {

    @Column
    private String status;

}
