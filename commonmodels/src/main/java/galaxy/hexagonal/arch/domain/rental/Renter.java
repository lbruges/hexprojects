package galaxy.hexagonal.arch.domain.rental;

import galaxy.hexagonal.arch.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Renter extends Person {
    private String origin; //city + country
    private String licenceNumber;

}
