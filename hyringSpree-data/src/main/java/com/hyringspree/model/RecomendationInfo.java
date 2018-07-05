package com.hyringspree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recomendation_info")

public class RecomendationInfo {

	@Id
	@GeneratedValue
	@Column(name = "RECOMENDATION_ID")
	private Integer recomendationId;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "PROFILE_ID", nullable = false) private ProfileInfo
	 * profileId;
	 */

	@Column(name = "PROFILE_ID", nullable = false)
	private Integer profileId;

	@Column(name = "RECOMENDATION_INFO_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recomendationInfoSeq;

	@Column(name = "RECOMENDATOR_PROFILE_ID")
	private String recomendatorProfileId;

	@Column(name = "RECOMENDED_DT")
	private String recomendedDt;

	@Column(name = "RECOMENDATION_TEXT")
	private String recomendationText;

	@Column(name = "CREATE_TS")
	private Long createTs;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

	public Integer getRecomendationId() {
		return recomendationId;
	}

	public void setRecomendationId(Integer recomendationId) {
		this.recomendationId = recomendationId;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public Integer getRecomendationInfoSeq() {
		return recomendationInfoSeq;
	}

	public void setRecomendationInfoSeq(Integer recomendationInfoSeq) {
		this.recomendationInfoSeq = recomendationInfoSeq;
	}

	public String getRecomendatorProfileId() {
		return recomendatorProfileId;
	}

	public void setRecomendatorProfileId(String recomendatorProfileId) {
		this.recomendatorProfileId = recomendatorProfileId;
	}

	public String getRecomendedDt() {
		return recomendedDt;
	}

	public void setRecomendedDt(String recomendedDt) {
		this.recomendedDt = recomendedDt;
	}

	public String getRecomendationText() {
		return recomendationText;
	}

	public void setRecomendationText(String recomendationText) {
		this.recomendationText = recomendationText;
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
