package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.EducationInfo;

public interface EducationInfoRepository {
	
	public boolean deleteEducationInfo(Integer educationId);
	
	public EducationInfo editEducationInfo(Integer educationId);
	
	public boolean saveJobEducationDetails(EducationInfo educationInfo);
	
	public boolean updateEducationInfo(EducationInfo updatedEducationInfo);
	
	public List<EducationInfo> getEducationInfoByProfileId(Integer profileId);

}
