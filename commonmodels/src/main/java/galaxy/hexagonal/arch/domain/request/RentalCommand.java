package galaxy.hexagonal.arch.domain.request;

import galaxy.hexagonal.arch.domain.Person;
import lombok.Data;

@Data
public class RentalCommand {
    private Person renter;
    private String freezeCode;
}
