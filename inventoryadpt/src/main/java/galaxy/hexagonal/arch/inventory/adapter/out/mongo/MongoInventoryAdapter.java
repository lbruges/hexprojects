package galaxy.hexagonal.arch.inventory.adapter.out.mongo;

import galaxy.hexagonal.arch.domain.inventory.req.InventoryVehicleItem;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.document.Model;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.document.Product;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.document.Vehicle;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.mapper.ModelMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.mapper.ProductMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.repository.ModelRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.repository.ProductRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.repository.VehicleRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.util.IdGenerator;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.InventoryGenericPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import java.util.List;

@Profile("mongo")
@Controller
@RequiredArgsConstructor
public class MongoInventoryAdapter extends InventoryGenericPort {

    private final ModelRepository modelRepository;
    private final ProductRepository productRepository;
    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;
    private final ProductMapper productMapper;

    @Override
    public boolean modelPresent(VehicleModel model) {
        return modelRepository.findModel(model) != null;
    }

    @Override
    public void createModel(VehicleModel model) {
        Model modelEntity = modelMapper.toEntity(model);
        modelEntity.setId(IdGenerator.generateId());
        modelRepository.save(modelEntity);
    }

    @Override
    public void createProduct(VehicleProduct product) {
        String modelId = modelRepository.findModelId(product.model());
        Product productEntity = productMapper.toEntity(product);
        productEntity.setModelId(modelId);
        productEntity.setId(IdGenerator.generateId());
        productRepository.save(productEntity);
    }

    @Override
    public List<VehicleProduct> getAllProducts() {
        return productMapper.toDomains(productRepository.findAll());
    }


    @Override
    public void addVehicle(InventoryVehicleItem vehicleItem) {
        String productId = productRepository.findIdBySku(vehicleItem.sku());

        Vehicle vehicleEntity = Vehicle.builder()
                .id(IdGenerator.generateId())
                .plate(vehicleItem.plate())
                .productId(productId)
                .build();

        vehicleRepository.save(vehicleEntity);
    }
}
