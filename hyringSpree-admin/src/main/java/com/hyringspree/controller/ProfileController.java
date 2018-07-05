package com.hyringspree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.Profile;
import com.hyringspree.service.ProfileService;
import com.hyringspree.util.IConstant;

@RestController
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	/**
	 * Save Profile
	 * 
	 * @param String
	 *            profile
	 * @return String
	 */
	@PostMapping(path = IConstant.SAVE_PROFILE)
	public String saveProfile(@RequestBody String profile) {
		Gson gson = new Gson();
		Profile profileDetails = gson.fromJson(profile, Profile.class);
		boolean profileStatus = profileService.saveProfile(profileDetails);
		if (profileStatus) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}

	}

	/**
	 * Edit Profile
	 * 
	 * @param Integer
	 *            id
	 * @return Profile
	 */
	@PutMapping(path = IConstant.EDIT_PROFILE_ID)
	public Profile editProfile(@PathVariable("id") Integer id) {
		return profileService.editProfile(id);
	}

	/**
	 * Delete Profile
	 * 
	 * @param Integer
	 *            id
	 */
	@DeleteMapping(path = IConstant.DELETE_PROFILE_ID)
	public void deleteProfile(@PathVariable("id") Integer id) {
		profileService.deleteProfile(id);
	}

	/**
	 * Get Profiles
	 * 
	 * @return list
	 */
	@GetMapping(path = IConstant.GET_PROFILES)
	public List getProfiles() {
		return profileService.getProfiles();
	}
	
	
	
	@GetMapping(path = IConstant.GET_PROFILE_DETAIL_BYID)
	public List pdfForProfileDetail(@PathVariable Integer profileId) {
		return profileService.pdfForProfileDetail(profileId);
		
	}
}
