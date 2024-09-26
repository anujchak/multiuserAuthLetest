package com.codelogic.MultiUserAuth.Repository;

import com.codelogic.MultiUserAuth.Model.Test;


import org.springframework.data.jpa.repository.JpaRepository;


public interface TestRepository extends JpaRepository<Test,Integer> {

	Test getByName(String name);
	Test findByName(String name);
	

}