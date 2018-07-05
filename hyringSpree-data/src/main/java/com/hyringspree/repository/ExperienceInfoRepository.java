package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.ExperienceInfo;

public interface ExperienceInfoRepository {

	public boolean deleteExperienceInfo(Integer experienceId);

	public ExperienceInfo editExperienceInfo(Integer experienceId);

	public boolean saveJobExperienceDetails(ExperienceInfo experienceInfo);

	public boolean updateExperienceInfo(ExperienceInfo updatedExperienceInfo);

	public List<ExperienceInfo> getExperienceInfoByProfileId(Integer profileId);

}
