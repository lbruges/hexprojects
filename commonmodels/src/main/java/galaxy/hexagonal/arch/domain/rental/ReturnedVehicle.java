package galaxy.hexagonal.arch.domain.rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ReturnedVehicle {
    private RentableVehicle item;
    private Renter renter;
    private LocalDateTime originalReturnDate;
    private LocalDateTime actualReturnDate;
}
