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
import com.hyringspree.model.RecruiterInfo;
import com.hyringspree.model.RecruiterInfoDto;
import com.hyringspree.service.RecruiterService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class RecruiterController {
	@Autowired
	private RecruiterService recruiterService;

	/**
	 * Save Recruiter
	 * 
	 * @param String
	 *            recruiter
	 * @return boolean
	 */
	@PostMapping(path = IConstant.SAVE_RECRUITER)
	public String saveRecruiter(@RequestBody String recruiter) {
		Gson gson = new Gson();
		RecruiterInfo recruiterDetails = gson.fromJson(recruiter, RecruiterInfo.class);
		boolean status = recruiterService.saveRecruiter(recruiterDetails);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}

	}

	@PostMapping(path = IConstant.SEARCH_RECRUITER_BY_SELECTION)
	public List<RecruiterInfo> searchRecruiterByselection(@RequestBody String searchSelections) {
		Gson gson = new Gson();
		RecruiterInfo recruiterDetail = gson.fromJson(searchSelections, RecruiterInfo.class);
		return recruiterService.searchRecruiterByselection(recruiterDetail);
	}
	
	    @PostMapping(path=IConstant.SEARCH_BY_RECRUITER_FILTER)
	    public List<RecruiterInfo> searchByRecruiterFilter(@RequestBody String searchFilter){
		Gson gson=new Gson();
		RecruiterInfoDto recruiterfilter=gson.fromJson(searchFilter,RecruiterInfoDto.class);
		return recruiterService.searchByRecruiterFilter(recruiterfilter);
		
	}

	/**
	 * Edit Recruiter
	 * 
	 * @param Integer
	 *            id
	 * @return job
	 * 
	 */
	 @GetMapping(path=IConstant.EDIT_RECRUITER_ID)
	public RecruiterInfo edit(@PathVariable("id") Integer id) {
		return recruiterService.editRecruiter(id);
	}

	/**
	 * Delete Recruiter
	 * 
	 * @param Integer
	 *            id
	 * @return void
	 */
	@DeleteMapping(path=IConstant.DELETE_RECRUITER_ID)
	public String delete(@PathVariable("id") Integer id) {
		boolean status = recruiterService.deleteById(id);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	/**
	 * Get Recruiter
	 * 
	 * 
	 * @return List
	 */
	@GetMapping(path=IConstant.GET_ALL_RECRUITER_DETAILS)
	public List getAllRecruiterDetails() {
		return recruiterService.getAllDetails();
	}

	@PostMapping(path = IConstant.UPDATE_RECRUITERINFO)
	public String updateRecruiterInfo(@RequestBody String recruiterInfo) {
		Gson gson = new Gson();
		RecruiterInfo updateRecruiterInfo = gson.fromJson(recruiterInfo, RecruiterInfo.class);
		boolean status = recruiterService.updateRecruiterInfo(updateRecruiterInfo);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}
	@GetMapping(path = IConstant.CHECK_EMPLOYER_BY_EMAILID)
	public String checkEmployerEmailId(@PathVariable String emailId) {
		return recruiterService.checkEmployerEmailId(emailId);

	}
}
