package com.codelogic.MultiUserAuth.Controller;


import com.codelogic.MultiUserAuth.Model.Plan;
import com.codelogic.MultiUserAuth.Service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
 
@RequestMapping("/plan")
//@CrossOrigin(origins = "http://localhost:4200")
public class PlanController {

    @Autowired
    private PlanService planService;

    //when ever add new hospital
    @PostMapping("/addPlan")
    public Plan addPlan(@RequestBody Plan plan)
    {
        return planService.addPlan(plan);
    }

    //more than 1 hospital
        @PostMapping("/addPlans")
        public List<Plan> addAllPlans(@RequestBody List<Plan> plans)
        {
            return planService.addAllPlans(plans);
        }
        //get plan by hospital name

        @GetMapping("/getPlanByName/{name}")
        public Plan getPlanByName(@PathVariable String name)
        {
            return planService.getPlanByName(name);
        }

         // Update hospital
        @PutMapping("/updatePlan")
        public Plan updatePlan(@RequestBody Plan plan) {
            return planService.updatePlan(plan);
        }
     // Delete plan
        @DeleteMapping("/deletePlanById/{id}")
        public boolean deletePlanByID(@PathVariable int id) {
            return planService.deletePlanByID(id);
        }
     // Get all hospital
        @GetMapping("/getAll")
        public List<Plan> getAllPlan() {
            return planService.getAllPlans();
        }

 
}
