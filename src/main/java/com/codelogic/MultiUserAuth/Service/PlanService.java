package com.codelogic.MultiUserAuth.Service;

import com.codelogic.MultiUserAuth.Model.Plan;
import com.codelogic.MultiUserAuth.Repository.PlanRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.logging.Logger;
 
@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;
 
    public Plan addPlan(Plan plan) {
        return planRepository.save(plan);
    }
 
    public List<Plan> addAllPlans(List<Plan> plans) {
        return  planRepository.saveAll(plans);
    }
    public Plan getPlanByID(int id) {
         return planRepository.findById(id).orElse(null);
     }
    public Plan getPlanByName(String name) {
        return planRepository.findByName(name);
    }


    public Plan updatePlan(Plan plan)
    {
    	Plan existingPLA = planRepository.findById(plan.getId()).orElse(null);
        System.out.println(plan);
        if(existingPLA == null) {
            System.out.println("Plan not found");
            return  planRepository.save(plan);
        }else  {

         
            existingPLA.setName(plan.getName());
            existingPLA.setPdescription(plan.getPdescription());
          
            planRepository.save(existingPLA);
        }
        return plan;
    }
    public boolean deletePlanByID(int id) {
        Plan existingPLA = planRepository.getById(id);
        if(existingPLA != null) {
            planRepository.deleteById(id);
            return true;
        }
        return false;
    }
 
    public List<Plan>getAllPlans()
    {
        return planRepository.findAll();
    }
 
}