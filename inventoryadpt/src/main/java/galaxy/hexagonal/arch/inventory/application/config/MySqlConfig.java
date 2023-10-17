package galaxy.hexagonal.arch.inventory.application.config;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.MySqlAdapterInventory;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.MySqlCatalogAdapter;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.MySqlFreezeAdapter;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.MySqlRentalAdapter;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.ModelMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.ProductMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.CatalogItemMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.RentableVehicleMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.RentedVehicleMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.RenterMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.FreezeRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.ModelRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.ProductRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.RentalRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.RenterRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.VehicleRepository;
import galaxy.hexagonal.arch.inventory.application.port.out.catalog.GenericCatalogPort;
import galaxy.hexagonal.arch.inventory.application.port.out.freeze.GenericFreezePort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.GenericInventoryPort;
import galaxy.hexagonal.arch.inventory.application.port.out.rental.GenericRentalPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mysql")
public class MySqlConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper(modelMapper());
    }

    @Bean
    public CatalogItemMapper vehicleMapper() {
        return new CatalogItemMapper(modelMapper());
    }

    @Bean
    public RentableVehicleMapper rentableVehicleMapper() {
        return new RentableVehicleMapper(modelMapper());
    }

    @Bean
    public RenterMapper renterMapper() {
        return new RenterMapper();
    }

    @Bean
    public RentedVehicleMapper rentedVehicleMapper() {
        return new RentedVehicleMapper(renterMapper(), modelMapper());
    }

    @Bean
    public GenericCatalogPort genericCatalogPort(VehicleRepository vehicleRepository) {
        return new MySqlCatalogAdapter(vehicleRepository, vehicleMapper());
    }

    @Bean
    public GenericInventoryPort genericInventoryPort(ProductRepository productRepository, ModelRepository modelRepository,
                                                     VehicleRepository vehicleRepository) {
        return new MySqlAdapterInventory(productRepository, modelRepository, vehicleRepository, productMapper(),
                modelMapper());
    }

    @Bean
    public GenericFreezePort genericFreezePort(VehicleRepository vehicleRepository, FreezeRepository freezeRepository) {
        return new MySqlFreezeAdapter(vehicleRepository, freezeRepository, rentableVehicleMapper());
    }

    @Bean
    public GenericRentalPort genericRentalPort(VehicleRepository vehicleRepository, RentalRepository rentalRepository,
                                               RenterRepository renterRepository) {
        return new MySqlRentalAdapter(vehicleRepository, rentalRepository, renterRepository, renterMapper(),
                rentedVehicleMapper());
    }

}
