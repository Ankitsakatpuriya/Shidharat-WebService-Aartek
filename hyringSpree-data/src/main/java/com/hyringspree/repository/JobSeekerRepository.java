package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.ProfileInfo;
import com.hyringspree.model.ProfileInfoDTO;

public interface JobSeekerRepository {

	public String saveJobSeekersDetails(ProfileInfo profileInfo);
	
	public ProfileInfo editJobSeekerProfile(Integer profileId);
	
	public boolean deleteJobSeeker(Integer profileId);
	
	public ProfileInfo updateJobSeekerProfile(ProfileInfo jobSeekerUpdateProfile);
	
	public List<ProfileInfo> searchProfileByProfileId(ProfileInfo profileInfo);
	
	public List<ProfileInfo> searchJobSeekerProfileByKeywords(ProfileInfoDTO profileInfo);
	
	public List<ProfileInfo> getJobseekerByProfileId(Integer profileId);
	
	public String checkJobSeekerEmailId(String EmailId);
	
	public Long countOfAllJobSeeker();

}
