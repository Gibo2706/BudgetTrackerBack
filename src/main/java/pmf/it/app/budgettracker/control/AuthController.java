package pmf.it.app.budgettracker.control;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Korisnik;
import pmf.it.app.budgettracker.dto.RegisterDTO;
import pmf.it.app.budgettracker.dto.ResponseDTO;
import pmf.it.app.budgettracker.repository.KorisnikRepo;
import pmf.it.app.budgettracker.service.KorisnikService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private KorisnikService ks;
	
	private static final Logger log = Logger.getLogger(PlanController.class.getName());
	
	@GetMapping("/login")
	public ResponseEntity<ResponseDTO> logIn(String username, String password){
		log.debug("Login user: " + username);
		return ResponseEntity.ok(ks.logIn(username, password));
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> signUp(@RequestBody RegisterDTO reg){
		return ResponseEntity.ok(ks.signUp(reg));
	}
}
