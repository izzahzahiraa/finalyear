package com.example.fyp.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.fyp.business.CampaignService;
import com.example.fyp.business.OrganizationService;
import com.example.fyp.data.Campaign;
import com.example.fyp.data.Organization;
import com.example.fyp.data.OrganizationDetails;

@Controller
@RequestMapping("/organization")
public class CreatorController {
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private CampaignService campaignService;
	
	@Autowired
	UserDetailsService userDetailsService;

	//display details of organization
	 
		@GetMapping("/organizationDetails")
			public String organizationDetails(@AuthenticationPrincipal OrganizationDetails organizationLog,Model model) {
			
			Organization organization = organizationService.getOrganizationByEmail(organizationLog.getUsername());
			//get organization from the service
				//Organization organization=organizationService.getOrganizationById(id);
				
			//set an organization as a model attribute to pre-populate the form
				model.addAttribute("organization", organization);
				return "organization/detail_organization";
				
			}
			
	//update organization tapi ni creator punya kerja ni 
		@GetMapping("/showFormForUpdate/{id}")
		public String showFormForUpdate(@AuthenticationPrincipal OrganizationDetails organizationLog,Model model) {
				
		//get campaign from the service
		//Organization organization=organizationService.getOrganizationById(id);
		Organization organization = organizationService.getOrganizationByEmail(organizationLog.getUsername());
			
		//set an campaign as a model attribute to pre-populate the form
		model.addAttribute("organization", organization);
		return "organization/update_organization";
		
		}
	
		//save organization into db 
		@PostMapping("/saveOrganization")
		public String saveOrganization( @ModelAttribute("organization") Organization organization) {
			
			//save organization into db
			organizationService.saveOrganization(organization);
			
					return "redirect:/organization/organizationDetails";
				}
		
		
	//show registration form of campaign
		@GetMapping("/showNewCampaignForm")
		public String showNewCampaignForm(Model model) {	
	//create model attribute to bind form data
		Campaign campaign=new Campaign();
		model.addAttribute("campaign", campaign);
		return "organization/create_campaign";
		
		}
		
	//save campaign into db 
		@PostMapping("/saveCampaign")
		public String saveCampaign(@AuthenticationPrincipal OrganizationDetails organizationLog, @ModelAttribute("campaign") Campaign campaign,
				@RequestParam("fileImage")MultipartFile multipartFile) throws IOException {
			
			Organization organization = organizationService.getOrganizationByEmail(organizationLog.getUsername());
			campaign.setOrganization(organization);
	
			// normalize the file path
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        campaign.setImage(fileName);
	        
			//save campaign into db
			Campaign savedCampaign= campaignService.saveCampaign(campaign);
			
			String uploadDir="./campaign-image/" + savedCampaign.getId();
		
			Path uploadPath= Paths.get(uploadDir);
			
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			
			try (InputStream inputStream=multipartFile.getInputStream()){
			Path filePath=uploadPath.resolve(fileName);
			System.out.println(filePath.toFile().getAbsolutePath());
			Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);  
			
			} catch (IOException e) {
				throw new IOException("Could not save uploaded file:" + fileName);
			}
			
			return "redirect:/organization/listCampaigns";
		}
		
	
		//display pending campaign
			@GetMapping("/listPending")
			public String listPending(@AuthenticationPrincipal OrganizationDetails organizationLog, Model model) {
					
								
				List<Campaign> campaigns = campaignService.getAllCampaign();
				List<Campaign> campaignFilter = new ArrayList<>();
					
				for(Campaign campaign : campaigns) {					
					if (!campaign.isEnabled() && campaign.getOrganization().getEmail().equals(organizationLog.getUsername()) ) {
						campaignFilter.add(campaign);
					}
				}
				model.addAttribute("listCampaigns", campaignFilter);
				return "organization/pending_campaign";	
				}
		
			//display list campaign organized by organization
			
			@GetMapping("/listCampaigns")
			public String listCampaigns(@AuthenticationPrincipal OrganizationDetails organizationLog,Model model) {
				List<Campaign> campaigns = campaignService.getAllCampaign();
				List<Campaign> campaignOrganization = new ArrayList<>();
				
				for(Campaign campaign : campaigns) {					
					if ( campaign.getOrganization().getEmail().equals(organizationLog.getUsername()) ) {
						campaignOrganization.add(campaign);
					}
				}
				model.addAttribute("listCampaigns", campaignOrganization);
				return "organization/campaign_all";	
				}
				
			
			//display details campaign
			@GetMapping("/detailsCampaign/{id}")
			public String detailsCampaign(@PathVariable(value="id") long id, Model model) {
				
				//get organization from the service
				Campaign campaign=campaignService.getCampaignById(id);
				
				//set an organization as a model attribute to pre-populate the form
				model.addAttribute("campaign", campaign);
				return "organization/detail_campaign";
				
			}
			
			//update campaign into db 
				@GetMapping("/showCampaignForUpdate/{id}")
				public String showCampaignForUpdate(@PathVariable (value="id")long id,Model model) {
						
				//get campaign from the service
				Campaign campaign=campaignService.getCampaignById(id);
							
				//set an campaign as a model attribute to pre-populate the form
				model.addAttribute("campaign", campaign);
				return "organization/update_campaign";
				
			}
			
			//delete campaign
				@GetMapping("/deleteCampaign/{id}")
				public String deleteCampaign(@PathVariable (value="id")long id,Model model) {
					
					//call delete employee method
					this.campaignService.deleteCampaignById(id);
					return "redirect:/organization/listCampaigns";
				}
	
	
		
	
}
