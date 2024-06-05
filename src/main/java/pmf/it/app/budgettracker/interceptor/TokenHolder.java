package pmf.it.app.budgettracker.interceptor;

import model.Korisnik;

public class TokenHolder {
	private String token;
	private Korisnik korisnik;
    

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}
