package galaxy.hexagonal.arch.billing.application.port.out.ops;

import galaxy.hexagonal.arch.domain.billing.Bill;

import java.util.List;

public interface GetAllBillsPort {

    List<Bill> getAllBills();

}
