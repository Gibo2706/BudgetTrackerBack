package pmf.it.app.budgettracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public record TrosakDTO(
		@JsonProperty("name")
		String name,
		@JsonProperty("amount")
		double amount,
		@JsonProperty("isImpulse")
		boolean isImpulse
	) {

}
