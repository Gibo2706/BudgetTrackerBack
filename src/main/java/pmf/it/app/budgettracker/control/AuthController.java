package pmf.it.app.budgettracker.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Korisnik;
import pmf.it.app.budgettracker.repository.KorisnikRepo;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private KorisnikRepo kr;
	
	@GetMapping("/login")
	public ResponseEntity<String> logIn(){
		String res = "Logged   !\n";
		
		System.out.println(kr.count());
		for (Korisnik kz : kr.findAll())
			res += kz.toString() + "\n";
		return ResponseEntity.ok(res);
	}
}
