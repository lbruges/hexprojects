package galaxy.hexagonal.arch.inventory.application.service;

import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;
import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.inventory.application.port.in.rental.FinalizeRentalUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.rental.ReturnVehicleUseCase;

public class RentalService implements FinalizeRentalUseCase, ReturnVehicleUseCase {

    @Override
    public RentedVehicle finalizeRental(FrozenInventory frozenInventory) {
        return null;
    }

    @Override
    public void returnVehicle(String vehiclePlate, String renterIdDocument) {

    }
}
