package galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper;

import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;
import galaxy.hexagonal.arch.exception.ErrorType;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Vehicle;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.mapper.GenericDomainEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CatalogItemMapper extends GenericDomainEntityMapper<VehicleItem, Vehicle> {

    private final ModelMapper modelMapper;

    @Override
    public Vehicle toEntity(VehicleItem domain) {
        throw new IllegalArgumentException("Method not implemented");
    }

    @Override
    public VehicleItem toDomain(Vehicle entity) {
        throw new IllegalArgumentException("Method not implemented");
    }

    private VehicleItem toDomain(List<Vehicle> vehicles) {
        Vehicle sampleVehicle = vehicles.stream()
                .findAny()
                .orElseThrow(() -> new InventoryException(ErrorType.EMPTY_CATALOG));

        return VehicleItem.builder()
                .sku(sampleVehicle.getProduct().getSku())
                .availableUnits(vehicles.size())
                .model(modelMapper.toDomain(sampleVehicle.getProduct().getModel()))
                .rentalPrice(sampleVehicle.getProduct().getPrice())
                .build();
    }

    @Override
    public List<VehicleItem> toDomains(List<Vehicle> entities) {
        Map<String, List<Vehicle>> vehiclesBySku = entities
                .stream()
                .collect(Collectors.groupingBy(e -> e.getProduct().getSku(),
                        HashMap::new, Collectors.toCollection(ArrayList::new)));

        return vehiclesBySku.values().stream().map(this::toDomain).collect(Collectors.toList());
    }
}
