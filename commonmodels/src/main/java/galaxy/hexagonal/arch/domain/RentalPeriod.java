package galaxy.hexagonal.arch.domain;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class RentalPeriod {
    private LocalDate startDate;
    private int dayCount;
}
