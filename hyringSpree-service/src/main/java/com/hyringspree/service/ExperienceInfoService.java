package com.hyringspree.service;

import java.util.List;

import com.hyringspree.model.ExperienceInfo;

public interface ExperienceInfoService {

	public boolean deleteExperienceInfo(Integer experienceId);

	public ExperienceInfo editExperienceInfo(Integer experienceId);

	/*
	 * Save JobSeekerExperience
	 * 
	 * @param String jobSeekerExperience
	 */
	public boolean saveExperience(ExperienceInfo experienceInfo);

	public boolean updateExperienceInfo(ExperienceInfo updatedExperienceInfo);

	public List<ExperienceInfo> getExperienceInfoByProfileId(Integer profileId);
}
