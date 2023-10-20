package galaxy.hexagonal.arch.inventory.application.port.out.rental.ops;
import galaxy.hexagonal.arch.domain.rental.Renter;
import galaxy.hexagonal.arch.domain.rental.ReturnedVehicle;

public interface ReturnVehiclePort {
    ReturnedVehicle returnVehicle(String plate, Renter renter);
}
