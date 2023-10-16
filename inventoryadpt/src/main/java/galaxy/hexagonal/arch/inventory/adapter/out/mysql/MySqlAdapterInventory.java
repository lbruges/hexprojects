package galaxy.hexagonal.arch.inventory.adapter.out.mysql;

import galaxy.hexagonal.arch.domain.inventory.req.InventoryVehicleItem;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.GenericInventoryPort;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Model;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Product;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Vehicle;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.ModelMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.ProductMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.ModelRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.ProductRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MySqlAdapterInventory extends GenericInventoryPort {

    private final ProductRepository productRepository;
    private final ModelRepository modelRepository;
    private final VehicleRepository vehicleRepository;
    private final ProductMapper productMapper;
    private final ModelMapper modelMapper;

    @Override
    public boolean modelPresent(VehicleModel model) {
        return modelRepository.modelExists(model);
    }

    @Override
    public void createModel(VehicleModel model) {
        modelRepository.save(modelMapper.toEntity(model));
    }

    @Override
    public void createProduct(VehicleProduct product) {
        Product productEntity = productMapper.toEntity(product);
        Model modelEntity = modelRepository.findModel(product.model());
        productEntity.setModel(modelEntity);
        productRepository.save(productEntity);
    }

    @Override
    public void addVehicle(InventoryVehicleItem vehicleItem) {
        Product product = productRepository.findBySku(vehicleItem.sku());
        Vehicle vehicleEntity = Vehicle.builder()
                .plate(vehicleItem.plate())
                .product(product)
                .build();

        vehicleRepository.save(vehicleEntity);
    }

    @Override
    public List<VehicleProduct> getAllProducts() {
        return productMapper.toDomains(productRepository.findAll());
    }


}
