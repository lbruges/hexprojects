package galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;

import java.util.List;

public interface GetAllModelsPort {
    List<VehicleModel> getAllModels();
}
