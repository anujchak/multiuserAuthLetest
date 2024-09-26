package com.codelogic.MultiUserAuth.Repository;

import com.codelogic.MultiUserAuth.Model.Hospital;


import org.springframework.data.jpa.repository.JpaRepository;


public interface HospitalRepository extends JpaRepository<Hospital,Integer> {

	Hospital getByName(String name);
	Hospital findByName(String name);
	

}