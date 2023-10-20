package galaxy.hexagonal.arch.billing.adapter.out.mongo;

import galaxy.hexagonal.arch.billing.adapter.out.mongo.document.BillDocument;
import galaxy.hexagonal.arch.billing.adapter.out.mongo.mapper.BillMapper;
import galaxy.hexagonal.arch.billing.adapter.out.mongo.repository.BillRepository;
import galaxy.hexagonal.arch.billing.application.port.out.GenericBillPort;
import galaxy.hexagonal.arch.domain.billing.Bill;
import galaxy.hexagonal.arch.domain.util.IdGenerator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MongoBillAdapter extends GenericBillPort {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public List<Bill> getAllBills() {
        return billMapper.toDomains(billRepository.findAll());
    }

    @Override
    public Bill createBill(Bill bill) {
        BillDocument document = billMapper.toEntity(bill);
        document.setId(IdGenerator.generateId());

        return billMapper.toDomain(billRepository.save(document));
    }
}
