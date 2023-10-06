package galaxy.hexagonal.arch.inventory.application.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericDomainEntityMapper<D, E> implements DomainEntityMapper<D, E> {
    @Override
    public List<E> toEntities(List<D> domains) {
        return domains.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<D> toDomains(List<E> entities) {
        return entities.stream().map(this::toDomain).collect(Collectors.toList());
    }
}
