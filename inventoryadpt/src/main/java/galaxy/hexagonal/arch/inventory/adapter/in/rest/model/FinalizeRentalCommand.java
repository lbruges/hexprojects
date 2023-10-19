package galaxy.hexagonal.arch.inventory.adapter.in.rest.model;

import galaxy.hexagonal.arch.domain.rental.Renter;
import galaxy.hexagonal.arch.domain.util.Period;

public record FinalizeRentalCommand(String freezeCode, Renter renter, Period rentalPeriod) {
}
