package galaxy.hexagonal.arch.inventory.application.port.out.catalog;

import galaxy.hexagonal.arch.domain.catalog.VehicleItem;

import java.util.List;

public interface VehicleFindAllRentablePort {

    List<VehicleItem> findAllRentableVehicles();

}
