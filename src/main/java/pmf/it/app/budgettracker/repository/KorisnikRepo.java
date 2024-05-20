package pmf.it.app.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Korisnik;

public interface KorisnikRepo extends JpaRepository<Korisnik, Long> {

	Korisnik findByUsername(String username);
}
