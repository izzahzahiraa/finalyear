package com.example.fyp.business;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fyp.data.Organization;
import com.example.fyp.data.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public List<Organization> getAllOrganization() {
		// TODO Auto-generated method stub
		return organizationRepository.findAll() ;
	
	}

	@Override
	public void saveOrganization(Organization organization) {
		// TODO Auto-generated method stub
		this.organizationRepository.save(organization);
		
	}

	@Override
	public Organization getOrganizationById(long id) {
		// TODO Auto-generated method stub
		Optional<Organization> optional= organizationRepository.findById(id);
		Organization organization=null;
		if(optional.isPresent()) {
			organization=optional.get();
		}else {
			throw new RuntimeException("The ID of the organization is not exist");
		}
		return organization;
	}

	@Override
	public Organization getOrganizationByEmail(String email) {
		Optional<Organization> organization = organizationRepository.findByEmail(email);
		
		if(organization.isPresent()) {
			return organization.get();
		}else {
			throw new RuntimeException("The ID of the organization is not exist");
		}
	}
}
