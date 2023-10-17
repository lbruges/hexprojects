package galaxy.hexagonal.arch.inventory.adapter.in.rest.model;

import galaxy.hexagonal.arch.domain.rental.Renter;

public record ReturnVehicleCommand(String plate, Renter renter) {
}
