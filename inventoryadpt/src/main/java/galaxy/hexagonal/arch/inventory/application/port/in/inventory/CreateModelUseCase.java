package galaxy.hexagonal.arch.inventory.application.port.in.inventory;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;

public interface CreateModelUseCase {

    void createModel(VehicleModel model);

}
