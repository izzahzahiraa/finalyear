package com.example.fyp.business;

import java.util.List;

import com.example.fyp.data.Donation;

public interface DonationService {
	List<Donation>getAllDonation();
	void saveDonation(Donation donation);
	Donation getDonationById(long id);

}
