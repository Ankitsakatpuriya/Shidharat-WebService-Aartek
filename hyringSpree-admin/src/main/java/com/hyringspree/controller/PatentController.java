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
import com.hyringspree.model.PatentInfo;
import com.hyringspree.service.PatentService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class PatentController {

	@Autowired
	private PatentService patentservice;

	@GetMapping(path = IConstant.EDIT_PATENTINFO_PATENTID)
	public PatentInfo editPatentInfo(@PathVariable Integer patentId) {
		return patentservice.editPatentInfo(patentId);

	}

	@DeleteMapping(path = IConstant.DELETE_PATANTINFO_PATENTID)
	public String deletePatentInfo(@PathVariable("patentId") Integer patentId) {
		boolean status = patentservice.deletePatentInfo(patentId);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	/**
	 * Save Patent
	 *
	 * @param String
	 *            patentInfo
	 */
	@PostMapping(path = IConstant.SAVEJOBSEEKER_PATENT)
	public String savePatent(@RequestBody String patentInfo) {
		Gson gson = new Gson();
		PatentInfo patentInfoDetails = gson.fromJson(patentInfo, PatentInfo.class);
		boolean status = patentservice.savePatentInfo(patentInfoDetails);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}

	}

	@PostMapping(path = IConstant.UPDATE_PATENTINFO)
	public String updatePatentInfo(@RequestBody String patentInfo) {
		Gson gson = new Gson();
		PatentInfo updatePatentInfo = gson.fromJson(patentInfo, PatentInfo.class);
		boolean status = patentservice.updatePatentInfo(updatePatentInfo);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path = IConstant.GET_PATENTINFO_BY_PROFILEID_PROFILEID)
	public List<PatentInfo> getPatentInfo(@PathVariable Integer profileId) {
		return patentservice.getPatentInfo(profileId);
	}
}
