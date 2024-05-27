package pmf.it.app.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Prihod;
import model.Trosak;

public interface PrihodRepo extends JpaRepository<Prihod, Long> {

	Prihod findByNameAndPlanId(String name, long id);
}
