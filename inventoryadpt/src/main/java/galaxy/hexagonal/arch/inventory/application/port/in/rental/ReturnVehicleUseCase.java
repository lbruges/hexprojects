package galaxy.hexagonal.arch.inventory.application.port.in.rental;

import galaxy.hexagonal.arch.domain.rental.Renter;
import galaxy.hexagonal.arch.domain.rental.ReturnedVehicle;

public interface ReturnVehicleUseCase {
    ReturnedVehicle returnVehicle(String vehiclePlate, Renter renter);

}
