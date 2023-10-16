package galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper;

import galaxy.hexagonal.arch.domain.rental.RentableVehicle;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Vehicle;
import galaxy.hexagonal.arch.inventory.application.mapper.GenericDomainEntityMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RentableVehicleMapper extends GenericDomainEntityMapper<RentableVehicle, Vehicle> {

    private final ModelMapper modelMapper;

    @Override
    public Vehicle toEntity(RentableVehicle domain) {
        throw new IllegalArgumentException("Not implemented.");
    }

    @Override
    public RentableVehicle toDomain(Vehicle entity) {
        return RentableVehicle.builder()
                .model(modelMapper.toDomain(entity.getProduct().getModel()))
                .rentalPrice(entity.getProduct().getPrice())
                .plate(entity.getPlate())
                .sku(entity.getProduct().getSku())
                .build();
    }

}
