package galaxy.hexagonal.arch.domain.inventory.req;

import galaxy.hexagonal.arch.domain.inventory.VehicleType;

public record VehicleModel(String code, VehicleType type, String brand, String model, int year) {
}
