package com.example.fyp.business;

import java.util.List;

import com.example.fyp.data.Campaign;

public interface CampaignService {
	List<Campaign>getAllCampaign();
	void saveCampaign(Campaign campaign);
	Campaign getCampaignById(long id);
	void deleteCampaignById(long id);

}
