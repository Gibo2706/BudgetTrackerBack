package pmf.it.app.budgettracker.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pmf.it.app.budgettracker.dto.KorisnikDTO;
import pmf.it.app.budgettracker.interceptor.TokenHolder;
import pmf.it.app.budgettracker.service.KorisnikService;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	KorisnikService ks;
	
	@Autowired
	TokenHolder th;
	
	@GetMapping("getUser")
	public ResponseEntity<KorisnikDTO> getUser(){
		String username = th.getKorisnik().getUsername();
		return ResponseEntity.ok(ks.findUser(username));
	}
	
	@PostMapping("updateUser")
	public ResponseEntity<KorisnikDTO> updateUser(@RequestBody KorisnikDTO dto){
		return ResponseEntity.ok(ks.updateUser(th.getKorisnik().getUsername(), dto));
	}
	
}
