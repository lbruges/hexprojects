package galaxy.hexagonal.arch.inventory.service;

import galaxy.hexagonal.arch.domain.inventory.FrozenInventory;
import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.inventory.exception.InventoryException;
import galaxy.hexagonal.arch.port.in.rental.FinalizeRentalUseCase;
import galaxy.hexagonal.arch.port.in.rental.ReturnVehicleUseCase;
import galaxy.hexagonal.arch.port.in.rental.RollbackRentalUseCase;

public class RentalService implements FinalizeRentalUseCase, RollbackRentalUseCase, ReturnVehicleUseCase {

    @Override
    public RentedVehicle finalizeRental(FrozenInventory frozenInventory) {
        return null;
    }

    @Override
    public void rollbackRental(String freezeCode) throws InventoryException {

    }

    @Override
    public void returnVehicle(String vehiclePlate, String renterIdDocument) {

    }
}
