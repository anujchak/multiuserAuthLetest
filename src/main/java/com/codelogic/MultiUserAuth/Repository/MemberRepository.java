package com.codelogic.MultiUserAuth.Repository;


import com.codelogic.MultiUserAuth.Model.Member;


import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member,Integer> {

	Member getByName(String name);
	Member findByName(String name);
	
	

}

