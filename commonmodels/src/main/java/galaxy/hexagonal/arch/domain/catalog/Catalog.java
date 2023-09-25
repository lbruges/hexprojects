package galaxy.hexagonal.arch.domain.catalog;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Catalog {
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private List<VehicleItem> availableVehicles;
}
