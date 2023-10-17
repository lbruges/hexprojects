package galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository;

import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Freeze;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreezeRepository extends JpaRepository<Freeze, Integer> {

    Freeze findByFreezeCode(String freezeCode);
    void deleteByFreezeCode(String freezeCode);

}
