package galaxy.hexagonal.arch.billing.application.service.impl;

import galaxy.hexagonal.arch.billing.application.port.out.GenericBillPort;
import galaxy.hexagonal.arch.billing.application.service.BillingService;
import galaxy.hexagonal.arch.domain.billing.Bill;
import galaxy.hexagonal.arch.domain.billing.Item;
import galaxy.hexagonal.arch.domain.rental.RentableVehicle;
import galaxy.hexagonal.arch.domain.rental.ReturnedVehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static galaxy.hexagonal.arch.billing.application.util.Constants.CAR_RENTAL_CONCEPT;
import static galaxy.hexagonal.arch.billing.application.util.Constants.CAR_RENTAL_CONCEPT_OVERDUE;
import static galaxy.hexagonal.arch.billing.application.util.Constants.RENT_UNITS;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl extends BillingService {

    private final GenericBillPort adapter;
    @Value("${bill.port.additional.charge.per.day:0.03}")
    private double additionalChargePerDay;

    @Override
    public Bill generateBill(ReturnedVehicle rentedVehicle) {
        Bill bill = Bill.builder()
                .concept(rentedVehicle.getActualReturnDate().isAfter(rentedVehicle.getOriginalReturnDate()) ?
                        CAR_RENTAL_CONCEPT_OVERDUE : CAR_RENTAL_CONCEPT)
                .rentalStartDate(rentedVehicle.getRentalDate())
                .rentalEndDate(rentedVehicle.getOriginalReturnDate())
                .returnDate(rentedVehicle.getActualReturnDate())
                .item(vehicleToItem(rentedVehicle.getItem(), rentedVehicle.getRentalDate(), rentedVehicle.getOriginalReturnDate(),
                        rentedVehicle.getActualReturnDate()))
                .purchaser(rentedVehicle.getRenter())
                .build();

        return adapter.createBill(bill);
    }

    @Override
    public List<Bill> getAllBills() {
        return adapter.getAllBills();
    }

    private Item vehicleToItem(RentableVehicle rentableVehicle, LocalDateTime rentalDate, LocalDateTime originalReturnDate,
                               LocalDateTime actualReturnDate) {
        double basePrice = rentableVehicle.getRentalPrice();
        int overdueCharges = 0;

        long originalRentalPeriod = rentalDate.until(originalReturnDate, ChronoUnit.DAYS);

        if (originalRentalPeriod < 1) originalRentalPeriod = 1;

        double totalPrice = (originalRentalPeriod * basePrice);

        if (actualReturnDate.isAfter(originalReturnDate)) {
            long dayDelay = originalReturnDate.until(actualReturnDate, ChronoUnit.DAYS);
            if (dayDelay < 1) dayDelay = 1;

            totalPrice += dayDelay * (basePrice * additionalChargePerDay);
            overdueCharges = Long.valueOf(dayDelay).intValue();
        }

        return Item.builder()
                .basePrice(basePrice)
                .totalPrice(totalPrice)
                .code(rentableVehicle.getSku() + "_" + rentableVehicle.getPlate())
                .units(RENT_UNITS)
                .overdueCharges(overdueCharges)
                .build();
    }

}
