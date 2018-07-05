package com.hyringspree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "recruiter")
public class Recruiter implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECRUITER_ID")
	private Integer recruiterId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
    
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "CONFIRM_PASSWORD")
	private String confirmPassword;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "STATE")
	private String state;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ZIP")
	private String zip;

	@Column(name = "ADDRESS_LINE1")   
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	@Column(name = "RECRUITER_CREATED_DATE") 
	private String recruiterCreatedDate;  

	@Column(name = "RECRUITER_UPDATED_DATE")
    private String recruiterUpdatedDate; 
	
	
	@Transient
	@Column(name="From_Date")
	private String fromDate;
	
	@Transient
	@Column(name="TO_Date")
	private String toDate;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Company.class)
//	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")
//	private Company parent;

	

	
	public String getFirstName() {
		return firstName;
	}

	public Integer getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(Integer recruiterId) {
		this.recruiterId = recruiterId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getRecruiterCreatedDate() {
		return recruiterCreatedDate;
	}

	public void setRecruiterCreatedDate(String recruiterCreatedDate) {
		this.recruiterCreatedDate = recruiterCreatedDate;
	}

	public String getRecruiterUpdatedDate() {
		return recruiterUpdatedDate;
	}

	public void setRecruiterUpdatedDate(String recruiterUpdatedDate) {
		this.recruiterUpdatedDate = recruiterUpdatedDate;
	}

//	public Company getParent() {
//		return parent;
//	}
//
//	public void setParent(Company parent) {
//		this.parent = parent;
//	}

	
}
