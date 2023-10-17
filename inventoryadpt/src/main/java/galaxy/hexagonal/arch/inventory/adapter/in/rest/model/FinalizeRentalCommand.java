package galaxy.hexagonal.arch.inventory.adapter.in.rest.model;

import galaxy.hexagonal.arch.domain.Period;
import galaxy.hexagonal.arch.domain.rental.Renter;

public record FinalizeRentalCommand(String freezeCode, Renter renter, Period rentalPeriod) {
}
