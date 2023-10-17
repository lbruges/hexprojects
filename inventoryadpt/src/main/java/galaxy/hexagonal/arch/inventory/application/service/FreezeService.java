package galaxy.hexagonal.arch.inventory.application.service;

import galaxy.hexagonal.arch.inventory.application.port.in.freeze.FreezeRentalUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.freeze.GetFreezeUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.freeze.RollbackFreezeUseCase;

public abstract class FreezeService implements FreezeRentalUseCase, GetFreezeUseCase, RollbackFreezeUseCase {
}
