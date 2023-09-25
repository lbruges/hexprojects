package galaxy.hexagonal.arch.domain;

import lombok.Data;

@Data
public class Vehicle {

    private VehicleType type;
    private String brand;
    private String model;
    private double rentalPrice;

}
