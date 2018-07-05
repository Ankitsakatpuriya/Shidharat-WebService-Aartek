package com.hyringspree.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.EducationInfo;
import com.hyringspree.repository.EducationInfoRepository;
import com.hyringspree.service.EducationInfoService;

@Service
public class EducationInfoServiceImpl implements EducationInfoService {

	@Autowired
	private EducationInfoRepository educationRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteEducationInfo(Integer educationId) {
		return educationRepository.deleteEducationInfo(educationId);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public EducationInfo editEducationInfo(Integer educationId) {
		return educationRepository.editEducationInfo(educationId);
	}

	/*
	 * save JobSeekerExperience
	 * 
	 * @param experienceInfo jobSeekerExperience
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveEducationInfo(EducationInfo educationInfo) {
		return educationRepository.saveJobEducationDetails(educationInfo);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateEducationInfo(EducationInfo updatedEducationInfo) {

		return educationRepository.updateEducationInfo(updatedEducationInfo);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<EducationInfo> getEducationInfoByProfileId(Integer profileId) {
		
		return educationRepository.getEducationInfoByProfileId(profileId);
	}

}
