package com.hyringspree.model;

import java.util.Date;
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
@Table(name = "profile_info")
public class ProfileInfo {

	@Id
	@Column(name = "PROFILE_ID")
	private Integer profileId;

	@Column(name = "PROFILE_INFO_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileInfoSeq;

	@Column(name = "SIMILAR_PROFILE_IDS")
	private String similarProfileIds;

	@Column(name = "PROFILE_FNAME")
	private String profileFname;

	@Column(name = "PROFILE_MNAME")
	private String profileMname;

	@Column(name = "PROFILE_LNAME")
	private String profileLname;

	@Column(name = "PROFILE_DOB")
	private Date profileDob;

	@Column(name = "PROFILE_COUNTRY")
	private String profileCountry;

	@Column(name = "PROFILE_EMAIL")
	private String profileEmail;

	@Column(name = "PROFILE_HOME_PHONE")
	private String profileHomePhone;

	@Column(name = "PROFILE_MOBILE_PHONE")
	private String profileMobilePhone;

	@Column(name = "PROFILE_CITY")
	private String profileCity;

	@Column(name = "PROFILE_STATE")
	private String profileState;

	@Column(name = "PROFILE_POSTAL_CODE")
	private String profilePostalCode;

	@Column(name = "CREATE_TS")
	private Long createTs;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "PROFILE_TITLE")
	private String profileTitle;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

	@Column(name = "IS_EMAIL_PUBLIC")
	private String isEmailPublic;

	@Column(name = "IS_PHONE_PUBLIC")
	private String isPhonePublic;

	// Extra fields for UI
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "CONFIRM_PASSWORD")
	private String confirmPassword;

	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	@Column(name = "DATE")
	private Long profileCreateDate;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DELETE_STATUS")
	private Boolean deleteStatus;
	
	@Column(name = "PROFILE_DESCRIPTION", columnDefinition="TEXT")
	 private String profileDescription;
	 
	 @Column(name = "EXPERIENCE")
	 private String experience;
	 
	 @Column(name = "PROFILE_IMAGE")
	 private String profileImage;
	 
	 @Column(name = "IMAGE_File", columnDefinition="TEXT")
	 private String imageFile;
	 
	

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	@OneToMany()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "PROFILE_ID", updatable = false)
	private List<EducationInfo> educationInfo;

	@OneToMany()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "PROFILE_ID", updatable = false)
	private List<CertificationInfo> certificationInfo;

	@OneToMany()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "PROFILE_ID" ,updatable = false)
	private List<ExperienceInfo> experienceInfo;

	@OneToMany()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "PROFILE_ID" ,updatable = false)
	private List<PublicationInfo> publicationInfo;

	@OneToMany()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "PROFILE_ID", updatable = false)
	private List<PatentInfo> patentInfo;

	@OneToMany()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "PROFILE_ID", updatable = false)
	private List<SkillMatrixInfo> skillMatrixInfo;

	@OneToMany()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "PROFILE_ID", updatable = false)
	private List<RecomendationInfo> recomendationInfo;

	@OneToMany()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "PROFILE_ID", updatable = false)
	private List<Membership> membership;

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public Integer getProfileInfoSeq() {
		return profileInfoSeq;
	}

	public void setProfileInfoSeq(Integer profileInfoSeq) {
		this.profileInfoSeq = profileInfoSeq;
	}

	public String getSimilarProfileIds() {
		return similarProfileIds;
	}

	public void setSimilarProfileIds(String similarProfileIds) {
		this.similarProfileIds = similarProfileIds;
	}

	public String getProfileFname() {
		return profileFname;
	}

	public void setProfileFname(String profileFname) {
		this.profileFname = profileFname;
	}

	public String getProfileMname() {
		return profileMname;
	}

	public void setProfileMname(String profileMname) {
		this.profileMname = profileMname;
	}

	public String getProfileLname() {
		return profileLname;
	}

	public void setProfileLname(String profileLname) {
		this.profileLname = profileLname;
	}

	public Date getProfileDob() {
		return profileDob;
	}

	public void setProfileDob(Date profileDob) {
		this.profileDob = profileDob;
	}

	public String getProfileCountry() {
		return profileCountry;
	}

	public void setProfileCountry(String profileCountry) {
		this.profileCountry = profileCountry;
	}

	public String getProfileEmail() {
		return profileEmail;
	}

	public void setProfileEmail(String profileEmail) {
		this.profileEmail = profileEmail;
	}

	public String getProfileHomePhone() {
		return profileHomePhone;
	}

	public void setProfileHomePhone(String profileHomePhone) {
		this.profileHomePhone = profileHomePhone;
	}

	public String getProfileMobilePhone() {
		return profileMobilePhone;
	}

	public void setProfileMobilePhone(String profileMobilePhone) {
		this.profileMobilePhone = profileMobilePhone;
	}

	public String getProfileCity() {
		return profileCity;
	}

	public void setProfileCity(String profileCity) {
		this.profileCity = profileCity;
	}

	public String getProfileState() {
		return profileState;
	}

	public void setProfileState(String profileState) {
		this.profileState = profileState;
	}

	public String getProfilePostalCode() {
		return profilePostalCode;
	}

	public void setProfilePostalCode(String profilePostalCode) {
		this.profilePostalCode = profilePostalCode;
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

	public String getProfileTitle() {
		return profileTitle;
	}

	public void setProfileTitle(String profileTitle) {
		this.profileTitle = profileTitle;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getIsEmailPublic() {
		return isEmailPublic;
	}

	public void setIsEmailPublic(String isEmailPublic) {
		this.isEmailPublic = isEmailPublic;
	}

	public String getIsPhonePublic() {
		return isPhonePublic;
	}

	public void setIsPhonePublic(String isPhonePublic) {
		this.isPhonePublic = isPhonePublic;
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

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Long getProfileCreateDate() {
		return profileCreateDate;
	}

	public void setProfileCreateDate(Long profileCreateDate) {
		this.profileCreateDate = profileCreateDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public List<EducationInfo> getEducationInfo() {
		return educationInfo;
	}

	public void setEducationInfo(List<EducationInfo> educationInfo) {
		this.educationInfo = educationInfo;
	}

	public List<CertificationInfo> getCertificationInfo() {
		return certificationInfo;
	}

	public void setCertificationInfo(List<CertificationInfo> certificationInfo) {
		this.certificationInfo = certificationInfo;
	}

	public List<ExperienceInfo> getExperienceInfo() {
		return experienceInfo;
	}

	public void setExperienceInfo(List<ExperienceInfo> experienceInfo) {
		this.experienceInfo = experienceInfo;
	}

	public List<PublicationInfo> getPublicationInfo() {
		return publicationInfo;
	}

	public void setPublicationInfo(List<PublicationInfo> publicationInfo) {
		this.publicationInfo = publicationInfo;
	}

	public List<PatentInfo> getPatentInfo() {
		return patentInfo;
	}

	public void setPatentInfo(List<PatentInfo> patentInfo) {
		this.patentInfo = patentInfo;
	}

	public List<SkillMatrixInfo> getSkillMatrixInfo() {
		return skillMatrixInfo;
	}

	public void setSkillMatrixInfo(List<SkillMatrixInfo> skillMatrixInfo) {
		this.skillMatrixInfo = skillMatrixInfo;
	}

	public List<RecomendationInfo> getRecomendationInfo() {
		return recomendationInfo;
	}

	public void setRecomendationInfo(List<RecomendationInfo> recomendationInfo) {
		this.recomendationInfo = recomendationInfo;
	}

	public List<Membership> getMembership() {
		return membership;
	}

	public void setMembership(List<Membership> membership) {
		this.membership = membership;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	

}
