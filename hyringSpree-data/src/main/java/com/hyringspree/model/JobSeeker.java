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
@Table(name = "jobseeker")
public class JobSeeker implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOBSEEKER_ID")
	private Integer id;

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

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	/* PROFILE */
	@Column(name = "Designation")
	private String designation;

	@Column(name = "Experience")
	private String experience;

	@Column(name = "Description")
	private String description;

	@Column(name = "STATE")
	private String state;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ZIP")
	private String zip;

	/* Experience */
	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "JOB_ROLE")
	private String jobRole;

	@Column(name = "JOINING_DATE")
	private String joiningDate;

	@Column(name = "RELIEVING_DATE")
	private String relievingDate;

	@Column(name = "DESCRIPTION_EXPERIENCE")
	private String descriptionExperience;

	/* Education */
	@Column(name = "COURSE_NAME")
	private String courseName;

	@Column(name = "INSTITUTION_NAME")
	private String institutionName;

	@Column(name = "COURSE_COMPLETED")
	private String courseCompleted;

	@Column(name = "EDUCATION_LOCATION")
	private String educationLocation;

	/* Certification */
	@Column(name = "CERTIFICATION_NAME")
	private String certificationName;

	@Column(name = "CERTIFID_ON")
	private String certifidOn;

	@Column(name = "ISSUED_BY")
	private String issuedBy;

	/* Memberships */
	@Column(name = "MEMBERSHIP_TITLE")
	private String membershipTitle;

	@Column(name = "MEMBERSHIP_DESCRIPTION")
	private String membershipDescription;

	@Column(name = "MEMBER_SINCE")
	private String memberSince;

	/* Patents */
	@Column(name = "PATENTS_TITLE")
	private String patentsTitle;

	@Column(name = "PATENTS_DESCRIPTION")
	private String patentsDescription;

	@Column(name = "ISSUED_ON")
	private String issuedOn;

	@Column(name = "COUNTRY")
	private String country;

	/* Publications */
	@Column(name = "PUBLICATION_TITLE")
	private String publicationTitle;

	@Column(name = "PUBLICATIONS_DESCRIPTION")
	private String publicationsDescription;

	@Column(name = "DATE")
	private String date;

	@Column(name = "PUBLISHER_NAME")
	private String publisherName;

	@Transient
	private String fromDate;

	@Transient
	private String toDate;

	public String getCompanyName() {
		return companyName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

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

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getCourseCompleted() {
		return courseCompleted;
	}

	public void setCourseCompleted(String courseCompleted) {
		this.courseCompleted = courseCompleted;
	}

	public String getEducationLocation() {
		return educationLocation;
	}

	public void setEducationLocation(String educationLocation) {
		this.educationLocation = educationLocation;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public String getCertifidOn() {
		return certifidOn;
	}

	public void setCertifidOn(String certifidOn) {
		this.certifidOn = certifidOn;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public String getMembershipTitle() {
		return membershipTitle;
	}

	public void setMembershipTitle(String membershipTitle) {
		this.membershipTitle = membershipTitle;
	}

	public String getMembershipDescription() {
		return membershipDescription;
	}

	public void setMembershipDescription(String membershipDescription) {
		this.membershipDescription = membershipDescription;
	}

	public String getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}

	public String getPatentsTitle() {
		return patentsTitle;
	}

	public void setPatentsTitle(String patentsTitle) {
		this.patentsTitle = patentsTitle;
	}

	public String getPatentsDescription() {
		return patentsDescription;
	}

	public void setPatentsDescription(String patentsDescription) {
		this.patentsDescription = patentsDescription;
	}

	public String getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(String issuedOn) {
		this.issuedOn = issuedOn;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPublicationTitle() {
		return publicationTitle;
	}

	public void setPublicationTitle(String publicationTitle) {
		this.publicationTitle = publicationTitle;
	}

	public String getPublicationsDescription() {
		return publicationsDescription;
	}

	public void setPublicationsDescription(String publicationsDescription) {
		this.publicationsDescription = publicationsDescription;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getRelievingDate() {
		return relievingDate;
	}

	public void setRelievingDate(String relievingDate) {
		this.relievingDate = relievingDate;
	}

	public String getDescriptionExperience() {
		return descriptionExperience;
	}

	public void setDescriptionExperience(String descriptionExperience) {
		this.descriptionExperience = descriptionExperience;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getFirstName() {
		return firstName;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

}