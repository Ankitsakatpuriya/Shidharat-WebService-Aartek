package com.hyringspree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "publication_info")

public class PublicationInfo {

	@Id
	@Column(name = "PUBLICATION_ID")
	private Integer publicationId;

	@Column(name = "Publication_INFO_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer publicationInfoSeq;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "PROFILE_ID" ,nullable = false) private ProfileInfo
	 * profileId;
	 */

	@Column(name = "PROFILE_ID", nullable = false)
	private Integer profileId;

	@Column(name = "PUBLICATION_DATE")
	private Long publicationDate;

	@Column(name = "PUBLISHED_IN")
	private String publishedIn;

	@Column(name = "PUBLICATION_TITLE")
	private String publicationTitle;

	@Column(name = "PUBLISHED_CONTENT")
	private String publishedContent;

	@Column(name = "CO_AUTHORS")
	private String coAuthors;

	@Column(name = "CREATE_TS")
	private Long createTs;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "TRANSACTION_ID")
	private String tarnsactionId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "DELETE_STATUS")
	private Boolean deleteStatus;

	// Extra fields
	@Column(name = "PUBLICATIONS_DESCRIPTION", columnDefinition="TEXT")
	private String publicationsDescription;

	@Column(name = "DATE")
	private String date;

	@Column(name = "PUBLISHER_NAME")
	private String publisherName;

	@Transient
	private String fromDate;

	@Transient
	private String toDate;

	public Integer getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(Integer publicationId) {
		this.publicationId = publicationId;
	}

	public Integer getPublicationInfoSeq() {
		return publicationInfoSeq;
	}

	public void setPublicationInfoSeq(Integer publicationInfoSeq) {
		this.publicationInfoSeq = publicationInfoSeq;
	}

	/*
	 * public ProfileInfo getProfileId() { return profileId; }
	 * 
	 * public void setProfileId(ProfileInfo profileId) { this.profileId =
	 * profileId; }
	 */

	public Long getPublicationDate() {
		return publicationDate;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getPublicationsDescription() {
		return publicationsDescription;
	}

	public void setPublicationsDescription(String publicationsDescription) {
		this.publicationsDescription = publicationsDescription;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public void setPublicationDate(Long publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getPublishedIn() {
		return publishedIn;
	}

	public void setPublishedIn(String publishedIn) {
		this.publishedIn = publishedIn;
	}

	public String getPublicationTitle() {
		return publicationTitle;
	}

	public void setPublicationTitle(String publicationTitle) {
		this.publicationTitle = publicationTitle;
	}

	public String getPublishedContent() {
		return publishedContent;
	}

	public void setPublishedContent(String publishedContent) {
		this.publishedContent = publishedContent;
	}

	public String getCoAuthors() {
		return coAuthors;
	}

	public void setCoAuthors(String coAuthors) {
		this.coAuthors = coAuthors;
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

	public String getTarnsactionId() {
		return tarnsactionId;
	}

	public void setTarnsactionId(String tarnsactionId) {
		this.tarnsactionId = tarnsactionId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

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

}
