package pmf.it.app.budgettracker.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public record Plan(
		@JsonProperty("name")
		String name,
		@JsonProperty("troskovi")
		List<Trosak> troskovi,
		@JsonProperty("prihodi")
		List<Prihod> prihodi,
		@JsonProperty("korisnik")
		Korisnik korisnik
	) {

}
