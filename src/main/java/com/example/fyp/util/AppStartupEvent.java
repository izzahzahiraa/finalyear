package com.example.fyp.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.fyp.data.Campaign;
import com.example.fyp.data.CampaignRepository;
import com.example.fyp.data.Donation;
import com.example.fyp.data.DonationRepository;
import com.example.fyp.data.Funder;
import com.example.fyp.data.FunderRepository;
import com.example.fyp.data.Organization;
import com.example.fyp.data.OrganizationRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

	private final OrganizationRepository organizationRepository;
	private final CampaignRepository campaignRepository;
	private final FunderRepository funderRepository;
	private final DonationRepository donationRepository;
	
	
	public AppStartupEvent(OrganizationRepository organizationRepository,
			CampaignRepository campaignRepository,
			FunderRepository funderRepository,
			DonationRepository donationRepository) {
		super();
		this.organizationRepository = organizationRepository;
		this.campaignRepository = campaignRepository;
		this.funderRepository=funderRepository;
		this.donationRepository=donationRepository;
	} 


	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		Iterable<Organization> organizations=this.organizationRepository.findAll();
		organizations.forEach(System.out::println);
		Iterable<Campaign> campaigns=this.campaignRepository.findAll();
		campaigns.forEach(System.out::println);
		Iterable<Funder> funders=this.funderRepository.findAll();
		funders.forEach(System.out::println);
		Iterable<Donation> donations=this.donationRepository.findAll();
		donations.forEach(System.out::println);
		
		
	}

}
