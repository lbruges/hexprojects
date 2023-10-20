package galaxy.hexagonal.arch.billing.application.port.out.ops;

import galaxy.hexagonal.arch.domain.billing.Bill;

public interface SaveBillPort {
    void createBill(Bill bill);

}
