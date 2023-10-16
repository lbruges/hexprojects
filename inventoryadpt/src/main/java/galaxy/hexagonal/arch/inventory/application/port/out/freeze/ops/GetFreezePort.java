package galaxy.hexagonal.arch.inventory.application.port.out.freeze.ops;

import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;

public interface GetFreezePort {
    FrozenInventory getFreeze(String freezeCode);
}
