package galaxy.hexagonal.arch.billing.application.port.out.ops;

import galaxy.hexagonal.arch.domain.billing.Bill;

public interface SaveBillPort {
    Bill createBill(Bill bill);

}
