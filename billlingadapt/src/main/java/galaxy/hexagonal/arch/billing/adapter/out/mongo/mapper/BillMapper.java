package galaxy.hexagonal.arch.billing.adapter.out.mongo.mapper;

import galaxy.hexagonal.arch.billing.adapter.out.mongo.document.BillDocument;
import galaxy.hexagonal.arch.domain.Person;
import galaxy.hexagonal.arch.domain.billing.Bill;
import galaxy.hexagonal.arch.domain.billing.Item;
import galaxy.hexagonal.arch.domain.util.mapper.GenericDomainEntityMapper;

public class BillMapper extends GenericDomainEntityMapper<Bill, BillDocument> {
    private final ItemMapper itemMapper = new ItemMapper();
    private final PersonMapper personMapper = new PersonMapper();

    @Override
    public BillDocument toEntity(Bill bill) {
        return BillDocument.builder()
                .id(bill.getCode())
                .items(itemMapper.toEntities(bill.getItems()))
                .concept(bill.getConcept())
                .returnDate(bill.getReturnDate())
                .rentalStartDate(bill.getRentalStartDate())
                .rentalEndDate(bill.getRentalEndDate())
                .purchaser(personMapper.toEntity(bill.getPurchaser()))
                .build();
    }

    @Override
    public Bill toDomain(BillDocument bill) {
        return Bill.builder()
                .code(bill.getId())
                .items(itemMapper.toDomains(bill.getItems()))
                .concept(bill.getConcept())
                .returnDate(bill.getReturnDate())
                .rentalStartDate(bill.getRentalStartDate())
                .rentalEndDate(bill.getRentalEndDate())
                .purchaser(personMapper.toDomain(bill.getPurchaser()))
                .build();
    }

    private static class ItemMapper extends GenericDomainEntityMapper<Item, BillDocument.Item> {

        @Override
        public BillDocument.Item toEntity(Item item) {
            return BillDocument.Item
                    .builder()
                    .units(item.getUnits())
                    .code(item.getCode())
                    .basePrice(item.getBasePrice())
                    .overdueCharges(item.getOverdueCharges())
                    .totalPrice(item.getTotalPrice())
                    .build();
        }

        @Override
        public Item toDomain(BillDocument.Item item) {
            return Item
                    .builder()
                    .units(item.getUnits())
                    .code(item.getCode())
                    .basePrice(item.getBasePrice())
                    .overdueCharges(item.getOverdueCharges())
                    .totalPrice(item.getTotalPrice())
                    .build();
        }
    }

    private static class PersonMapper extends GenericDomainEntityMapper<Person, BillDocument.Purchaser> {

        @Override
        public BillDocument.Purchaser toEntity(Person person) {
            return BillDocument.Purchaser
                    .builder()
                    .dni(person.getDni())
                    .fullName(person.getFullName())
                    .build();
        }

        @Override
        public Person toDomain(BillDocument.Purchaser purchaser) {
            return Person.builder()
                    .dni(purchaser.getDni())
                    .fullName(purchaser.getFullName())
                    .build();
        }
    }
}
