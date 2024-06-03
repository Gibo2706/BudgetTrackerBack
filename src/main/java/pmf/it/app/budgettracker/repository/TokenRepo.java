package pmf.it.app.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Korisnik;
import model.Token;

public interface TokenRepo extends JpaRepository<Token, Long> {
	
	
	Token findByKorisnik(Korisnik k);
}
