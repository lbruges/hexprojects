package galaxy.hexagonal.arch.billing.adapter.out.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("bill")
public class BillDocument {

    @Id
    private String id;
    private LocalDateTime rentalStartDate;
    private LocalDateTime rentalEndDate;
    private LocalDateTime returnDate;
    private String concept;
    @Singular
    private List<Item> items;
    private Purchaser purchaser;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String code;
        private double basePrice;
        private double totalPrice;
        private int units;
        private int overdueCharges;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Purchaser {
        private String fullName;
        private String dni;
    }

}
