package pmf.it.app.budgettracker.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerHandler {
	
	@ExceptionHandler(value = RuntimeException.class)
	public final ResponseEntity<String> handleException(Exception e){
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
