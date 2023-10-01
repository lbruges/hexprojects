package galaxy.hexagonal.arch.inventory.application.port.in.freeze;

import galaxy.hexagonal.arch.domain.inventory.FrozenInventory;

public interface GetFreezeUseCase {
    FrozenInventory getFreeze(String freezeCode);

}
