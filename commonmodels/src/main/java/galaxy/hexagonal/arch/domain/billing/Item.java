package galaxy.hexagonal.arch.domain.billing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Item {

    private String code;
    private double basePrice;
    private double totalPrice;
    private int units;
    private int overdueCharges;

}
