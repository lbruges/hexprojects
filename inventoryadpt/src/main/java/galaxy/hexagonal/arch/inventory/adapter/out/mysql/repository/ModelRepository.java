package galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    @Query("SELECT CASE WHEN (COUNT(m) > 0)  THEN TRUE ELSE FALSE END FROM Model m WHERE m.type=:#{#model.type().name()} " +
            "AND m.brand=:#{#model.brand()} AND m.year=:#{#model.year()} AND m.model=:#{#model.model()}")
    boolean modelExists(@Param("model") VehicleModel domainModel);

    @Query("SELECT m FROM Model m WHERE m.type=:#{#model.type.name()} AND m.brand=:#{#model.brand} AND m.year=:#{#model.year} AND m.model=:#{#model.model}")
    Model findModel(@Param("model") VehicleModel domainModel);

    Model findByCode(String code);

}
