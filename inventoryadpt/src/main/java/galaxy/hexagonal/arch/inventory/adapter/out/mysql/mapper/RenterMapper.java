package galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Renter;
import galaxy.hexagonal.arch.inventory.application.mapper.GenericDomainEntityMapper;

public class RenterMapper extends GenericDomainEntityMapper<galaxy.hexagonal.arch.domain.rental.Renter, Renter> {
    @Override
    public Renter toEntity(galaxy.hexagonal.arch.domain.rental.Renter domain) {
        return Renter.builder()
                .fullName(domain.getFullName())
                .idDocument(domain.getDni())
                .origin(domain.getOrigin())
                .licence(domain.getLicenceNumber())
                .build();
    }

    @Override
    public galaxy.hexagonal.arch.domain.rental.Renter toDomain(Renter entity) {
        return galaxy.hexagonal.arch.domain.rental.Renter.builder()
                .origin(entity.getOrigin())
                .fullName(entity.getFullName())
                .dni(entity.getIdDocument())
                .licenceNumber(entity.getLicence())
                .build();
    }
}
