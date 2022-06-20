package com.example.fyp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService);
		
	/*Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
	if(principal instanceof UserDetails) {
	 String username=((UserDetails)principal).getUsername();
	}else {
		String username=principal.toString();
	}*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
				
				//request semua admin function
				.antMatchers("/admin/*").hasRole("admin")
				
				//request semua organization function
				.antMatchers("/organization/*").hasAnyRole("admin","creator")
				.antMatchers("/").permitAll()
				
				//allow form log in(?)
				.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() { 
		return NoOpPasswordEncoder.getInstance();
	}
}
