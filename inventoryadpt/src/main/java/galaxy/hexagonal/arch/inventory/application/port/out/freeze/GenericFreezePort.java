package galaxy.hexagonal.arch.inventory.application.port.out.freeze;

import galaxy.hexagonal.arch.inventory.application.port.out.freeze.ops.FreezeVehiclePort;
import galaxy.hexagonal.arch.inventory.application.port.out.freeze.ops.GetFreezePort;
import galaxy.hexagonal.arch.inventory.application.port.out.freeze.ops.ThawVehiclePort;

public abstract class GenericFreezePort implements FreezeVehiclePort, GetFreezePort, ThawVehiclePort {
}
