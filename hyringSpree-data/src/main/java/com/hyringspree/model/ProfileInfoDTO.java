package com.hyringspree.model;

public class ProfileInfoDTO {

	private Integer profileId;
	private Integer jobApplied;
	private String jobRole;
	private String experience;
	private String email;
	private String profileFname;
	private String imageFile;
	private Long profileEndDate;
	private Long profileCreateDate;
	private String profilePostalCode;

	public ProfileInfoDTO(ProfileInfo profileInfo) {
		this.profileId = profileInfo.getProfileId() != null ? profileInfo.getProfileId() : null;
		this.jobApplied = 32;
		this.jobRole = profileInfo.getExperienceInfo().size() != 0 ? profileInfo.getExperienceInfo().get(0).getJobRole()
				: null;
		this.email = profileInfo.getProfileEmail() != null ? profileInfo.getProfileEmail() : null;
		this.profileFname = profileInfo.getProfileFname() != null ? profileInfo.getProfileFname() : null;
		this.experience = profileInfo.getExperience() != null ? profileInfo.getExperience() : null;
		this.imageFile = profileInfo.getImageFile() != null ? profileInfo.getImageFile() : null;
	}

	public String getProfilePostalCode() {
		return profilePostalCode;
	}

	public void setProfilePostalCode(String profilePostalCode) {
		this.profilePostalCode = profilePostalCode;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public Integer getJobApplied() {
		return jobApplied;
	}

	public void setJobApplied(Integer jobApplied) {
		this.jobApplied = jobApplied;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfileFname() {
		return profileFname;
	}

	public void setProfileFname(String profileFname) {
		this.profileFname = profileFname;
	}

	public Long getProfileEndDate() {
		return profileEndDate;
	}

	public void setProfileEndDate(Long profileEndDate) {
		this.profileEndDate = profileEndDate;
	}

	public Long getProfileCreateDate() {
		return profileCreateDate;
	}

	public void setProfileCreateDate(Long profileCreateDate) {
		this.profileCreateDate = profileCreateDate;
	}

}
