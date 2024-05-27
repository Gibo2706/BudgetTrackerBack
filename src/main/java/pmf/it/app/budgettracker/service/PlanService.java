package pmf.it.app.budgettracker.service;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Plan;
import model.Korisnik;
import model.Prihod;
import model.Trosak;
import pmf.it.app.budgettracker.dto.PlanDTO;
import pmf.it.app.budgettracker.dto.PrihodDTO;
import pmf.it.app.budgettracker.dto.TrosakDTO;
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
	
	public boolean addPlan(PlanDTO plan) {
		Plan p = new Plan();
		Korisnik korisnik = kr.findByUsername(plan.korisnik().username());
		p.setKorisnik(korisnik);
		p.setKorisnikId(korisnik.getId());
		p.setName(plan.name());
		p.setGoal(new BigDecimal(plan.cilj().toString()));
		p.setTimePeriod(plan.timePeriod());
		p = pr.save(p);
		
		if (p != null) {
			for(TrosakDTO t : plan.troskovi()) {
				Trosak trosak = new Trosak();
	            trosak.setAmount(new BigDecimal(t.amount()));
	            trosak.setName(t.name());
	            trosak.setIsimpulse(t.isImpulse());
	            trosak.setPlanId(p.getId());
	            trosak.setPlan(p);
	            tr.save(trosak);
			}
			
			for (PrihodDTO prihod : plan.prihodi()) {
				Prihod p1 = new Prihod();
				p1.setAmount(new BigDecimal(prihod.amount()));
				p1.setKorisnik(p.getKorisnik());
				p1.setKorisnikId(p.getKorisnikId());
				p1.setName(prihod.name());
				p1.setPlanId(p.getId());
				p1.setPlan(p);
				pir.save(p1);
			}
			return true;
		}
		return false;
	}
	
	public List<PlanDTO> findAllByUser(Long id) {
		List<Plan> plans = pr.findAllByKorisnikId(id);
		return PlanDTO.fromEntityList(plans);
	}
	
	public boolean addGoal(String plan, Number goal, Long timePeriod) {
		Plan p = pr.findByName(plan);
		if(p == null) return false;
		p.setGoal(new BigDecimal(goal.toString()));
		p.setTimePeriod(timePeriod);
		try {
			pr.saveAndFlush(p);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean addTrosak(String plan, TrosakDTO t) {
		Plan p = pr.findByName(plan);
		if(p == null) return false;
		Trosak trosak = new Trosak();
        trosak.setAmount(new BigDecimal(t.amount()));
        trosak.setName(t.name());
        trosak.setIsimpulse(t.isImpulse());
        trosak.setPlanId(p.getId());
        trosak.setPlan(p);
        try {
        	tr.save(trosak);
    		return true;
        }catch(Exception e) {
        	return false;
        }
        
	}
	
	public boolean addPrihod(String plan, PrihodDTO prihod) {
		Plan p = pr.findByName(plan);
		if(p == null) return false;
		Prihod p1 = new Prihod();
		p1.setAmount(new BigDecimal(prihod.amount()));
		p1.setKorisnik(p.getKorisnik());
		p1.setKorisnikId(p.getKorisnikId());
		p1.setName(prihod.name());
		p1.setPlanId(p.getId());
		p1.setPlan(p);
		try {
			pir.save(p1);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean deleteTrosak(String plan, TrosakDTO t) {
		Plan p = pr.findByName(plan);
		if(p == null) return false;
		Trosak trosak = tr.findByNameAndPlanId(t.name(), p.getId());
		if(trosak == null) return false;
		try {
			tr.deleteById(trosak.getId());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean deletePrihod(String plan, PrihodDTO prih) {
		Plan p = pr.findByName(plan);
		if(p == null) return false;
		Prihod prihod = pir.findByNameAndPlanId(prih.name(), p.getId());
		if(prihod == null) return false;
		try {
			pir.deleteById(prihod.getId());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
