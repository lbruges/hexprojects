package galaxy.hexagonal.arch.inventory.application.port.in.inventory;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;

import java.util.List;

public interface GetAllModelsUseCase {

    List<VehicleModel> getAllModels();
}
