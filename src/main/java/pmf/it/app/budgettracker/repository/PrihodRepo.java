package pmf.it.app.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Prihod;

public interface PrihodRepo extends JpaRepository<Prihod, Long> {

}
