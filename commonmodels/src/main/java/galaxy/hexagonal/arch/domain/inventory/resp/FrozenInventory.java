package galaxy.hexagonal.arch.domain.inventory.resp;

import galaxy.hexagonal.arch.domain.rental.RentableVehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FrozenInventory {
    private String freezeCode;
    private RentableVehicle vehicleItem;
}
