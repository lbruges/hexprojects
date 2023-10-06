package galaxy.hexagonal.arch.inventory.application.mapper;

import java.util.List;

public interface DomainEntityMapper<D, E> {

    E toEntity(D domain);
    D toDomain(E entity);

    List<E> toEntities(List<D> domains);
    List<D> toDomains(List<E> entities);

}
