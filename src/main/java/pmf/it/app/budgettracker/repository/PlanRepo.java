package pmf.it.app.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Plan;

public interface PlanRepo extends JpaRepository<Plan, Long> {

}
