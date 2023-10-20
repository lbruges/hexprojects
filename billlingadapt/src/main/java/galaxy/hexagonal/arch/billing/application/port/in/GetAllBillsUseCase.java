package galaxy.hexagonal.arch.billing.application.port.in;

import galaxy.hexagonal.arch.domain.billing.Bill;

import java.util.List;

public interface GetAllBillsUseCase {
    List<Bill> getAllBills();

}
