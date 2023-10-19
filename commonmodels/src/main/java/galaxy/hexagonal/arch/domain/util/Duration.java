package galaxy.hexagonal.arch.domain.util;

import java.time.temporal.ChronoUnit;

public record Duration(int duration, ChronoUnit unit) {

    public java.time.Duration asDuration() {
        return java.time.Duration.of(this.duration, this.unit);
    }

}
