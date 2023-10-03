package galaxy.hexagonal.arch.domain.inventory.resp;

import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Catalog {
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private List<VehicleItem> availableVehicles;
}
