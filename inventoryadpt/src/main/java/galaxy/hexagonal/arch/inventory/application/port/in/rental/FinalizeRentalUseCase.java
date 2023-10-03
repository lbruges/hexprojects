package galaxy.hexagonal.arch.inventory.application.port.in.rental;

import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;
import galaxy.hexagonal.arch.domain.rental.RentedVehicle;

public interface FinalizeRentalUseCase {
    RentedVehicle finalizeRental(FrozenInventory frozenInventory);
}
