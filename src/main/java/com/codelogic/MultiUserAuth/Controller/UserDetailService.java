package com.codelogic.MultiUserAuth.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codelogic.MultiUserAuth.Model.User;
import com.codelogic.MultiUserAuth.Repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User existingUser = userRepository.findById(username).orElse(null);
		if(existingUser==null)
		{
			System.out.println("null user");
		}
		return (UserDetails) existingUser;
	}
	public List<User> getall() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	

}
