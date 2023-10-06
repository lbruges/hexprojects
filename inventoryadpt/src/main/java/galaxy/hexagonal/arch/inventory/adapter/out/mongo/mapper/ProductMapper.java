package galaxy.hexagonal.arch.inventory.adapter.out.mongo.mapper;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;
import galaxy.hexagonal.arch.inventory.adapter.out.mongo.document.Product;
import galaxy.hexagonal.arch.inventory.application.mapper.GenericDomainEntityMapper;

public class ProductMapper extends GenericDomainEntityMapper<VehicleProduct, Product> {
    @Override
    public Product toEntity(VehicleProduct domain) {
        return Product.builder()
                .sku(domain.sku())
                .price(domain.price())
                .build();
    }

    @Override
    public VehicleProduct toDomain(Product entity) {
        return new VehicleProduct(entity.getSku(), entity.getPrice(), null);
    }
}
