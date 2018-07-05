package com.hyringspree.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.ExperienceInfo;
import com.hyringspree.repository.ExperienceInfoRepository;
import com.hyringspree.service.ExperienceInfoService;

@Service
public class ExperienceInfoServiceImpl implements ExperienceInfoService {

	@Autowired
	private ExperienceInfoRepository experienceRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteExperienceInfo(Integer experienceId) {
		return experienceRepository.deleteExperienceInfo(experienceId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public ExperienceInfo editExperienceInfo(Integer experienceId) {
		return experienceRepository.editExperienceInfo(experienceId);
	}

	/*
	 * save JobSeekerExperience
	 * 
	 * @param experienceInfo jobSeekerExperience
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveExperience(ExperienceInfo experienceInfo) {
		return experienceRepository.saveJobExperienceDetails(experienceInfo);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateExperienceInfo(ExperienceInfo updatedExperienceInfo) {
		return experienceRepository.updateExperienceInfo(updatedExperienceInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<ExperienceInfo> getExperienceInfoByProfileId(Integer profileId) {
		return experienceRepository.getExperienceInfoByProfileId(profileId);

	}

}
