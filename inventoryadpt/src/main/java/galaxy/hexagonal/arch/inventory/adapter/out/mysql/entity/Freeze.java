package galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.generics.GenericStatusEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "freeze")
public class Freeze extends GenericStatusEntity {

    @Column(name = "freeze_date")
    private LocalDateTime freezeDate;

    @Column(name = "freeze_time_minutes")
    private int freezeTimeInMin;
}
