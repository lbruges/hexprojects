package galaxy.hexagonal.arch.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Person {
    private String fullName;
    private String dni;
    private LocalDate birthDate;
}
