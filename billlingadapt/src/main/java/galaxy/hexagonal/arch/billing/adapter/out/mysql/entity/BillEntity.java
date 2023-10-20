package galaxy.hexagonal.arch.billing.adapter.out.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bill")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String code;

    @Column(name = "rental_start_date")
    private LocalDateTime rentalStartDate;

    @Column(name = "rental_end_date")
    private LocalDateTime rentalEndDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column
    private String concept;

    @Column(name = "base_price")
    private float basePrice;

    @Column(name = "total_price")
    private float totalPrice;

    @Column
    private int units;

    @Column(name = "overdue_charges")
    private int overdueCharges;

    @Column(name = "purchaser_full_name")
    private String purchaserFullName;

    @Column(name = "purchaser_dni")
    private String purchaserDni;

}