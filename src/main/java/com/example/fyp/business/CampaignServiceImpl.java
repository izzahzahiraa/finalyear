package com.example.fyp.business;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fyp.data.Campaign;
import com.example.fyp.data.CampaignRepository;

@Service
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;
	
	
	@Override
	public List<Campaign> getAllCampaign() {
		// TODO Auto-generated method stub
		return campaignRepository.findAll();
	}

	@Override
	public void saveCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		this.campaignRepository.save(campaign);
		
	}

	@Override
	public Campaign getCampaignById(long id) {
		// TODO Auto-generated method stub
		Optional<Campaign> optional=campaignRepository.findById(id);
		Campaign campaign=null;
		if(optional.isPresent()) {
			campaign=optional.get();
		}else {
			throw new RuntimeException("The Campaign may / has been removed by the organizer");
		}
		return campaign;
	}

	@Override
	public void deleteCampaignById(long id) {
		this.campaignRepository.deleteById(id);
		
	}

	
}

