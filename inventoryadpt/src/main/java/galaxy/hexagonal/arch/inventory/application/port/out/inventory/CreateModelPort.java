package galaxy.hexagonal.arch.inventory.application.port.out.inventory;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;

public interface CreateModelPort {
    void createModel(VehicleModel model);
}
