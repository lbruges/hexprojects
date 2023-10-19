package galaxy.hexagonal.arch.inventory.application.port.in.rental;

import galaxy.hexagonal.arch.domain.rental.Renter;

public interface ReturnVehicleUseCase {
    void returnVehicle(String vehiclePlate, Renter renter);

}
