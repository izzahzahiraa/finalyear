package com.example.fyp.data;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name="Campaign")

public class Campaign {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="campaign_id")
	private long id;
	
	@Lob
	@Column(name="campaign_pic")
	private String image=null;
	
	@Column(name="campaign_title")
	private String title;
	
	@Column(name="campaign_desc")
	private String description;
	
	@Column(name="campaign_goal")
	private int goal;
	
	@Column(name="date_start")
	private Date datestart;
	
	@Column(name="date_end")
	private Date dateend;
	
	@Column(name="campaign_status")
	private String status="pending";
	
	@Column(name="campaign_enabled")
	private boolean enabled=false;
	
	@Column(name="campaign_outcome")
	private String outcome=null;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy= "campaign")
	private List<Donation> donations;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public Date getDatestart() {
		return datestart;
	}

	public void setDatestart(Date datestart) {
		this.datestart = datestart;
	}

	public Date getDateend() {
		return dateend;
	}

	public void setDateend(Date dateend) {
		this.dateend = dateend;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}
	
	@Transient
	public String getCampaignImagePath() {
		if(image==null || id == 0L) return null;
		
		return "/campaign-image/" + id + "/" + image;
	}
	
	
	
	

}
