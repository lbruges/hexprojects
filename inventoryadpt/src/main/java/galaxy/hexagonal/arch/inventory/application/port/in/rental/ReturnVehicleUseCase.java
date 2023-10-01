package galaxy.hexagonal.arch.inventory.application.port.in.rental;

public interface ReturnVehicleUseCase {
    void returnVehicle(String vehiclePlate, String renterIdDocument);

}
