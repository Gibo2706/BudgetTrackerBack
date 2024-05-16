package pmf.it.app.budgettracker.control;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("/login")
	public ResponseEntity<String> logIn(){
		return ResponseEntity.ok("Logged!");
	}
}
