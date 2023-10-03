package galaxy.hexagonal.arch.inventory.application.service;

import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;
import galaxy.hexagonal.arch.inventory.application.port.in.catalog.GetRentableVehiclesUseCase;

import java.util.List;

public class CatalogService implements GetRentableVehiclesUseCase {
    @Override
    public List<VehicleItem> getRentableVehicles() {
        return null;
    }
}
