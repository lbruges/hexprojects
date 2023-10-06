package galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper;
import galaxy.hexagonal.arch.domain.inventory.VehicleType;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Model;
import galaxy.hexagonal.arch.inventory.application.mapper.GenericDomainEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper extends GenericDomainEntityMapper<VehicleModel, Model> {
    @Override
    public Model toEntity(VehicleModel domain) {
        return Model.builder()
                .model(domain.model())
                .brand(domain.brand())
                .type(domain.type().name())
                .year(domain.year())
                .build();
    }

    @Override
    public VehicleModel toDomain(Model entity) {
        return new VehicleModel(VehicleType.valueOf(entity.getType()), entity.getBrand(), entity.getModel(),
                entity.getYear());
    }

}
