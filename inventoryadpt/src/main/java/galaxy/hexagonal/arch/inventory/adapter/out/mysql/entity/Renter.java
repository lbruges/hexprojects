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
@Table(name = "renter")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Renter extends GenericEntity {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "id_document")
    private String idDocument;

    @Column
    private String origin;

    @Column(name = "licence_id")
    private String licence;
}
