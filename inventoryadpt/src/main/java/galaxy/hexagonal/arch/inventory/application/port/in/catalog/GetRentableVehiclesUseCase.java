package galaxy.hexagonal.arch.inventory.application.port.in.catalog;

import galaxy.hexagonal.arch.domain.catalog.VehicleItem;

import java.util.List;

public interface GetRentableVehiclesUseCase {
    List<VehicleItem> getRentableVehicles();

}
