package com.example.fyp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fyp.business.CampaignService;
import com.example.fyp.business.OrganizationService;
import com.example.fyp.data.Campaign;
import com.example.fyp.data.Organization;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private CampaignService campaignService;
	

	//display main page admin
	@GetMapping("/mainPage")
	public String mainPage(Model model) {
		model.addAttribute("listOrganizations",organizationService.getAllOrganization() );
		return "admin/main";
		
	}

	
	//display list of organization created
	@GetMapping("/listOrganizations")
	public String listOrganizations (Model model) {
		model.addAttribute("listOrganizations",organizationService.getAllOrganization() );
		return "admin/list_organizations";
		
	}
	//show registration form of organization
	@GetMapping("/showNewOrganizationForm")
	public String showNewOrganizationForm(Model model) {
		
		//create model attribute to bind form data
		Organization organization=new Organization();
		model.addAttribute("organization", organization);
		return "admin/register_organization";
	}

	//save new organization into db
	@PostMapping("/saveOrganization")
	public String saveOrganization( @ModelAttribute("organization") Organization organization) {
		
		//save organization into db
		organizationService.saveOrganization(organization);
		return "redirect:/admin/listOrganizations";
	}
	
	//display details of organization
		 
		@GetMapping("/organizationDetails/{id}")
		public String organizationDetails(@PathVariable(value="id") long id, Model model) {
			
			//get organization from the service
			Organization organization=organizationService.getOrganizationById(id);
			
			//set an organization as a model attribute to pre-populate the form
			model.addAttribute("organization", organization);
			return "admin/organization_details";
			
		}
	
	//display list of campaigns organized
		@GetMapping("/listCampaigns")
		public String listCampaigns(Model model) {
			
			//List<Campaign> campaigns = campaignService.getAllCampaign();
			model.addAttribute("listCampaigns",campaignService.getAllCampaign() );
			return "admin/list_campaigns";
			/*List<Campaign> campaignDahFilter = new ArrayList<>();
			
			for(Campaign campaign : campaigns) {
				if (campaign.isEnabled()) {
					campaignDahFilter.add(campaign);
				}
			}
			
			model.addAttribute("listCampaigns", campaignDahFilter);
			return "admin/list_campaigns";*/	
		}
		
		//display pending campaign
		@GetMapping("/listPending")
		public String listPending(Model model) {
			
			List<Campaign> campaigns = campaignService.getAllCampaign();
			List<Campaign> campaignFilter = new ArrayList<>();
			
			for(Campaign campaign : campaigns) {
				if (!campaign.isEnabled()) {
					campaignFilter.add(campaign);
				}
			}
			model.addAttribute("listCampaigns", campaignFilter);
			return "admin/list_pending";	
		}
		
	//update pending campaigns
	
		@GetMapping("/updatePending/{id}")
		public String updatePending(@PathVariable (value="id")long id,Model model) {
		
			//get organization from the service
			Campaign campaign=campaignService.getCampaignById(id);
			
			//set an organization as a model attribute to pre-populate the form
			model.addAttribute("campaign", campaign);
			return "admin/update_pending";
		
		} 
		
	//display details of campaigns
		
		@GetMapping("/campaignDetails/{id}")
		public String campaignDetails(@PathVariable(value="id") long id, Model model) {
			
			//get organization from the service
			Campaign campaign=campaignService.getCampaignById(id);
			
			//set an organization as a model attribute to pre-populate the form
			model.addAttribute("campaign", campaign);
			return "admin/campaign_details";
			
		}
		
		//save /update new campaign into db
		@PostMapping("/saveCampaign")
		public String saveCampaign( @ModelAttribute("campaign") Campaign campaign) {
			
			//save organization into db
			campaignService.saveCampaign(campaign);
			return "redirect:/admin/listPending";
		}
		
}
