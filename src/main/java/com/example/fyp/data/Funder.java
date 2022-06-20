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
@Table(name="Funder")

public class Funder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="funder_id")
	private long id;
	
	@Column(name="funder_name")
	private String name;
	
	@Column(name="funder_email")
	private String email;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy= "funder")
	private List<Donation> donations;

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

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}
	
	
}
