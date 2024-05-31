package pmf.it.app.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Token;

public interface TokenRepo extends JpaRepository<Token, Long> {
	
}
