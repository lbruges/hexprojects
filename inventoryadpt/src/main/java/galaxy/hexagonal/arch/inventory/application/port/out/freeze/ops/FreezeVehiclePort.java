package galaxy.hexagonal.arch.inventory.application.port.out.freeze.ops;

import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;

import java.time.LocalDateTime;

public interface FreezeVehiclePort {

    FrozenInventory freezeVehicle(String sku, int freezeTimeInMins);
    FrozenInventory freezeVehicle(String sku, int freezeTimeInMins, LocalDateTime freezeStart);

}
