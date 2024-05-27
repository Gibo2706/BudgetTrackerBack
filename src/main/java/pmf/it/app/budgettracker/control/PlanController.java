package pmf.it.app.budgettracker.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@PostMapping("add")
	public ResponseEntity<String> addPlan(@RequestBody PlanDTO plan) {
		System.out.println(plan);
        boolean res =  planService.addPlan(plan);
        
        if(res) {
			return ResponseEntity.ok("Plan added successfully");
		} else {
			return ResponseEntity.badRequest().body("Plan not added");
        }
	}
	
	@GetMapping("allByUser/{id}")
	public ResponseEntity<List<PlanDTO>> getAllByUser(@PathVariable("id") Long id) {
		List<PlanDTO> plans = planService.findAllByUser(id);
		if(plans.size() == 0) {
            return ResponseEntity.badRequest().body(null);
		} else {
			return ResponseEntity.ok(plans);
		}
	}
	
	@PutMapping("addTrosak")
	public ResponseEntity<String> addTrosak(@RequestParam("plan") String plan, @RequestBody TrosakDTO trosak){
		boolean res = planService.addTrosak(plan, trosak);
		if(res) {
			return ResponseEntity.ok("Trosak added successfuly");
		}else {
			return ResponseEntity.badRequest().body("Trosak not added");
		}
	}
	
	@PutMapping("addPrihod")
	public ResponseEntity<String> addPrihod(@RequestParam("plan") String plan, @RequestBody PrihodDTO prihod){
		boolean res = planService.addPrihod(plan, prihod);
		if(res) {
			return ResponseEntity.ok("Prihod added successfuly");
		}else {
			return ResponseEntity.badRequest().body("Prihod not added");
		}
	}
	
	@DeleteMapping("deletePrihod")
	public ResponseEntity<String> deletePrihod(@RequestParam("plan") String plan, @RequestBody PrihodDTO prihod){
		boolean res = planService.deletePrihod(plan, prihod);
		if(res) {
			return ResponseEntity.ok("Prihod removed successfuly");
		}else {
			return ResponseEntity.badRequest().body("Prihod not removed");
		}
	}
	
	@DeleteMapping("deleteTrosak")
	public ResponseEntity<String> deleteTrosak(@RequestParam("plan") String plan, @RequestBody TrosakDTO trosak){
		boolean res = planService.deleteTrosak(plan, trosak);
		if(res) {
			return ResponseEntity.ok("Trosak removed successfuly");
		}else {
			return ResponseEntity.badRequest().body("Trosak not removed");
		}
	}
}
