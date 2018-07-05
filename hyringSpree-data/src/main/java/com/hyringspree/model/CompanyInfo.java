package com.hyringspree.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "company_info")

public class CompanyInfo {
	
	@Id
	@Column(name = "COMPANY_ID")
	private Integer companyId;

	@Column(name = "COMPANY_INFO_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyInfoSequence;
	
	@Column(name = "SIMILAR_COMPANY_ID")
	private String similarCompanyId;
	
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@Column(name = "COMPANY_ADDRESS")
	private String companyAddress;
	
	@Column(name = "COMPANY_CITY")
	private String companyCity;
	
	@Column(name = "COMPANY_STATE")
	private String companyState;
	
	@Column(name = "COMPANY_COUNTRY")
	private String companyCountry;
	
	@Column(name = "COMPANY_POSTAL_CODE")
	private String companyPostalCode;
	
	@Column(name = "COMPANY_PHONE")
	private String companyPhone;
	
	@Column(name = "COMPANY_PHONE_EXT")
	private String companyPhoneExt;
	
	@Column(name = "COMPANY_DES", columnDefinition="TEXT")
	private String companyDes;
	
	@Column(name = "WEBSITE_URL")
	private String websiteUrl;
	
	@Column(name = "NO_OF_EMPLOYEES")
	private String noOfEmployees;
	
	@Column(name = "CREATE_TS")
	private Long createTs;
	
	@Column(name = "CREATE_BY")
	private String createBy;
	
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	
	@Column(name = "COMPANY_LOGO")
	private String companyLogo;
	
	public Long getFromDate() {
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

	@Column(name = "DELETE_STATUS")
	private Boolean deleteStatus;
	
	@Transient
	private Long fromDate;
	
	@Transient
	private Long toDate;
	
/*	 @OneToMany(targetEntity = Offer.class)
	 @LazyCollection(LazyCollectionOption.FALSE)
	 @JoinColumn(name = "OFFER_ID", updatable = false)
	 private List<Offer> offerId;*/
	
	 @OneToMany(targetEntity=JobInfo.class)
	 @LazyCollection(LazyCollectionOption.FALSE)
	 @JoinColumn(name = "COMPANY_ID", updatable = false)
	 private List<JobInfo> jobInfo;
	 
	 @OneToMany(targetEntity=RecruiterInfo.class)
	 @LazyCollection(LazyCollectionOption.FALSE)
	 @JoinColumn(name = "COMPANY_ID", updatable = false)
	 private List<RecruiterInfo> recruiterInfo;

	 
	/**
	 * @return the recruiterInfo
	 */
	public List<RecruiterInfo> getRecruiterInfo() {
		return recruiterInfo;
	}

	/**
	 * @param recruiterInfo the recruiterInfo to set
	 */
	public void setRecruiterInfo(List<RecruiterInfo> recruiterInfo) {
		this.recruiterInfo = recruiterInfo;
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

	/**
	 * @return the companyInfoSequence
	 */
	public Integer getCompanyInfoSequence() {
		return companyInfoSequence;
	}

	/**
	 * @param companyInfoSequence the companyInfoSequence to set
	 */
	public void setCompanyInfoSequence(Integer companyInfoSequence) {
		this.companyInfoSequence = companyInfoSequence;
	}

	/**
	 * @return the similarCompanyId
	 */
	public String getSimilarCompanyId() {
		return similarCompanyId;
	}

	/**
	 * @param similarCompanyId the similarCompanyId to set
	 */
	public void setSimilarCompanyId(String similarCompanyId) {
		this.similarCompanyId = similarCompanyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * @return the companyCity
	 */
	public String getCompanyCity() {
		return companyCity;
	}

	/**
	 * @param companyCity the companyCity to set
	 */
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	/**
	 * @return the companyState
	 */
	public String getCompanyState() {
		return companyState;
	}

	/**
	 * @param companyState the companyState to set
	 */
	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	/**
	 * @return the companyCountry
	 */
	public String getCompanyCountry() {
		return companyCountry;
	}

	/**
	 * @param companyCountry the companyCountry to set
	 */
	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	/**
	 * @return the companyPostalCode
	 */
	public String getCompanyPostalCode() {
		return companyPostalCode;
	}

	/**
	 * @param companyPostalCode the companyPostalCode to set
	 */
	public void setCompanyPostalCode(String companyPostalCode) {
		this.companyPostalCode = companyPostalCode;
	}

	/**
	 * @return the companyPhone
	 */
	public String getCompanyPhone() {
		return companyPhone;
	}

	/**
	 * @param companyPhone the companyPhone to set
	 */
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	/**
	 * @return the companyPhoneExt
	 */
	public String getCompanyPhoneExt() {
		return companyPhoneExt;
	}

	/**
	 * @param companyPhoneExt the companyPhoneExt to set
	 */
	public void setCompanyPhoneExt(String companyPhoneExt) {
		this.companyPhoneExt = companyPhoneExt;
	}

	/**
	 * @return the companyDes
	 */
	public String getCompanyDes() {
		return companyDes;
	}

	/**
	 * @param companyDes the companyDes to set
	 */
	public void setCompanyDes(String companyDes) {
		this.companyDes = companyDes;
	}

	/**
	 * @return the websiteUrl
	 */
	public String getWebsiteUrl() {
		return websiteUrl;
	}

	/**
	 * @param websiteUrl the websiteUrl to set
	 */
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	/**
	 * @return the noOfEmployees
	 */
	public String getNoOfEmployees() {
		return noOfEmployees;
	}

	/**
	 * @param noOfEmployees the noOfEmployees to set
	 */
	public void setNoOfEmployees(String noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
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

	/**
	 * @return the createBy
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the companyLogo
	 */
	public String getCompanyLogo() {
		return companyLogo;
	}

	/**
	 * @param companyLogo the companyLogo to set
	 */
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

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

	/**
	 * @return the witOuterrorChildren
	 */
	public List<JobInfo> getWitOuterrorChildren() {
		return jobInfo;
	}

	/**
	 * @param witOuterrorChildren the witOuterrorChildren to set
	 */
	public void setWitOuterrorChildren(List<JobInfo> witOuterrorChildren) {
		this.jobInfo = witOuterrorChildren;
	}

	/**
	 * @return the offerId
	 */
	/*public List<Offer> getOfferId() {
		return offerId;
	}

	*//**
	 * @param offerId the offerId to set
	 *//*
	public void setOfferId(List<Offer> offerId) {
		this.offerId = offerId;
	}*/

	/**
	 * @return the jobInfo
	 */
	public List<JobInfo> getJobInfo() {
		return jobInfo;
	}

	/**
	 * @param jobInfo the jobInfo to set
	 */
	public void setJobInfo(List<JobInfo> jobInfo) {
		this.jobInfo = jobInfo;
	}


	/**
	 * @return the children
	 *//*
	public Set getChildren() {
		return children;
	}

	*//**
	 * @param children the children to set
	 *//*
	public void setChildren(Set children) {
		this.children = children;
	}

	*//**
	 * @return the errorChildren
	 *//*
	public Set getErrorChildren() {
		return errorChildren;
	}

	*//**
	 * @param errorChildren the errorChildren to set
	 *//*
	public void setErrorChildren(Set errorChildren) {
		this.errorChildren = errorChildren;
	}
*/
	
}
