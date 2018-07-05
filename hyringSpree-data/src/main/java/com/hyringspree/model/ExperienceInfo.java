package com.hyringspree.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "experience_info")
public class ExperienceInfo {

	@Id
	@Column(name = "EXPERIENCE_ID")
	private Integer experienceId;

	@Column(name = "EXPERIENCE_INFO_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer experienceInfoSeq;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "PROFILE_ID" ,nullable = false) private ProfileInfo
	 * profileId;
	 */

	@Column(name = "PROFILE_ID", nullable = false)
	private Integer profileId;

	@Column(name = "START_DT")
	private Date startDt;

	@Column(name = "END_DATE")
	private Date EndDate;

	@Column(name = "DURATION")
	private String duration;

	@Column(name = "JOB_DES")
	private String jobDes;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "COMPANY_ID")
	private String companyId;

	@Column(name = "CREATE_TS")
	private long createTs;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

	@Column(name = "ROLES_RESPOSIBILITY")
	private String rolesResposibility;

	// Extra fields
	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "JOB_ROLE")
	private String jobRole;

	@Column(name = "JOINING_DATE")
	private String joiningDate;

	@Column(name = "RELIEVING_DATE")
	private String relievingDate;

	@Column(name = "DESCRIPTION_EXPERIENCE", columnDefinition="TEXT")
	private String descriptionExperience;

	@Column(name = "DELETE_STATUS")
	private Boolean deleteStatus;

	/**
	 * @return the deleteStatus
	 */
	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	/**
	 * @param deleteStatus
	 *            the deleteStatus to set
	 */
	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getCompanyName() {
		return companyName;
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

	public Integer getExperienceId() {
		return experienceId;
	}

	public void setExperienceId(Integer experienceId) {
		this.experienceId = experienceId;
	}

	public Integer getExperienceInfoSeq() {
		return experienceInfoSeq;
	}

	public void setExperienceInfoSeq(Integer experienceInfoSeq) {
		this.experienceInfoSeq = experienceInfoSeq;
	}

	/*
	 * public ProfileInfo getProfileId() { return profileId; }
	 * 
	 * public void setProfileId(ProfileInfo profileId) { this.profileId =
	 * profileId; }
	 */

	public Date getStartDt() {
		return startDt;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getJobDes() {
		return jobDes;
	}

	public void setJobDes(String jobDes) {
		this.jobDes = jobDes;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public long getCreateTs() {
		return createTs;
	}

	public void setCreateTs(long createTs) {
		this.createTs = createTs;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getRolesResposibility() {
		return rolesResposibility;
	}

	public void setRolesResposibility(String rolesResposibility) {
		this.rolesResposibility = rolesResposibility;
	}

}
