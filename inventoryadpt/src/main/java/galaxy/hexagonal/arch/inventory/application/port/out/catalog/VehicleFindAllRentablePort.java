package galaxy.hexagonal.arch.inventory.application.port.out.catalog;

import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;

import java.util.List;

public interface VehicleFindAllRentablePort {

    List<VehicleItem> findAllRentableVehicles();

}
