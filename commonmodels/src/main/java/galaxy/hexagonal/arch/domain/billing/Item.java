package galaxy.hexagonal.arch.domain.billing;

import lombok.Data;

@Data
public class Item {

    private String code;
    private double price;
    private int units;

}
