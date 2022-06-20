package com.example.fyp.business;

import java.util.List;

import com.example.fyp.data.Funder;

public interface FunderService {
	List<Funder>getAllFunder();
	void saveCampaign(Funder funder);
	Funder getFunderById(long id);

}
