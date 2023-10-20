package galaxy.hexagonal.arch.billing.adapter.out.mysql.repository;

import galaxy.hexagonal.arch.billing.adapter.out.mysql.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MySqlBillRepository extends JpaRepository<BillEntity, Integer> {

}
