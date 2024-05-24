package pmf.it.app.budgettracker.dto;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.Korisnik;
import model.Plan;
import model.Prihod;
import model.Trosak;

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

	public static List<PlanDTO> fromEntityList(List<Plan> plans) {
		List<PlanDTO> res = new ArrayList<PlanDTO>();
		for(Plan p : plans) {
			Korisnik k = p.getKorisnik();
			KorisnikDTO korisnik = new KorisnikDTO(k.getUsername(), k.getEmail(), k.getName(), k.getLastname());
			List<TrosakDTO> tDtos = new ArrayList<TrosakDTO>();
			List<PrihodDTO> pDtos = new ArrayList<PrihodDTO>();
			for(Trosak t : p.getTrosaks()) {
				tDtos.add(new TrosakDTO(t.getName(), t.getAmount().doubleValue(), t.getIsimpulse()));
			}
			for (Prihod prihod : p.getPrihods()) {
				pDtos.add(new PrihodDTO(prihod.getName(), prihod.getAmount().doubleValue()));
			}
			res.add(new PlanDTO(p.getName(), tDtos, pDtos, korisnik, p.getGoal()));
		}
		return res;
	}

}
