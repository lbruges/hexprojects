package galaxy.hexagonal.arch.inventory.application.port.out.catalog.ops;

import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleFindAllRentablePort {

    List<VehicleItem> findAllRentableVehicles(LocalDateTime startDateTime);

}
