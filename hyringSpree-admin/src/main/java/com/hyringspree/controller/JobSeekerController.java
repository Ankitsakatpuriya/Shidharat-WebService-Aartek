package com.hyringspree.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.ProfileInfo;
import com.hyringspree.model.ProfileInfoDTO;
import com.hyringspree.service.JobSeekerService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class JobSeekerController {

	@Autowired
	private JobSeekerService jobSeekerService;
	@Autowired
    private HttpServletResponse res;

	// /**
	// * Save JobSeeker
	// *
	// * @param String
	// * jobSeeker
	// */
	//
	@PostMapping(path = IConstant.SAVEJOBSEEKER_DETAILS)
	public String saveJobSeekersDetails(@RequestBody String profileInfo) {

		Gson gson = new Gson();
		ProfileInfo jobSeekerDetails = gson.fromJson(profileInfo, ProfileInfo.class);

		boolean jobseekerStatus = jobSeekerService.saveJobSeekersDetails(jobSeekerDetails);
		if (jobseekerStatus) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	/*
	 * Edit JobSeeker
	 *
	 * @param Integer profileId
	 * 
	 * @return jobSeeker
	 */

	@GetMapping(path = IConstant.EDIT_JOBSEEKER_PROFILE_PROFILEID)
	public ProfileInfo editJobSeekerProfile(@PathVariable Integer profileId) {

		return jobSeekerService.editJobSeekerProfile(profileId);
	}

	//
	// /**
	// * Delete JobSeeker
	// *
	// * @param Integer
	// * id
	// */
	@DeleteMapping(path = IConstant.DELETE_JOBSEEKER_PROFILEID)
	public String deleteJobSeeker(@PathVariable Integer profileId) {
		boolean status = jobSeekerService.deleteJobSeeker(profileId);

		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}


	/**
	 * Update JobSeeker
	 * 
	 * @param String
	 */
	@PostMapping(path = IConstant.UPDATE_JOBSEEKER_PROFILE)
	public ProfileInfo updateJobSeekerProfile(@RequestBody String profileInfo) throws IOException 
	{    
		Gson gson = new Gson();
		ProfileInfo jobSeekerUpdateProfile = gson.fromJson(profileInfo, ProfileInfo.class);
	    return jobSeekerService.updateJobSeekerProfile(jobSeekerUpdateProfile);
		
	}
	

	@PostMapping(path = IConstant.SEARCH_PROFILE_BY_PROFILEID)
	public List<ProfileInfo> searchProfileByProfileId(@RequestBody String selectedData) {
		Gson gson = new Gson();
		ProfileInfo profileInfo = gson.fromJson(selectedData, ProfileInfo.class);
		List<ProfileInfo> profileList = jobSeekerService.searchProfileByProfileId(profileInfo);
		return profileList;
	}

	@PostMapping(path = IConstant.SEARCH_JOBSEEKER_PROFILE_BY_KEYWORDS)
	public List<ProfileInfoDTO> searchJobSeekerProfileByKeywords(@RequestBody String searchData) {

		Gson gson = new Gson();
		ProfileInfoDTO profileInfo = gson.fromJson(searchData, ProfileInfoDTO.class);

		return jobSeekerService.searchJobSeekerProfileByKeywords(profileInfo);
	}

	@GetMapping(path = IConstant.GET_JOBSEEKER_BY_PROFILEID)
	public List<ProfileInfo> getJobseekerByProfileId(@PathVariable Integer profileId) {
		return jobSeekerService.getJobseekerByProfileId(profileId);

	}

	@PostMapping(path = IConstant.SEND_PROFILE_PDFMAIL)
	public boolean sendProfilePdf(@RequestBody String sendEmailObj) throws IOException {
		Gson gson = new Gson();
		ProfileInfo pdfDetail = gson.fromJson(sendEmailObj, ProfileInfo.class);
		return jobSeekerService.sendProfilePdf(pdfDetail);

	}
	
	@GetMapping(path = IConstant.CHECK_JOBSEEKER_BY_EMAILID)
	public String checkJobSeekerEmailId(@PathVariable String emailId) {
		return jobSeekerService.checkJobSeekerEmailId(emailId);

	}
	
}
