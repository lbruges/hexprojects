package galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Product;
import galaxy.hexagonal.arch.inventory.application.mapper.GenericDomainEntityMapper;
import lombok.RequiredArgsConstructor;

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
