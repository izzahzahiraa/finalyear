package com.example.fyp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fyp.data.Donation;
import com.example.fyp.data.DonationRepository;
import com.example.fyp.data.Funder;
import com.example.fyp.data.FunderRepository;

@Service
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
		this.donationRepository.save(donation);
		
	}

	@Override
	public Donation getDonationById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
