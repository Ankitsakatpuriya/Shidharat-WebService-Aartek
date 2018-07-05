package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.Profile;
import com.hyringspree.model.ProfileInfo;

public interface ProfileRepository {

	public Integer saveProfile(Profile profileDetails);
	
	public Profile editProfile(Integer id);
	
	public void deleteProfile(Integer id);
	
	public List getProfiles();

	public List pdfForProfileDetail(Integer profileId);
}
