package galaxy.hexagonal.arch.inventory.service;

import galaxy.hexagonal.arch.domain.catalog.VehicleItem;
import galaxy.hexagonal.arch.port.in.catalog.GetRentableVehiclesUseCase;

import java.util.List;

public class CatalogService implements GetRentableVehiclesUseCase {
    @Override
    public List<VehicleItem> getRentableVehicles() {
        return null;
    }
}
