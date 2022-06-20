package com.example.fyp.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Donation")

public class Donation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="donation_id")
	private long id;
	
	@Column(name="donation_type")
	private String donationtype;
	
	@Column(name="accnumber")
	private String accnumber;
	
	@Column(name="donation_amount")
	private double donationamount;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funder_id")
    private Funder funder;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDonationtype() {
		return donationtype;
	}

	public void setDonationtype(String donationtype) {
		this.donationtype = donationtype;
	}

	
	public String getAccnumber() {
		return accnumber;
	}

	public void setAccnumber(String accnumber) {
		this.accnumber = accnumber;
	}

	public double getDonationamount() {
		return donationamount;
	}

	public void setDonationamount(double d) {
		this.donationamount = d;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Funder getFunder() {
		return funder;
	}

	public void setFunder(Funder funder) {
		this.funder = funder;
	}
	
	
	
	

}
