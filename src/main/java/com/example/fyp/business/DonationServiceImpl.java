package com.example.fyp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.fyp.data.Donation;
import com.example.fyp.data.DonationRepository;
import com.example.fyp.data.Funder;
import com.example.fyp.data.FunderRepository;


public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationRepository donationRepository;
	
	@Autowired
	private FunderRepository funderRepository;
	
	@Override
	public List<Donation> getAllDonation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveDonation(Donation donation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Donation getDonationById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
