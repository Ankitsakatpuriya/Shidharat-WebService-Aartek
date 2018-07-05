package com.hyringspree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "PROFILE_ID", unique = true)
	private String profileId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "PROFILE_CREATED_DATE")
	private String profileCreatedDate;

	@Column(name = "PROFILE_UPDATED_DATE")
	private String profileUpdatedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfileCreatedDate() {
		return profileCreatedDate;
	}

	public void setProfileCreatedDate(String profileCreatedDate) {
		this.profileCreatedDate = profileCreatedDate;
	}

	public String getProfileUpdatedDate() {
		return profileUpdatedDate;
	}

	public void setProfileUpdatedDate(String profileUpdatedDate) {
		this.profileUpdatedDate = profileUpdatedDate;
	}

}
