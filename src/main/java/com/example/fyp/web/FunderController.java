package com.example.fyp.web;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.fyp.business.CampaignService;
import com.example.fyp.business.OrganizationService;
import com.example.fyp.data.Campaign;
import com.example.fyp.data.Funder;
import com.example.fyp.data.Organization;



@Controller
public class FunderController {
	
	@Autowired
	private CampaignService campaignService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping("/")
	public String viewHomePage (Model model) {
		model.addAttribute("listOrganizations",organizationService.getAllOrganization() );
		return "funder/index";
	}
	
		@GetMapping("/showFunderForm")
		//show funder form
		public String showFunderForm(Model model) {
			//create model attribute to bind form data
			Organization organization=new Organization();
			Funder funder=new Funder();
			model.addAttribute("funder", funder);
			return "funder/funder_details";
		}
		
	//display list of organization created
		@GetMapping("/allOrganizations")
		public String allOrganizations (Model model) {
			model.addAttribute("allOrganizations",organizationService.getAllOrganization() );
			return "funder/all_organizations";
			}
		
	//display list of campaigns organized
	@GetMapping("/listCampaigns")
	public String listCampaigns(Model model) {
		
		List<Campaign> campaigns = campaignService.getAllCampaign();
		
		List<Campaign> campaignDahFilter = new ArrayList<>();
		
		for(Campaign campaign : campaigns) {
			if (campaign.isEnabled()&& campaign.getStatus().equals("approved")) {
				campaignDahFilter.add(campaign);
			}
		}
		
		model.addAttribute("listCampaigns", campaignDahFilter);
		return "funder/all_campaigns";	
	}
	
	//display details campaign
	@GetMapping("/detailsCampaign/{id}")
	public String detailsCampaign(@PathVariable(value="id") long id, Model model) {
		
		//get organization from the service
		Campaign campaign=campaignService.getCampaignById(id);
		
		//set an organization as a model attribute to pre-populate the form
		model.addAttribute("campaign", campaign);
		return "funder/each_campaign";
		
	}


}