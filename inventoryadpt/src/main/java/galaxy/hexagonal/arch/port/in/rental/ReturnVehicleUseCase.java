package galaxy.hexagonal.arch.port.in.rental;

public interface ReturnVehicleUseCase {
    void returnVehicle(String vehiclePlate, String renterIdDocument);

}
