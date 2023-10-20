package galaxy.hexagonal.arch.billing.adapter.out.mysql.mapper;

import galaxy.hexagonal.arch.billing.adapter.out.mysql.entity.BillEntity;
import galaxy.hexagonal.arch.billing.application.exception.BillingException;
import galaxy.hexagonal.arch.domain.Person;
import galaxy.hexagonal.arch.domain.billing.Bill;
import galaxy.hexagonal.arch.domain.billing.Item;
import galaxy.hexagonal.arch.domain.util.mapper.GenericDomainEntityMapper;
import galaxy.hexagonal.arch.exception.ErrorType;

public class BillMapper extends GenericDomainEntityMapper<Bill, BillEntity> {
    @Override
    public BillEntity toEntity(Bill bill) {
        Item billingItem = bill.getItems().stream().findFirst()
                .orElseThrow(() -> new BillingException(ErrorType.RENTAL_BILL_ERROR));

        return BillEntity.builder()
                .purchaserFullName(bill.getPurchaser().getFullName())
                .totalPrice((float) billingItem.getTotalPrice())
                .basePrice((float) billingItem.getBasePrice())
                .units(billingItem.getUnits())
                .overdueCharges(billingItem.getOverdueCharges())
                .rentalStartDate(bill.getRentalStartDate())
                .rentalEndDate(bill.getRentalEndDate())
                .returnDate(bill.getReturnDate())
                .code(bill.getCode())
                .purchaserDni(bill.getPurchaser().getDni())
                .concept(bill.getConcept())
                .build();
    }

    @Override
    public Bill toDomain(BillEntity billEntity) {
        return Bill.builder()
                .code(billEntity.getCode())
                .concept(billEntity.getConcept())
                .rentalStartDate(billEntity.getRentalStartDate())
                .rentalEndDate(billEntity.getRentalStartDate())
                .returnDate(billEntity.getReturnDate())
                .purchaser(Person.builder()
                        .dni(billEntity.getPurchaserDni())
                        .fullName(billEntity.getPurchaserFullName())
                        .build())
                .item(Item.builder()
                        .basePrice(billEntity.getBasePrice())
                        .totalPrice(billEntity.getTotalPrice())
                        .overdueCharges(billEntity.getOverdueCharges())
                        .units(billEntity.getUnits())
                        .build())
                .build();
    }
}
