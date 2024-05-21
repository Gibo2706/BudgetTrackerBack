package pmf.it.app.budgettracker.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import pmf.it.app.budgettracker.dto.PlanDTO;
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
	
}
