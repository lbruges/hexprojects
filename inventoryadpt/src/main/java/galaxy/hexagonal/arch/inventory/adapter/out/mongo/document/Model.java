package galaxy.hexagonal.arch.inventory.adapter.out.mongo.document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    @Id
    private String id;
    private String type;
    private String brand;
    private int year;
    private String model;

}
