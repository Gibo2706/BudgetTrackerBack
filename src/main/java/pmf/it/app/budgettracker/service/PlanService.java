package pmf.it.app.budgettracker.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pmf.it.app.budgettracker.dto.Plan;
import pmf.it.app.budgettracker.dto.Prihod;
import pmf.it.app.budgettracker.dto.Trosak;
import pmf.it.app.budgettracker.repository.KorisnikRepo;
import pmf.it.app.budgettracker.repository.PlanRepo;
import pmf.it.app.budgettracker.repository.PrihodRepo;
import pmf.it.app.budgettracker.repository.TrosakRepo;

@Service
public class PlanService {
	@Autowired
	private PlanRepo pr;
	
	@Autowired
	private TrosakRepo tr;
	
	@Autowired
	private KorisnikRepo kr;
	
	@Autowired
	private PrihodRepo pir;
	
	public boolean addPlan(Plan plan) {
		model.Plan p = new model.Plan();
		System.out.println(plan);
		System.out.println(plan.korisnik());
		model.Korisnik korisnik = kr.findByUsername(plan.korisnik().username());
		System.out.println(korisnik);
		p.setKorisnik(korisnik);
		p.setKorisnikId(korisnik.getId());
		p.setName(plan.name());
		p = pr.save(p);
		
		if (p != null) {
			for(Trosak t : plan.troskovi()) {
				model.Trosak trosak = new model.Trosak();
	            trosak.setAmount(new BigDecimal(t.amount()));
	            trosak.setName(t.name());
	            trosak.setPlan(p);
	            tr.save(trosak);
			}
			
			for (Prihod prihod : plan.prihodi()) {
				model.Prihod p1 = new model.Prihod();
				p1.setAmount(new BigDecimal(prihod.amount()));
				p1.setKorisnik(p.getKorisnik());
				p1.setKorisnikId(p.getKorisnikId());
				p1.setName(prihod.name());
				p1.setPlan(p);
				pir.save(p1);
			}
			return true;
		}
		return false;
	}
	
}
