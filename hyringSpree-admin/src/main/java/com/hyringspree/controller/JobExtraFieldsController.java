package com.hyringspree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyringspree.model.Compensation;
import com.hyringspree.model.ImmigrationStatus;
import com.hyringspree.model.JobType;
import com.hyringspree.model.TexTerm;
import com.hyringspree.service.JobExtraFieldsService;
import com.hyringspree.util.IConstant;

@RestController
public class JobExtraFieldsController {

	@Autowired
	private JobExtraFieldsService jobExtraFieldsService;

	/**
	 * Get JobType
	 * 
	 * 
	 * @return List
	 */
	@GetMapping(path = IConstant.GET_JOBTYPE_DATA)
	public List<JobType> getJobTypeData() {
		return jobExtraFieldsService.getjobTypeData();
	}

	/**
	 * Get TexTerm
	 * 
	 * 
	 * @return List
	 */
	@GetMapping(path = IConstant.GET_TEXTERM_DATA)
	public List<TexTerm> getTexTermData() {
		return jobExtraFieldsService.getTexTermData();
	}

	/**
	 * Get Immigration
	 * 
	 * 
	 * @return List
	 */
	@GetMapping(path = IConstant.GET_IMMIGRATINON_DATA)
	public List<ImmigrationStatus> getImmigrationStatusData() {
		return jobExtraFieldsService.getImmigrationStatusData();
	}

	/**
	 * Get Compensation
	 * 
	 * 
	 * @return List
	 */
	@GetMapping(path = IConstant.GET_COMPENSATION_DATA)
	public List<Compensation> getCompensationData() {
		return jobExtraFieldsService.getCompensationData();
	}
}
