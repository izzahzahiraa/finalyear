package com.example.fyp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.fyp.data.Funder;
import com.example.fyp.data.FunderRepository;

public class FunderServiceImpl implements FunderService {

	@Autowired
	private FunderRepository funderRepository;
	
	@Override
	public List<Funder> getAllFunder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCampaign(Funder funder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funder getFunderById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
