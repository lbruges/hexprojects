package galaxy.hexagonal.arch.inventory.application.port.in.catalog;


import galaxy.hexagonal.arch.domain.util.Period;
import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;

import java.util.List;

public interface GetRentableVehiclesUseCase {
    List<VehicleItem> getRentableVehicles(Period rentalPeriod);

}
