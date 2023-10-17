package galaxy.hexagonal.arch.inventory.application.port.out.rental.ops;
import galaxy.hexagonal.arch.domain.rental.Renter;

public interface ReturnVehiclePort {
    void returnVehicle(String plate, Renter renter);
}
