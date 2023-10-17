package galaxy.hexagonal.arch.inventory.application.port.in.rental;

import galaxy.hexagonal.arch.domain.rental.Renter;

public interface ReturnVehicleUseCase {

    // TODO: add constraint to renter id + licence id
    void returnVehicle(String vehiclePlate, Renter renter);

}
