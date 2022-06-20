package com.example.fyp.business;

import java.util.List;

import com.example.fyp.data.Organization;

public interface OrganizationService {
	List<Organization> getAllOrganization();
	void saveOrganization(Organization organization);
	Organization getOrganizationById(long id); 
	Organization getOrganizationByEmail(String email);
}
