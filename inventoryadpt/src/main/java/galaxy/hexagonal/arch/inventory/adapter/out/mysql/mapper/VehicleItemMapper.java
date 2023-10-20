package galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper;

import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Vehicle;
import galaxy.hexagonal.arch.inventory.application.mapper.GenericDomainEntityMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VehicleItemMapper extends GenericDomainEntityMapper<VehicleItem, Vehicle> {

    private final ModelMapper modelMapper;

    @Override
    public Vehicle toEntity(VehicleItem domain) {
        throw new IllegalArgumentException("Not implemented");
    }

    @Override
    public VehicleItem toDomain(Vehicle entity) {
        return VehicleItem.builder()
                .sku(entity.getProduct().getSku())
                .rentalPrice(entity.getProduct().getPrice())
                .model(modelMapper.toDomain(entity.getProduct().getModel()))
                .build();
    }
}
