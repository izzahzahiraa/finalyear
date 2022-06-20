package com.example.fyp.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Organization")

public class Organization {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="organization_id")
	private long id;
	
	@Column(name="organization_name")
	private String name;
	
	@Column(name="organization_address")
	private String address;
	
	@Column(name="state")
	private String state;
	
	@Column(name="organization_email")
	private String email;
	
	@Column(name="organization_pass")
	private String password;
	
	@Column(name="organization_role")
	private String role="ROLE_creator";
	
	@Column(name="organization_enabled")
	private boolean enabled = true;
	
	@Column(name="admin_id")
	private long admin_id = 1;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy= "organization")
	private List<Campaign> campaigns;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}
	
	
	
	
	
}
