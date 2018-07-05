package com.hyringspree.service;

import java.util.List;

import com.hyringspree.model.EducationInfo;

public interface EducationInfoService {

	public boolean deleteEducationInfo(Integer educationId);

	public EducationInfo editEducationInfo(Integer educationId);

	/*
	 * Save Education
	 * 
	 * @param String EducationInfo
	 */
	public boolean saveEducationInfo(EducationInfo educationId);

	public boolean updateEducationInfo(EducationInfo updatedEducationInfo);

	public List<EducationInfo> getEducationInfoByProfileId(Integer profileId);

}
