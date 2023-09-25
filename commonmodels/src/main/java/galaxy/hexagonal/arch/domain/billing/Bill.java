package galaxy.hexagonal.arch.domain.billing;

import galaxy.hexagonal.arch.domain.Person;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Bill {
    private LocalDate rentalDate;
    private String concept;
    private List<Item> items;
    private Person purchaser;
}
