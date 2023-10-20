package galaxy.hexagonal.arch.billing.application.port.out;

import galaxy.hexagonal.arch.billing.application.port.out.ops.SaveBillPort;
import galaxy.hexagonal.arch.billing.application.port.out.ops.GetAllBillsPort;

public abstract class GenericBillPort implements SaveBillPort, GetAllBillsPort {
}
