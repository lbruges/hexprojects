package galaxy.hexagonal.arch.inventory.application.service.impl;

import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;
import galaxy.hexagonal.arch.domain.util.Period;
import galaxy.hexagonal.arch.exception.ErrorType;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.port.out.catalog.GenericCatalogPort;
import galaxy.hexagonal.arch.inventory.application.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl extends CatalogService {

    private final GenericCatalogPort catalogPort;

    @Override
    public List<VehicleItem> getRentableVehicles(Period rentalPeriod) {
        if (rentalPeriod.getStartDateTime().isBefore(LocalDateTime.now()) || rentalPeriod.getDuration().isNegative()) {
            throw new InventoryException(ErrorType.INVALID_DATE_RANGE);
        }

        List<VehicleItem> vehicleItems = catalogPort.findAllRentableVehicles(rentalPeriod.getStartDateTime());

        if (vehicleItems == null || vehicleItems.isEmpty()) {
            throw new InventoryException(ErrorType.EMPTY_CATALOG);
        }

        return vehicleItems;
    }

}
