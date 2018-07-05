package com.hyringspree.model;

import java.awt.TextArea;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "offer")
public class Offer implements Serializable {

	@Id
	@Column(name = "OFFER_ID")
	private Integer offerId;

	@Column(name = "OFFER_NAME")
	private String offerName;

	@Column(name="OFFER_DESCRIPTION", columnDefinition="TEXT")
	private String offerDescription;
	     
	@Column(name="OFFER_TERMSCONDITIONS", columnDefinition="TEXT")
	private String offerTermsConditions;
	     
	@Column(name="OFFER_ADDITIONALDETAILS", columnDefinition="TEXT")
	private String additionalDetails;
	
	@Column(name = "CREATE_TS")
	private Long createTs;
	
	@Column(name="OFFER_START_DATE")      
	private String offerStartDate;   
	   
	@Column(name="OFFER_END_DATE")
	private String offerEndDate;
	
    @Column(name="OFFER_COST")
	private String offerCost;
	
	@Column(name="NO_OF_SLOT")
	private String noOfSlot;
	
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@Column(name="LOCATION_CITY")   
	private String locationCity;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="STATE")           
	private String state;
	
	@Column(name="ZIP")
	private String zip;
	
	@Column(name="CONTACT_PERSON")
	private String contactPerson;     
	
	@Column(name="EMAIL")
	private String email;   
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="FAX")
	private String fax;
	
	@Transient
	@Column(name="From_Date")
	private Long fromDate;
	
	@Transient
	@Column(name="TO_Date")
	private Long toDate;
	
	@Column(name="DELETE_STATUS")
	private Boolean deleteStatus;

	/**
	 * @return the additionalDetails
	 */
	public String getAdditionalDetails() {
		return additionalDetails;
	}

	/**
	 * @param additionalDetails the additionalDetails to set
	 */
	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

	/**
	 * @return the companyId
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	//@JoinColumn(name = "COMPANY_ID", nullable = false)
	@Column(name="COMPANY_ID")
	private Integer companyId;

/**
	 * @return the deleteStatus
	 */
	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	/**
	 * @param deleteStatus the deleteStatus to set
	 */
	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Long  getFromDate() {
		return fromDate;
	}

	public void setFromDate(Long fromDate) {
		this.fromDate = fromDate;
	}

	public Long getToDate() {
		return toDate;
	}

	public void setToDate(Long toDate) {
		this.toDate = toDate;
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	
	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	public String getOfferTermsConditions() {
		return offerTermsConditions;
	}

	public void setOfferTermsConditions(String offerTermsConditions) {
		this.offerTermsConditions = offerTermsConditions;
	}

	

	public String getOfferStartDate() {
		return offerStartDate;
	}

	public void setOfferStartDate(String offerStartDate) {
		this.offerStartDate = offerStartDate;
	}

	public String getOfferEndDate() {
		return offerEndDate;
	}

	public void setOfferEndDate(String offerEndDate) {
		this.offerEndDate = offerEndDate;
	}

	public String getOfferCost() {
		return offerCost;
	}

	public void setOfferCost(String offerCost) {
		this.offerCost = offerCost;
	}

	public String getNoOfSlot() {
		return noOfSlot;
	}

	public void setNoOfSlot(String noOfSlot) {
		this.noOfSlot = noOfSlot;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the createTs
	 */
	public Long getCreateTs() {
		return createTs;
	}

	/**
	 * @param createTs the createTs to set
	 */
	public void setCreateTs(Long createTs) {
		this.createTs = createTs;
	}

}
