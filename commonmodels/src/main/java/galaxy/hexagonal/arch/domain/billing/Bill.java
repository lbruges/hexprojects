package galaxy.hexagonal.arch.domain.billing;

import galaxy.hexagonal.arch.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Bill {
    private LocalDateTime rentalStartDate;
    private LocalDateTime rentalEndDate;
    private LocalDateTime returnDate;
    private String concept;
    @Singular
    private List<Item> items;
    private Person purchaser;
}
