package com.hyringspree.service;

import java.util.List;

import com.hyringspree.model.Profile;
import com.hyringspree.model.ProfileInfo;

public interface ProfileService {

	/**
	 * Save Profile
	 * 
	 * @param Profile
	 *            profileDetails
	 * @return boolean
	 */
	public boolean saveProfile(Profile profileDetails);

	/**
	 * Edit Profile
	 * 
	 * @param Integer
	 *            id
	 * @return Profile
	 */
	public Profile editProfile(Integer id);

	/**
	 * Delete Profile
	 * 
	 * @param Integer
	 *            id
	 */
	public void deleteProfile(Integer id);

	/**
	 * Get Profiles
	 * 
	 * @return list
	 */
	public List getProfiles();

	public List pdfForProfileDetail(Integer profileId);
}
