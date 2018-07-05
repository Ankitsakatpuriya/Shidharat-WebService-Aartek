package com.hyringspree.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "job_info")
public class JobInfo {
	
	@Id
	@Column(name = "JOB_ID")
	private Integer jobId;

	@Column(name = "JOB_INFO_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobInfoSequence;
	
	@Column(name = "SIMILAR_JOB_IDS")
	private String similarJobIds;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "JOB_POSTED_DT")
	private Long jobPostedDt;
	
	@Column(name = "JOB_EXPIRY_DT")
	private Long jobExpiryDt;
	
	@Column(name = "RECRUITER_ID", nullable = false)
	private Integer recruiterId;
	
	@Column(name = "COMPANY_ID", nullable = false)
	private Integer companyId;
	
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	
	@Column(name = "JOB_DES")
	private String jobDes;
	
	@Column(name = "JOB_RESPONSIBILITY")
	private String jobResponsibility;
	
	@Column(name = "JOB_REQUIREMENT", columnDefinition="TEXT")
	private String jobRequirement;
	
	@Column(name = "JOB_TYPE")
	private String jobType;
	
	@Column(name = "JOB_CITY")
	private String jobCity;
	
	@Column(name = "JOB_STATE")
	private String jobState;
	
	@Column(name = "JOB_COUNTRY")
	private String jobCountry;
	
	@Column(name = "JOB_POSTAL_CODE")
	private String jobPostalCode;
	
	@Column(name = "JOB_SALARY")
	private String jobSalary;
	
	@Column(name = "JOB_SALARY_TYPE")
	private String jobSalaryType;
	
	@Column(name = "TELECOMMUTING")
	private String telecommuting;
	
	@Column(name = "IMMIGRATION_STATUS")
	private String immigrationStatus;
	
	@Column(name = "JOB_CATEGORY")
	private String jobCategory;
	
	@Column(name = "CREATE_TS")
	private Date createTs;
	
	@Column(name = "CREATE_BY")
	private Date createBy;
	
	@Column(name = "JOB_APPLY_EMAIL")
	private String jobApplyEmail;
	
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	
	@Column(name = "JOB_APPLY_URL")
	private String jobApplyUrl;
	
	@Column(name = "SKILLS_REQUIRED")
	private String skillsRequired;
	
	@Column(name = "SKILLS_PREFERRED")
	private String skillsPreffered;
	
	@Column(name = "SUBMISSION_DEADLINE")
	private Date submissionDeadline;
	
	@Column(name = "JOB_EXPECTED_DURATION_MONTHS")
	private String jobExpectedDurationMonths;
	
	@Column(name = "JOB_DOMAIN")
	private String jobDomain;
	
	@Column(name = "NO_OF_VIEWS")
	private String noOfViews;
	
	@Column(name = "DELETE_STATUS")
	private Boolean deleteStatus;

	
	@Column(name = "JOB_DESCRIPTION", columnDefinition="TEXT")
	private String jobDescription;
	
	@Column(name = "IMMIGRATION")
	private String immigration;
	
	
	@Column(name = "TEX_TERM")
	private String texTerm;

	@Column(name = "COMPENSATION")    
	private String compensation;

	@Column(name = "COMPENSATION_TYPE")
	private String compensationType;    

	@Column(name = "ADDITIONAL_DETAIL", columnDefinition="TEXT")
	private String additionalDetail;

	private String sampleCSVFileName;
	
	@Transient
	private Long fromDate;
	
	@Transient
	private Long toDate;
	
	@Transient
	private String jobHomeFilterValue;
	

	/**
	 * @return the jobHomeFilterValue
	 */
	public String getJobHomeFilterValue() {
		return jobHomeFilterValue;
	}

	/**
	 * @param jobHomeFilterValue the jobHomeFilterValue to set
	 */
	public void setJobHomeFilterValue(String jobHomeFilterValue) {
		this.jobHomeFilterValue = jobHomeFilterValue;
	}

	/**
	 * @return the jobId
	 */
	public Integer getJobId() {
		return jobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the jobInfoSequence
	 */
	public Integer getJobInfoSequence() {
		return jobInfoSequence;
	}

	/**
	 * @param jobInfoSequence the jobInfoSequence to set
	 */
	public void setJobInfoSequence(Integer jobInfoSequence) {
		this.jobInfoSequence = jobInfoSequence;
	}

	/**
	 * @return the similarJobIds
	 */
	public String getSimilarJobIds() {
		return similarJobIds;
	}

	/**
	 * @param similarJobIds the similarJobIds to set
	 */
	public void setSimilarJobIds(String similarJobIds) {
		this.similarJobIds = similarJobIds;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the jobPostedDt
	 */
	public Long getJobPostedDt() {
		return jobPostedDt;
	}

	/**
	 * @param jobPostedDt the jobPostedDt to set
	 */
	public void setJobPostedDt(Long jobPostedDt) {
		this.jobPostedDt = jobPostedDt;
	}

	/**
	 * @return the jobExpiryDt
	 */
	public Long getJobExpiryDt() {
		return jobExpiryDt;
	}

	/**
	 * @param jobExpiryDt the jobExpiryDt to set
	 */
	public void setJobExpiryDt(Long jobExpiryDt) {
		this.jobExpiryDt = jobExpiryDt;
	}

	/**
	 * @return the recruiterId
	 */
	public Integer getRecruiterId() {
		return recruiterId;
	}

	/**
	 * @param recruiterId the recruiterId to set
	 */
	public void setRecruiterId(Integer recruiterId) {
		this.recruiterId = recruiterId;
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
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the jobDes
	 */
	public String getJobDes() {
		return jobDes;
	}

	/**
	 * @param jobDes the jobDes to set
	 */
	public void setJobDes(String jobDes) {
		this.jobDes = jobDes;
	}

	/**
	 * @return the jobResponsibility
	 */
	public String getJobResponsibility() {
		return jobResponsibility;
	}

	/**
	 * @param jobResponsibility the jobResponsibility to set
	 */
	public void setJobResponsibility(String jobResponsibility) {
		this.jobResponsibility = jobResponsibility;
	}

	/**
	 * @return the jobRequirement
	 */
	public String getJobRequirement() {
		return jobRequirement;
	}

	/**
	 * @param jobRequirement the jobRequirement to set
	 */
	public void setJobRequirement(String jobRequirement) {
		this.jobRequirement = jobRequirement;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	/**
	 * @return the jobCity
	 */
	public String getJobCity() {
		return jobCity;
	}

	/**
	 * @param jobCity the jobCity to set
	 */
	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}

	/**
	 * @return the jobState
	 */
	public String getJobState() {
		return jobState;
	}

	/**
	 * @param jobState the jobState to set
	 */
	public void setJobState(String jobState) {
		this.jobState = jobState;
	}

	/**
	 * @return the jobCountry
	 */
	public String getJobCountry() {
		return jobCountry;
	}

	/**
	 * @param jobCountry the jobCountry to set
	 */
	public void setJobCountry(String jobCountry) {
		this.jobCountry = jobCountry;
	}

	/**
	 * @return the jobPostalCode
	 */
	public String getJobPostalCode() {
		return jobPostalCode;
	}

	/**
	 * @param jobPostalCode the jobPostalCode to set
	 */
	public void setJobPostalCode(String jobPostalCode) {
		this.jobPostalCode = jobPostalCode;
	}

	/**
	 * @return the jobSalary
	 */
	public String getJobSalary() {
		return jobSalary;
	}

	/**
	 * @param jobSalary the jobSalary to set
	 */
	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}

	/**
	 * @return the jobSalaryType
	 */
	public String getJobSalaryType() {
		return jobSalaryType;
	}

	/**
	 * @param jobSalaryType the jobSalaryType to set
	 */
	public void setJobSalaryType(String jobSalaryType) {
		this.jobSalaryType = jobSalaryType;
	}

	/**
	 * @return the telecommuting
	 */
	public String getTelecommuting() {
		return telecommuting;
	}

	/**
	 * @param telecommuting the telecommuting to set
	 */
	public void setTelecommuting(String telecommuting) {
		this.telecommuting = telecommuting;
	}

	/**
	 * @return the immigrationStatus
	 */
	public String getImmigrationStatus() {
		return immigrationStatus;
	}

	/**
	 * @param immigrationStatus the immigrationStatus to set
	 */
	public void setImmigrationStatus(String immigrationStatus) {
		this.immigrationStatus = immigrationStatus;
	}

	/**
	 * @return the jobCategory
	 */
	public String getJobCategory() {
		return jobCategory;
	}

	/**
	 * @param jobCategory the jobCategory to set
	 */
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	/**
	 * @return the createTs
	 */
	public Date getCreateTs() {
		return createTs;
	}

	/**
	 * @param createTs the createTs to set
	 */
	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}

	/**
	 * @return the createBy
	 */
	public Date getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(Date createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return the jobApplyEmail
	 */
	public String getJobApplyEmail() {
		return jobApplyEmail;
	}

	/**
	 * @param jobApplyEmail the jobApplyEmail to set
	 */
	public void setJobApplyEmail(String jobApplyEmail) {
		this.jobApplyEmail = jobApplyEmail;
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
	 * @return the jobApplyUrl
	 */
	public String getJobApplyUrl() {
		return jobApplyUrl;
	}

	/**
	 * @param jobApplyUrl the jobApplyUrl to set
	 */
	public void setJobApplyUrl(String jobApplyUrl) {
		this.jobApplyUrl = jobApplyUrl;
	}

	/**
	 * @return the skillsRequired
	 */
	public String getSkillsRequired() {
		return skillsRequired;
	}

	/**
	 * @param skillsRequired the skillsRequired to set
	 */
	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	/**
	 * @return the skillsPreffered
	 */
	public String getSkillsPreffered() {
		return skillsPreffered;
	}

	/**
	 * @param skillsPreffered the skillsPreffered to set
	 */
	public void setSkillsPreffered(String skillsPreffered) {
		this.skillsPreffered = skillsPreffered;
	}

	/**
	 * @return the submissionDeadline
	 */
	public Date getSubmissionDeadline() {
		return submissionDeadline;
	}

	/**
	 * @param submissionDeadline the submissionDeadline to set
	 */
	public void setSubmissionDeadline(Date submissionDeadline) {
		this.submissionDeadline = submissionDeadline;
	}

	/**
	 * @return the jobExpectedDurationMonths
	 */
	public String getJobExpectedDurationMonths() {
		return jobExpectedDurationMonths;
	}

	/**
	 * @param jobExpectedDurationMonths the jobExpectedDurationMonths to set
	 */
	public void setJobExpectedDurationMonths(String jobExpectedDurationMonths) {
		this.jobExpectedDurationMonths = jobExpectedDurationMonths;
	}

	/**
	 * @return the jobDomain
	 */
	public String getJobDomain() {
		return jobDomain;
	}

	/**
	 * @param jobDomain the jobDomain to set
	 */
	public void setJobDomain(String jobDomain) {
		this.jobDomain = jobDomain;
	}

	/**
	 * @return the noOfViews
	 */
	public String getNoOfViews() {
		return noOfViews;
	}

	/**
	 * @param noOfViews the noOfViews to set
	 */
	public void setNoOfViews(String noOfViews) {
		this.noOfViews = noOfViews;
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
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}

	/**
	 * @param jobDescription the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	/**
	 * @return the immigration
	 */
	public String getImmigration() {
		return immigration;
	}

	/**
	 * @param immigration the immigration to set
	 */
	public void setImmigration(String immigration) {
		this.immigration = immigration;
	}

	/**
	 * @return the texTerm
	 */
	public String getTexTerm() {
		return texTerm;
	}

	/**
	 * @param texTerm the texTerm to set
	 */
	public void setTexTerm(String texTerm) {
		this.texTerm = texTerm;
	}

	/**
	 * @return the compensation
	 */
	public String getCompensation() {
		return compensation;
	}

	/**
	 * @param compensation the compensation to set
	 */
	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}

	/**
	 * @return the compensationType
	 */
	public String getCompensationType() {
		return compensationType;
	}

	/**
	 * @param compensationType the compensationType to set
	 */
	public void setCompensationType(String compensationType) {
		this.compensationType = compensationType;
	}

	/**
	 * @return the additionalDetail
	 */
	public String getAdditionalDetail() {
		return additionalDetail;
	}

	/**
	 * @param additionalDetail the additionalDetail to set
	 */
	public void setAdditionalDetail(String additionalDetail) {
		this.additionalDetail = additionalDetail;
	}

	/**
	 * @return the sampleCSVFileName
	 */
	public String getSampleCSVFileName() {
		return sampleCSVFileName;
	}

	/**
	 * @param sampleCSVFileName the sampleCSVFileName to set
	 */
	public void setSampleCSVFileName(String sampleCSVFileName) {
		this.sampleCSVFileName = sampleCSVFileName;
	}

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
	
}
