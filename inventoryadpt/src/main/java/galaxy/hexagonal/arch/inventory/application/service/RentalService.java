package galaxy.hexagonal.arch.inventory.application.service;

import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;
import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.port.in.rental.FinalizeRentalUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.rental.ReturnVehicleUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.rental.RollbackRentalUseCase;

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
