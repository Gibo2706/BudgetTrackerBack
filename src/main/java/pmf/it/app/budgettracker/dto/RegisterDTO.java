package pmf.it.app.budgettracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public record RegisterDTO(
		@JsonProperty("username")
		String username,
		@JsonProperty("password")
		String password,
		@JsonProperty("email")
		String email,
		@JsonProperty("firstName")
		String firstName,
		@JsonProperty("lastName")
		String lastName
) {

}
