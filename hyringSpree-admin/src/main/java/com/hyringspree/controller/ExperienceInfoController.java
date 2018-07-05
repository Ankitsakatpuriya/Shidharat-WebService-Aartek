package com.hyringspree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.ExperienceInfo;
import com.hyringspree.service.ExperienceInfoService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class ExperienceInfoController {

	@Autowired
	private ExperienceInfoService experienceService;

	/**
	 * @param experienceId
	 */
	@DeleteMapping(path = IConstant.DELETE_EXPERIENCEINFO_EXPERIENCEID)
	public String deleteExperienceInfo(@PathVariable("experienceId") Integer experienceId) {
		boolean status = experienceService.deleteExperienceInfo(experienceId);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path = IConstant.EDIT_EXPERIENCEINFO_EXPERIENCEID)
	public ExperienceInfo editExperienceInfo(@PathVariable Integer experienceId) {

		return experienceService.editExperienceInfo(experienceId);

	}

	/**
	 * Save jobSeekerExperience
	 * 
	 * @param String
	 *            experienceInfo
	 */
	@PostMapping(path = IConstant.SAVEJOBSEEKER_EXPERIENCE)
	public String saveExperience(@RequestBody String experienceInfo) {

		Gson gson = new Gson();
		ExperienceInfo experienceInfoDetails = gson.fromJson(experienceInfo, ExperienceInfo.class);
		boolean status = experienceService.saveExperience(experienceInfoDetails);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}

	}

	@PostMapping(path = IConstant.UPDATE_EXPERIENCEINFO)
	public String updateExperienceInfo(@RequestBody String experienceInfo) {
		Gson gson = new Gson();
		ExperienceInfo updatedExperienceInfo = gson.fromJson(experienceInfo, ExperienceInfo.class);
		boolean status = experienceService.updateExperienceInfo(updatedExperienceInfo);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path = IConstant.GET_EXPERIENCEINFO_BY_PROFILEID_PROFILEID)
	public List<ExperienceInfo> getExperienceInfoByProfileId(@PathVariable Integer profileId) {
		return experienceService.getExperienceInfoByProfileId(profileId);

	}
}
