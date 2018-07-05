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
import com.hyringspree.model.EducationInfo;
import com.hyringspree.service.EducationInfoService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class EducationInfoController {

	@Autowired
	private EducationInfoService educationService;

	/**
	 * @param educationId
	 */
	@DeleteMapping(path = IConstant.DELETE_EDUCATIONINFO_EDUCATIONID)
	public String deleteEducationInfo(@PathVariable("educationId") Integer educationId) {

		boolean status = educationService.deleteEducationInfo(educationId);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path = IConstant.EDIT_EDUCATIONINFO_EDUCATIONID)
	public EducationInfo editEducationInfo(@PathVariable Integer educationId) {
		return educationService.editEducationInfo(educationId);

	}

	/**
	 * Save Education
	 *
	 * @param String
	 *            saveEducation
	 */
	@PostMapping(path = IConstant.SAVEJOBSEEKER_EDUCATION)
	public String saveEducation(@RequestBody String educationInfo) {

		Gson gson = new Gson();
		EducationInfo educationInfoDetails = gson.fromJson(educationInfo, EducationInfo.class);
		boolean status = educationService.saveEducationInfo(educationInfoDetails);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}

	}

	@PostMapping(path = IConstant.UPDATE_EDUCATIONINFO)
	public String updateEducationInfo(@RequestBody String educationInfo) {
		Gson gson = new Gson();
		EducationInfo updatedEducationInfo = gson.fromJson(educationInfo, EducationInfo.class);
		boolean status = educationService.updateEducationInfo(updatedEducationInfo);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path = IConstant.GET_EDUCATIONINFO_BY_PROFILEID_PROFILEID)
	public List<EducationInfo> getEducationInfoByProfileId(@PathVariable Integer profileId) {
		return educationService.getEducationInfoByProfileId(profileId);

	}

}
