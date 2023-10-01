package galaxy.hexagonal.arch.port.in.catalog;

import galaxy.hexagonal.arch.domain.catalog.VehicleItem;

import java.util.List;

public interface GetRentableVehiclesUseCase {
    List<VehicleItem> getRentableVehicles();

}
