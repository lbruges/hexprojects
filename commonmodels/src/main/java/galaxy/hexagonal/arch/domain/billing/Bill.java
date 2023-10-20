package galaxy.hexagonal.arch.domain.billing;

import galaxy.hexagonal.arch.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Bill {
    private LocalDate rentalDate;
    private String concept;
    @Singular
    private List<Item> items;
    private Person purchaser;
}
