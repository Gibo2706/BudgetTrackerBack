package pmf.it.app.budgettracker.control;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import pmf.it.app.budgettracker.dto.PlanDTO;
import pmf.it.app.budgettracker.dto.PrihodDTO;
import pmf.it.app.budgettracker.dto.TrosakDTO;
import pmf.it.app.budgettracker.service.PlanService;

@RestController
@RequestMapping("/plan/")
public class PlanController {
	@Autowired
	private PlanService planService;
	
	private static final Logger log = Logger.getLogger(PlanController.class.getName());
	
	@PostMapping("add")
	public ResponseEntity<String> addPlan(@RequestBody PlanDTO plan) {
		System.out.println(plan);
        boolean res =  planService.addPlan(plan);
        log.info("Adding plan - " + plan.toString() );
        if(res) {
        	log.info("Plan added successfully");
			return ResponseEntity.ok("Plan added successfully");
		} else {
			log.error("Plan not added");
			return ResponseEntity.badRequest().body("Plan not added");
        }
	}
	
	@GetMapping("allByUser/{id}")
	public ResponseEntity<List<PlanDTO>> getAllByUser(@PathVariable("id") Long id) {
		List<PlanDTO> plans = planService.findAllByUser(id);
		log.info("Getting all plans for user with id: " + id);
		if(plans.size() == 0) {
			log.error("No plans found");
            return ResponseEntity.badRequest().body(null);
		} else {
			log.info("Plans found - "); 
			plans.forEach(p -> log.info(p.toString()));
			return ResponseEntity.ok(plans);
		}
	}
	
	@PutMapping("addTrosak")
	public ResponseEntity<String> addTrosak(@RequestParam("plan") String plan, @RequestBody TrosakDTO trosak){
		log.info("Adding trosak to plan - " + plan + " - " + trosak.toString());
		boolean res = planService.addTrosak(plan, trosak);
		if(res) {
			log.info("Trosak added successfuly");
			return ResponseEntity.ok("Trosak added successfuly");
		}else {
			log.error("Trosak not added");
			return ResponseEntity.badRequest().body("Trosak not added");
		}
	}
	
	@PutMapping("addPrihod")
	public ResponseEntity<String> addPrihod(@RequestParam("plan") String plan, @RequestBody PrihodDTO prihod){
		log.info("Adding prihod to plan - " + plan + " - " + prihod.toString());
		boolean res = planService.addPrihod(plan, prihod);
		if(res) {
			log.info("Prihod added successfuly");
			return ResponseEntity.ok("Prihod added successfuly");
		}else {
			log.error("Prihod not added");
			return ResponseEntity.badRequest().body("Prihod not added");
		}
	}
	
	@PutMapping("addGoal")
	public ResponseEntity<String> setGoal(@RequestParam("plan") String plan, @RequestParam("goal") Number goal, @RequestParam("timePeriod") long timePeriod){
		log.info("Setting goal for plan - " + plan + " - " + goal + " - " + timePeriod);
		boolean res = planService.addGoal(plan, goal, timePeriod);
		if(res) {
			log.info("Goal is set");
			return ResponseEntity.ok("Goal is set");
		}else {
			log.error("There was an error setting goal");
			return ResponseEntity.badRequest().body("There was an error setting goal");
		}
	}
	
	@PostMapping("deletePrihod")
	public ResponseEntity<String> deletePrihod(@RequestParam("plan") String plan, @RequestBody PrihodDTO prihod){
		log.info("Deleting prihod from plan - " + plan + " - " + prihod.toString());
		boolean res = planService.deletePrihod(plan, prihod);
		if(res) {
			log.info("Prihod removed successfuly");
			return ResponseEntity.ok("Prihod removed successfuly");
		}else {
			log.error("Prihod not removed");
			return ResponseEntity.badRequest().body("Prihod not removed");
		}
	}
	
	@PostMapping("deleteTrosak")
	public ResponseEntity<String> deleteTrosak(@RequestParam("plan") String plan, @RequestBody TrosakDTO trosak){
		log.info("Deleting trosak from plan - " + plan + " - " + trosak.toString());
		boolean res = planService.deleteTrosak(plan, trosak);
		if(res) {
			log.info("Trosak removed successfuly");
			return ResponseEntity.ok("Trosak removed successfuly");
		}else {
			log.error("Trosak not removed");
			return ResponseEntity.badRequest().body("Trosak not removed");
		}
	}
}
