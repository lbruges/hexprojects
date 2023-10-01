package galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.generics.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "renter")
public class Renter extends GenericEntity {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "id_document")
    private String idDocument;

    private String origin;

    @Column(name = "licence_id")
    private String licence;
}
