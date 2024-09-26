package com.codelogic.MultiUserAuth.Repository;

import com.codelogic.MultiUserAuth.Model.Hospital;
import com.codelogic.MultiUserAuth.Model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,String> { 
	User getByName(String name);
	 User findByName(String name);
}
