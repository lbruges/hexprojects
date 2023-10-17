package galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper;

import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Vehicle;
import galaxy.hexagonal.arch.inventory.application.mapper.GenericDomainEntityMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RentedVehicleMapper extends GenericDomainEntityMapper<RentedVehicle, Vehicle> {

    private final RenterMapper renterMapper;
    private final ModelMapper modelMapper;

    @Override
    public Vehicle toEntity(RentedVehicle domain) {
        throw new IllegalArgumentException("Not implemented");
    }

    @Override
    public RentedVehicle toDomain(Vehicle entity) {
        return RentedVehicle.builder()
                .renter(renterMapper.toDomain(entity.getRental().getRenter()))
                .sku(entity.getProduct().getSku())
                .plate(entity.getPlate())
                .model(modelMapper.toDomain(entity.getProduct().getModel()))
                .rentalPrice(entity.getProduct().getPrice())
                .build();
    }
}
