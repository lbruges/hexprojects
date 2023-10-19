package galaxy.hexagonal.arch.inventory.adapter.out.mysql;

import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.CatalogItemMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.VehicleRepository;
import galaxy.hexagonal.arch.inventory.application.port.out.catalog.GenericCatalogPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class MySqlCatalogAdapter extends GenericCatalogPort {

    private final VehicleRepository vehicleRepository;
    private final CatalogItemMapper catalogItemMapper;
    @Override
    public List<VehicleItem> findAllRentableVehicles(LocalDateTime startDate) {
        return catalogItemMapper.toDomains(vehicleRepository.findAvailableVehicles(startDate));
    }
}
