package com.codelogic.MultiUserAuth.Controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter{
	@Autowired
	private  UserDetailService UserDetailService ;
	@Autowired
	private jwtUtils jwtutil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requestTokenHeader=request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		String username=null;
		String jwtToken=null;
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken=requestTokenHeader.substring(7);
			try {
			username=jwtutil.extractUsername(jwtToken);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("invalid token1");
		}
		//validation
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userdetails = UserDetailService.loadUserByUsername(username);
			if(jwtutil.validateToken(jwtToken, userdetails))
			{
				//token is valid
				UsernamePasswordAuthenticationToken UsernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
				UsernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(UsernamePasswordAuthenticationToken);
			}
			else {
				System.out.println("token is invalid");
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
