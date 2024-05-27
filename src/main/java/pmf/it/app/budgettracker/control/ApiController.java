package pmf.it.app.budgettracker.control;

import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ApiController {
	static final Logger LOGGER = Logger.getLogger(ApiController.class.getName());
	@GetMapping("renew")
	public ResponseEntity<String> renew(){
		LOGGER.info("Deploy status is renewed");
		return ResponseEntity.ok("Renewed");
	}
}
