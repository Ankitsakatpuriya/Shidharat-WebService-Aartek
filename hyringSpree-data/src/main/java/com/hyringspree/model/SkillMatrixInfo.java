package com.hyringspree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill_matrix_info")
public class SkillMatrixInfo {

	@Id
	@GeneratedValue
	@Column(name = "SKILL_ID")
	private Integer skillId;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "PROFILE_ID", nullable = false) private ProfileInfo
	 * profileId;
	 */

	@Column(name = "PROFILE_ID", nullable = false)
	private Integer profileId;

	@Column(name = "SKILL_TYPE")
	private String skillType;

	@Column(name = "SKILL_NAME")
	private String skillName;

	@Column(name = "EXPERIENCE_MONTHS")
	private String experienceMonths;

	@Column(name = "SKILL_DESC")
	private String skillDesc;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATE_TS")
	private Long createTs;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	/*
	 * public ProfileInfo getProfileId() { return profileId; }
	 * 
	 * public void setProfileId(ProfileInfo profileId) { this.profileId =
	 * profileId; }
	 */

	public String getSkillType() {
		return skillType;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getExperienceMonths() {
		return experienceMonths;
	}

	public void setExperienceMonths(String experienceMonths) {
		this.experienceMonths = experienceMonths;
	}

	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Long createTs) {
		this.createTs = createTs;
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

}
