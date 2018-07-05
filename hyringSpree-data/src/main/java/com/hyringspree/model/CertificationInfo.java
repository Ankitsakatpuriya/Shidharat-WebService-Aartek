package com.hyringspree.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certification_info")
public class CertificationInfo {

	@Id
	@Column(name = "CERTIFICATION_ID")
	private Integer certificationId;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "PROFILE_ID", nullable = false) private ProfileInfo
	 * profileId;
	 */

	@Column(name = "PROFILE_ID", nullable = false)
	private Integer profileId;

	@Column(name = "CERTIFICATION_INFO_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer certificationInfoSeq;

	@Column(name = "CERTIFICATION_NAME")
	private String certificationName;

	@Column(name = "CERTIFICATION_DT")
	private Date certificationDt;

	@Column(name = "ISSUED_BY")
	private String issuedBy;

	@Column(name = "CERTIFICATION_DES")
	private String certificationDes;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

	@Column(name = "CREATE_TS")
	private Long createTs;

	@Column(name = "CREATED_BY")
	private String createBy;

	/* Certification */
	@Column(name = "CERTIFID_ON")
	private String certifidOn;

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

	public String getCertifidOn() {
		return certifidOn;
	}

	public void setCertifidOn(String certifidOn) {
		this.certifidOn = certifidOn;
	}

	public Integer getCertificationInfoSeq() {
		return certificationInfoSeq;
	}

	public void setCertificationInfoSeq(Integer certificationInfoSeq) {
		this.certificationInfoSeq = certificationInfoSeq;
	}

	/*
	 * public ProfileInfo getProfileId() { return profileId; }
	 * 
	 * public void setProfileId(ProfileInfo profileId) { this.profileId =
	 * profileId; }
	 */

	public Integer getCertificationId() {
		return certificationId;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public void setCertificationId(Integer certificationId) {
		this.certificationId = certificationId;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public Date getCertificationDt() {
		return certificationDt;
	}

	public void setCertificationDt(Date certificationDt) {
		this.certificationDt = certificationDt;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public String getCertificationDes() {
		return certificationDes;
	}

	public void setCertificationDes(String certificationDes) {
		this.certificationDes = certificationDes;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

}
