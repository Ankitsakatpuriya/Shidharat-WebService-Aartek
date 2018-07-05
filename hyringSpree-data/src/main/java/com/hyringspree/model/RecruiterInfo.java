package com.hyringspree.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "recruiter_info")
public class RecruiterInfo {

	@Id
	@Column(name="RECRUITER_ID")
	private Integer recruiterId;
	
	@Column(name="RECRUITER_FNAME")
	private String recruiterFName;
	
	@Column(name="RECRUITER_MNAME")
	private String recruiterMName;
	
	@Column(name="RECRUITER_LNAME")
	private String recruiterLName;
	
	@Column(name="RECRUITER_EMAIL")
	private String recruiterEmail;
	
	@Column(name="RECRUITER_PHONE")
	private String recruiterPhone	;
	
	@Column(name="RECRUITER_PHONE_EXT")
	private String recruiterPhoneExt;
	
	@Column(name="RECRUITER_POSTAL_CODE")
	private String recruiterPostalCode;
	
	@Column(name="RECRUITER_CITY")
	private String recruiterCity;
	
	@Column(name="RECRUITER_STATE")
	private String recruiterState;
	
	@Column(name="RECRUITER_ADDRESS_LINE")
	private String recruiterAddressLine;
	
	@Column(name="RECRUITER_COUNTRY_CODE")
	private String recruiterCountryCode;
	
	@Column(name="CREATE_TS")
	private Long createTs;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="COMPANY_ID")
	private Integer companyId;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="TRANSACTION_ID")
	private String transactionId;
	
	//ExtraFields
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="CONFIRM_PASSWORD")
	private String confirmPassword;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	
	@Transient
	private Long fromDate;
	
	@Transient
	private Long toDate;

	@Column(name = "RECRUITER_CREATED_DATE") 
	private String recruiterCreatedDate;  
	
	@Column(name = "DELETE_STATUS")
	private Boolean deleteStatus;
	
	@OneToMany(targetEntity=JobInfo.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "RECRUITER_ID", updatable = false)
	private List<JobInfo> jobInfo;
	
	

	
	/**
	 * @return the fromDate
	 */
	public Long getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Long fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Long getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Long toDate) {
		this.toDate = toDate;
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

	public String getRecruiterCreatedDate() {
		return recruiterCreatedDate;
	}

	public Integer getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(Integer recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getRecruiterFName() {
		return recruiterFName;
	}

	public void setRecruiterFName(String recruiterFName) {
		this.recruiterFName = recruiterFName;
	}

	public String getRecruiterMName() {
		return recruiterMName;
	}

	public void setRecruiterMName(String recruiterMName) {
		this.recruiterMName = recruiterMName;
	}

	public String getRecruiterLName() {
		return recruiterLName;
	}

	public void setRecruiterLName(String recruiterLName) {
		this.recruiterLName = recruiterLName;
	}

	public String getRecruiterEmail() {
		return recruiterEmail;
	}

	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}

	public String getRecruiterPhone() {
		return recruiterPhone;
	}

	public void setRecruiterPhone(String recruiterPhone) {
		this.recruiterPhone = recruiterPhone;
	}

	public String getRecruiterPhoneExt() {
		return recruiterPhoneExt;
	}

	public void setRecruiterPhoneExt(String recruiterPhoneExt) {
		this.recruiterPhoneExt = recruiterPhoneExt;
	}

	public String getRecruiterPostalCode() {
		return recruiterPostalCode;
	}

	public void setRecruiterPostalCode(String recruiterPostalCode) {
		this.recruiterPostalCode = recruiterPostalCode;
	}

	public String getRecruiterCity() {
		return recruiterCity;
	}

	public void setRecruiterCity(String recruiterCity) {
		this.recruiterCity = recruiterCity;
	}

	public String getRecruiterState() {
		return recruiterState;
	}

	public void setRecruiterState(String recruiterState) {
		this.recruiterState = recruiterState;
	}

	public String getRecruiterAddressLine() {
		return recruiterAddressLine;
	}

	public void setRecruiterAddressLine(String recruiterAddressLine) {
		this.recruiterAddressLine = recruiterAddressLine;
	}

	public String getRecruiterCountryCode() {
		return recruiterCountryCode;
	}

	public void setRecruiterCountryCode(String recruiterCountryCode) {
		this.recruiterCountryCode = recruiterCountryCode;
	}

	public Long getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Long createTs) {
		this.createTs = createTs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public void setRecruiterCreatedDate(String recruiterCreatedDate) {
		this.recruiterCreatedDate = recruiterCreatedDate;
	}
	
	
	
	
	
	
}
