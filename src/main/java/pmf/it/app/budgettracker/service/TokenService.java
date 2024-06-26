package pmf.it.app.budgettracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Korisnik;
import model.Token;
import pmf.it.app.budgettracker.repository.TokenRepo;

@Service
public class TokenService {

	@Autowired
	TokenRepo tr;
	
	public void saveConfirmationToken(Token t) {
		tr.save(t);
	}
	
	public Token getToken(Korisnik k) {
		return tr.findByKorisnik(k);
	}
}
