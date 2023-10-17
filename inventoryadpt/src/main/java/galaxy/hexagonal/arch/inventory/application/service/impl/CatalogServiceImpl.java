package galaxy.hexagonal.arch.inventory.application.service.impl;

import galaxy.hexagonal.arch.domain.Period;
import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;
import galaxy.hexagonal.arch.exception.ErrorType;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.port.in.catalog.GetRentableVehiclesUseCase;
import galaxy.hexagonal.arch.inventory.application.port.out.catalog.GenericCatalogPort;
import galaxy.hexagonal.arch.inventory.application.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl extends CatalogService {

    private final GenericCatalogPort catalogPort;
    @Value("${inv.port.avail.start.rental.time:'09:00'}")
    private String rentalStartTime;

    @Override
    public List<VehicleItem> getRentableVehicles(Period rentalPeriod) {
        if (rentalPeriod.getStartDateTime().isBefore(LocalDateTime.now()) || rentalPeriod.getDuration().isNegative()) {
            throw new InventoryException(ErrorType.INVALID_DATE_RANGE);
        }

        List<VehicleItem> vehicleItems = catalogPort.findAllRentableVehicles(calculateStartDateTime(rentalPeriod.getStartDateTime()));

        if (vehicleItems == null || vehicleItems.isEmpty()) {
            throw new InventoryException(ErrorType.EMPTY_CATALOG);
        }

        return vehicleItems;
    }

    private LocalDateTime calculateStartDateTime(LocalDateTime startDate) {
        LocalDateTime baseDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.parse(rentalStartTime));
        LocalDateTime targetStartDate;

        if (startDate.isBefore(baseDateTime)) {
            if (baseDateTime.isBefore(LocalDateTime.now()))  {
                targetStartDate = baseDateTime.plusDays(1);
            } else {
                targetStartDate = baseDateTime;
            }
        } else {
            targetStartDate = startDate;
        }

        return targetStartDate;
    }

}
