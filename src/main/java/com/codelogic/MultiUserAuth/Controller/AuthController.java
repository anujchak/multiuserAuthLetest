package com.codelogic.MultiUserAuth.Controller;

import com.codelogic.MultiUserAuth.Model.User;
import com.codelogic.MultiUserAuth.Service.AuthService;

import java.util.List;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager AuthenticationManager ;
    @Autowired
    private UserDetailService UserDetailService ;
    @Autowired
    private jwtUtils jwtUtils ;

    @PostMapping("/register")
    public User Register(@RequestBody User user) {
       //String result=authService.register(user);
    	//this create a method in authservice
        return  authService.register(user);


    }
    @RequestMapping("/getAll")
    public List<User> getUser(){
    	return UserDetailService.getall();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
      boolean f;
        try {
        	f=authenticate(user.getUsername(),user.getPassword());
        }
        catch(Exception e){
        	f=false;
        	System.out.println("bad cred1");
        	e.printStackTrace();
        }
    	
    	//if successfull login it send the token
        if(f) {
         UserDetails UserDetails = UserDetailService.loadUserByUsername(user.getUsername());
         String token = jwtUtils.generateToken(UserDetails);
        return token;
        }
        else {
        	return "User id or Password incorrect";
        }
    }
    public boolean authenticate(String username,String password)
    { 
    	boolean f=true;
    	     
    	try {
    		AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    	     }
    	
    	catch(BadCredentialsException e) {
    		System.out.println("bad cred");
    		f=false;
    	}
    	return f;
    }
    

}
