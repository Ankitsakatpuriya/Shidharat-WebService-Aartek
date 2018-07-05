package com.hyringspree.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.hyringspree.model.ProfileInfo;
import com.hyringspree.model.ProfileInfoDTO;
import com.hyringspree.model.User;

public interface JobSeekerService {

	/**
	 * Save JobSeeker
	 * 
	 * @param String
	 *            jobSeeker
	 */
	public boolean saveJobSeekersDetails(ProfileInfo profileInfo);

	/**
	 * Edit JobSeeker
	 *
	 * @param Integer
	 *            id
	 * @return jobSeeker
	 */

	public ProfileInfo editJobSeekerProfile(Integer profileId);

	//
	//
	// /**
	// * Edit JobSeeker
	// *
	// * @param Integer
	// * id
	// * @return jobSeeker
	// */
	// public JobSeeker editJobSeeker(Integer id);
	//
	//
	/**
	 * Delete JobSeeker
	 *
	 * @param Integer
	 *            id
	 */

	public boolean deleteJobSeeker(Integer profileId);

	//
	// /**
	// * Get JobSeeker
	// *
	// * @return list
	// */
	//
	// public List getAllJobSeekersDtails();
	//
	// /**
	// * Get JobSeeker
	// *
	// * @param String
	// * jobSeeker
	// */
	//
	public ProfileInfo updateJobSeekerProfile(ProfileInfo jobSeekerUpdateProfile);
	//
	//
	// /**
	// * searchJobseekerData
	// *
	// * @param jobSeeker
	// *
	// * @return list
	// */
	// public List<JobSeeker> searchJobseekerData(JobSeeker jobseeker);

	public List<ProfileInfo> searchProfileByProfileId(ProfileInfo profileInfo);

	// public void jbseekerCreateProfileDetailsWithImage();

	public List<ProfileInfoDTO> searchJobSeekerProfileByKeywords(ProfileInfoDTO profileInfo);

	public List<ProfileInfo> getJobseekerByProfileId(Integer profileId);

	public boolean sendProfilePdf(ProfileInfo pdfDetail) throws IOException;

	public String checkJobSeekerEmailId(String EmailId);
}
