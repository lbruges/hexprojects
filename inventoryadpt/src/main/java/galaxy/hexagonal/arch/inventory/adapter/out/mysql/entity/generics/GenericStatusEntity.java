package galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.generics;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class GenericStatusEntity extends GenericEntity {

    private String status;

}
