package pmf.it.app.budgettracker.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public record PlanDTO(
		@JsonProperty("name")
		String name,
		@JsonProperty("troskovi")
		List<TrosakDTO> troskovi,
		@JsonProperty("prihodi")
		List<PrihodDTO> prihodi,
		@JsonProperty("korisnik")
		KorisnikDTO korisnik,
		@JsonProperty("cilj")
		Number cilj
	) {

}
