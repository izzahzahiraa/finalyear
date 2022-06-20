package com.example.fyp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.fyp.data.Organization;
import com.example.fyp.data.OrganizationDetails;
import com.example.fyp.data.OrganizationRepository;

@Service
public class MyOrganizationDetailsService implements UserDetailsService {


	@Autowired
	OrganizationRepository organizationRepository;
	
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		
		Optional<Organization> organization= organizationRepository.findByEmail(email);
		
		organization.orElseThrow(() -> new UsernameNotFoundException("Not found:"+ email));
		return organization.map(OrganizationDetails::new).get();
	}
}
