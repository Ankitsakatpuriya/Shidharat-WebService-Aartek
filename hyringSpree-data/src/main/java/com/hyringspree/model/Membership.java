package com.hyringspree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "membership")
public class Membership {
	
	@Id
	@Column(name = "MEMBERSHIP_ID")
	private Integer membershipId;

	@Column(name = "MEMBERSHIP_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer membershipSeq;

	
	@Column(name = "PROFILE_ID",nullable = false)
	private Integer profileId;
	
	@Column(name = "MEMBERSHIP_TITLE")
	private String membershipTitle;

	@Column(name = "MEMBERSHIP_DESCRIPTION", columnDefinition="TEXT")
	private String membershipDescription;

	@Column(name = "MEMBER_SINCE")
	private String memberSince;
	
	@Column(name = "DELETE_STATUS")
	private Boolean deleteStatus;
	
	@Column(name="CREATE_TS")
	private Long createTs;
	
	public Long getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Long createTs) {
		this.createTs = createTs;
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
	 * @param membershipId the membershipId to set
	 */
	public void setMembershipId(Integer membershipId) {
		this.membershipId = membershipId;
	}

	/**
	 * @return the memebershipId
	 */
	public Integer getMembershipId() {
		return membershipId;
	}

	/**
	 * @param memebershipId the memebershipId to set
	 */
	public void setMemebershipId(Integer membershipId) {
		this.membershipId = membershipId;
	}

	/**
	 * @return the membershipSeq
	 */
	public Integer getMembershipSeq() {
		return membershipSeq;
	}

	/**
	 * @param membershipSeq the membershipSeq to set
	 */
	public void setMembershipSeq(Integer membershipSeq) {
		this.membershipSeq = membershipSeq;
	}

	/**
	 * @return the profileId
	 */
	public Integer getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	/**
	 * @return the membershipTitle
	 */
	public String getMembershipTitle() {
		return membershipTitle;
	}

	/**
	 * @param membershipTitle the membershipTitle to set
	 */
	public void setMembershipTitle(String membershipTitle) {
		this.membershipTitle = membershipTitle;
	}

	/**
	 * @return the membershipDescription
	 */
	public String getMembershipDescription() {
		return membershipDescription;
	}

	/**
	 * @param membershipDescription the membershipDescription to set
	 */
	public void setMembershipDescription(String membershipDescription) {
		this.membershipDescription = membershipDescription;
	}

	/**
	 * @return the memberSince
	 */
	public String getMemberSince() {
		return memberSince;
	}

	/**
	 * @param memberSince the memberSince to set
	 */
	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}
	
}
