package pmf.it.app.budgettracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public record Korisnik(
		@JsonProperty("username")
		String username,
		@JsonProperty("email")
		String email,
		@JsonProperty("name")
		String name,
		@JsonProperty("surname")
		String surname
	) {

}
