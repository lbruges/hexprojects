package galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.impl;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Product;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.GenericDomainEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper extends GenericDomainEntityMapper<VehicleProduct, Product> {

    private final ModelMapper modelMapper;

    @Override
    public Product toEntity(VehicleProduct domain) {
        return Product.builder()
                .sku(domain.sku())
                .price(domain.price())
                .build();
    }

    @Override
    public VehicleProduct toDomain(Product entity) {
        return new VehicleProduct(entity.getSku(), entity.getPrice(), modelMapper.toDomain(entity.getModel()));
    }
}
