package galaxy.hexagonal.arch.billing.adapter.out.mysql;

import galaxy.hexagonal.arch.billing.adapter.out.mysql.entity.BillEntity;
import galaxy.hexagonal.arch.billing.adapter.out.mysql.mapper.BillMapper;
import galaxy.hexagonal.arch.billing.adapter.out.mysql.repository.MySqlBillRepository;
import galaxy.hexagonal.arch.billing.application.port.out.GenericBillPort;
import galaxy.hexagonal.arch.domain.billing.Bill;
import galaxy.hexagonal.arch.domain.util.IdGenerator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MySqlBillAdapter extends GenericBillPort {

    private final MySqlBillRepository mySqlBillRepository;
    private final BillMapper billMapper;

    @Override
    public List<Bill> getAllBills() {
        return billMapper.toDomains(mySqlBillRepository.findAll());
    }

    @Override
    public Bill createBill(Bill bill) {
        BillEntity billEntity = billMapper.toEntity(bill);
        billEntity.setCode(IdGenerator.generateId());

        return billMapper.toDomain(mySqlBillRepository.save(billEntity));
    }

}
