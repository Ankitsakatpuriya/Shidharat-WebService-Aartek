package com.hyringspree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patent_info")
public class PatentInfo implements Serializable {

	@Id
	@Column(name = "PATENT_ID")
	private Integer patentId;

	@Column(name = "PATENT_NO")
	private String patentNo;

	@Column(name = "PATENT_TITLE")
	private String patentTitle;

	@Column(name = "PATENT_ISSUE_DT")
	private long patentIssueDt;

	@Column(name = "PATENT_ISSUE_COUNTRY")
	private String patentIssueCountry;

	@Column(name = "PATENT_DES", columnDefinition="TEXT")
	private String patentDes;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATE_TS")
	private Long createTs;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

	@Column(name = "DELETE_STATUS")
	private Boolean deleteStatus;

	/* Patents Extra */
	@Column(name = "ISSUED_ON")
	private String issuedOn;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "PROFILE_ID", nullable = false) private ProfileInfo
	 * profileId;
	 */

	@Column(name = "PROFILE_ID", nullable = false)
	private Integer profileId;

	public Integer getPatentId() {
		return patentId;
	}

	public void setPatentId(Integer patentId) {
		this.patentId = patentId;
	}

	public String getPatentNo() {
		return patentNo;
	}

	public void setPatentNo(String patentNo) {
		this.patentNo = patentNo;
	}

	public String getPatentTitle() {
		return patentTitle;
	}

	public void setPatentTitle(String patentTitle) {
		this.patentTitle = patentTitle;
	}

	public long getPatentIssueDt() {
		return patentIssueDt;
	}

	public void setPatentIssueDt(long patentIssueDt) {
		this.patentIssueDt = patentIssueDt;
	}

	public String getPatentIssueCountry() {
		return patentIssueCountry;
	}

	public void setPatentIssueCountry(String patentIssueCountry) {
		this.patentIssueCountry = patentIssueCountry;
	}

	public String getPatentDes() {
		return patentDes;
	}

	public void setPatentDes(String patentDes) {
		this.patentDes = patentDes;
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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(String issuedOn) {
		this.issuedOn = issuedOn;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	/*
	 * public ProfileInfo getProfileId() { return profileId; }
	 * 
	 * public void setProfileId(ProfileInfo profileId) { this.profileId =
	 * profileId; }
	 */
}