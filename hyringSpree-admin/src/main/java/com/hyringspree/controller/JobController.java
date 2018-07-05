package com.hyringspree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.hyringspree.model.JobFilterDTO;
import com.hyringspree.model.JobInfo;
import com.hyringspree.service.JobService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class JobController {
	@Autowired
	private JobService jobService;

	/**
	 * Save Job
	 * 
	 * @param String
	 *            job
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path = IConstant.SAVE_SINGLEJOB)
	public String saveSingleJob(@RequestBody String job) throws Exception {
		JobInfo jobDetails = new Gson().fromJson(job, JobInfo.class);
		return jobService.saveSingleJob(jobDetails);
	}

	/**
	 * Edit job
	 * 
	 * @param Integer
	 *            jobId
	 * @return job
	 * 
	 */

	@GetMapping(path = IConstant.EDIT_JOBINFO_JOBID)
	public JobInfo editJobInfo(@PathVariable Integer jobId) {
		return jobService.editJobInfo(jobId);
	}

	/**
	 * Delete Job
	 * 
	 * @param Integer
	 *            jobId
	 */
	@DeleteMapping(path = IConstant.DELETE_JOB_JOBID)
	public String deleteJob(@PathVariable("jobId") Integer jobId) {
		boolean status = jobService.deleteJob(jobId);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	/**
	 * Get Job
	 * 
	 * 
	 * @return List
	 */
	@GetMapping(path = IConstant.GET_ALLJOBS_DETAILS)
	public List getAllJobsDetails() {
		return jobService.getAllJobsDetails();
	}

	/**
	 * Save MultipleJob
	 * 
	 * @throws Exception
	 * 
	 * 
	 */

	@PostMapping(path = IConstant.SAVE_MULTIPLEJOB)
	public String saveMultipleJob(@RequestParam("fileType") String fileTypee, @RequestParam("file") MultipartFile file,
			@RequestParam("recruiterId") String recruiterId, @RequestParam("companyId") String companyId)
			throws Exception {

		MultipartFile filee = null;
		String fileType = fileTypee;
		return jobService.saveMultipleJob(file, fileType, recruiterId, companyId);
	}

	@PostMapping(path = IConstant.SEARCH_JOB_BY_SELECTION)
	public List<JobInfo> searchJobBySelection(@RequestBody String selection) {

		Gson gson = new Gson();
		JobInfo searchJob = gson.fromJson(selection, JobInfo.class);

		return jobService.searchJobBySelection(searchJob);

	}

	@PostMapping(path = IConstant.SEARCH_JOB_FILTER_FOR_HOMEPAGE)
	public List<JobInfo> searchJobFilterForHomePage(@RequestBody String jobFilterForHome) {
		Gson gson = new Gson();
		JobInfo searchJob = gson.fromJson(jobFilterForHome, JobInfo.class);
		return jobService.searchJobFilterForHomePage(searchJob);
	}

	/**
	 * @param jobInfo
	 * @return
	 */
	@PostMapping(path = IConstant.UPDATE_JOBINFO)
	public String updateJobInfo(@RequestBody String jobInfo) {
		System.out.println("jobInfo.........." + jobInfo);
		Gson gson = new Gson();
		JobInfo updateJobInfo = gson.fromJson(jobInfo, JobInfo.class);
		boolean status = jobService.updateJobInfo(updateJobInfo);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@PostMapping(path = IConstant.GET_JOB_BY_FILTER)
	public List<JobInfo> getJobsByFilter(@RequestBody String jobFilter) {
		Gson gson = new Gson();
		JobFilterDTO filterJobs = gson.fromJson(jobFilter, JobFilterDTO.class);
		return jobService.getJobsByFilter(filterJobs);
	}

}
