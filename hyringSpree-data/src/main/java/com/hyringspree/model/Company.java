package com.hyringspree.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "COMPANY_ID")
	private String companyId;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "COMPANY_CREATED_DATE")
	private String companyCreatedDate;

	@Column(name = "COMPANY_UPDATED_DATE")
	private String companyUpdatedDate;
	
/*	 @OneToMany(fetch=FetchType.LAZY, targetEntity=JobInfo.class, cascade=CascadeType.ALL)
	 @JoinColumn(name = "COMPANY_ID", referencedColumnName="COMPANY_ID")
    private Set children;
	 
	 
/*	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompanyCreatedDate() {
		return companyCreatedDate;
	}

	public void setCompanyCreatedDate(String companyCreatedDate) {
		this.companyCreatedDate = companyCreatedDate;
	}

	public String getCompanyUpdatedDate() {
		return companyUpdatedDate;
	}

	public void setCompanyUpdatedDate(String companyUpdatedDate) {
		this.companyUpdatedDate = companyUpdatedDate;
	}
	

}
