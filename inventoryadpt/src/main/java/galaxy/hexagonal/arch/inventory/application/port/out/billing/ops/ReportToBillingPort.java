package galaxy.hexagonal.arch.inventory.application.port.out.billing.ops;

import galaxy.hexagonal.arch.domain.rental.ReturnedVehicle;

public interface ReportToBillingPort {
    void reportToBilling(ReturnedVehicle returnedVehicle);
}
