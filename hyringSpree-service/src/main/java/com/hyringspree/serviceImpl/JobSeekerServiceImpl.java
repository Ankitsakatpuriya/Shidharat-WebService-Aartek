package com.hyringspree.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.common.util.MailUtility;
import com.hyringspree.model.ProfileInfo;
import com.hyringspree.model.ProfileInfoDTO;
import com.hyringspree.repository.JobSeekerRepository;
import com.hyringspree.service.JobSeekerService;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {
	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Autowired
	private MailUtility mailUtility;

	/**
	 * save JobSeekersDetails
	 * 
	 * @param profileInfo
	 *            profileInfo
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveJobSeekersDetails(ProfileInfo profileInfo) {
		String emailId = jobSeekerRepository.saveJobSeekersDetails(profileInfo);
		if (emailId != null) {
			MailUtility.sendMailForRegistration(emailId);
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public ProfileInfo editJobSeekerProfile(Integer profileId) {
		return jobSeekerRepository.editJobSeekerProfile(profileId);
	}

	//
	// /**
	// * Edit JobSeeker
	// *
	// * @param Integer
	// * id
	// * @return jobSeeker
	// */
	// public JobSeeker editJobSeeker(Integer id) {
	// return jobSeekerRepository.editJobSeeker(id);
	// }
	//
	/**
	 * Delete JobSeeker
	 *
	 * @param Integer
	 *            profileId
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteJobSeeker(Integer profileId) {
		return jobSeekerRepository.deleteJobSeeker(profileId);

	}

	//
	// /**
	// * Get JobSeeker
	// *
	// * @return list
	// */
	// public List getAllJobSeekersDtails() {
	// return jobSeekerRepository.getAllJobSeekersDtails();
	// }
	//
	/**
	 * save JobSeeker
	 * 
	 * @param JobSeeker
	 *            jobSeeker
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public ProfileInfo updateJobSeekerProfile(ProfileInfo jobSeekerUpdateProfile) {
		return jobSeekerRepository.updateJobSeekerProfile(jobSeekerUpdateProfile);
	}

	// /**
	// * searchJobseekerData
	// *
	// * @param jobSeeker
	// *
	// * @return list
	// */
	// public List<JobSeeker> searchJobseekerData(JobSeeker jobseeker) {
	// return jobSeekerRepository.searchJobseekerData(jobseeker);
	// }

	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProfileInfo> searchProfileByProfileId(ProfileInfo profileInfo) {
		return jobSeekerRepository.searchProfileByProfileId(profileInfo);
	}

	// public void jbseekerCreateProfileDetailsWithImage() {
	// jobSeekerRepository.jbseekerCreateProfileDetailsWithImage();
	// }

	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProfileInfoDTO> searchJobSeekerProfileByKeywords(ProfileInfoDTO profileInfo) {
		List<ProfileInfo> profileList = jobSeekerRepository.searchJobSeekerProfileByKeywords(profileInfo);
		List<ProfileInfoDTO> profileInfoDTO = new ArrayList<ProfileInfoDTO>();
		for (ProfileInfo profileInfoData : profileList) {
			ProfileInfoDTO profileInfoDto = new ProfileInfoDTO(profileInfoData);
			profileInfoDTO.add(profileInfoDto);
		}
		return profileInfoDTO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProfileInfo> getJobseekerByProfileId(Integer profileId) {
		return jobSeekerRepository.getJobseekerByProfileId(profileId);
	}

	// @Transactional(propagation = Propagation.REQUIRED)
	public boolean sendProfilePdf(ProfileInfo pdfDetail) throws IOException {
		String profileEmail = pdfDetail.getProfileEmail();
		Integer profileId = pdfDetail.getProfileId();
		System.out.println(profileEmail + profileId);
		if (profileEmail != null) {
			mailUtility.sendMailProfilePdf(profileEmail, profileId);
			return true;
		} else {
			return false;
		}
	}

	public String checkJobSeekerEmailId(String EmailId) {
		return jobSeekerRepository.checkJobSeekerEmailId(EmailId);
	}

}
