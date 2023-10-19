package galaxy.hexagonal.arch.domain.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Period {
    private LocalDate startDate;
    @Builder.Default
    private LocalTime startTime = LocalTime.parse("09:00");
    private Duration duration;

    public LocalDateTime getStartDateTime() {
        return LocalDateTime.of(startDate, startTime);
    }

    public java.time.Duration getDuration() {
        return duration.asDuration();
    }
    public void fromDuration(java.time.Duration duration) {
        this.duration = new Duration(duration.toSecondsPart(), ChronoUnit.SECONDS);
    }
}
