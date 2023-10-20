package galaxy.hexagonal.arch.billing.application.port.in;

import galaxy.hexagonal.arch.domain.billing.Bill;
import galaxy.hexagonal.arch.domain.rental.ReturnedVehicle;

public interface GenerateBillUseCase {
    Bill generateBill(ReturnedVehicle rentedVehicle);

}
