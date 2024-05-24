package pmf.it.app.budgettracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Plan;

public interface PlanRepo extends JpaRepository<Plan, Long> {

	List<Plan> findAllByKorisnikId(Long id);
}
