package com.codelogic.MultiUserAuth.Repository;


import com.codelogic.MultiUserAuth.Model.Plan;


import org.springframework.data.jpa.repository.JpaRepository;


public interface PlanRepository extends JpaRepository<Plan,Integer> {

	Plan getByName(String name);
	Plan findByName(String name);
	
	

}