package com.hyringspree.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hyringspree.model.JobFilterDTO;
import com.hyringspree.model.JobInfo;

public interface JobService {
	/**
	 * Save Job
	 * 
	 * @param Job
	 *            jobDetails
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public String saveSingleJob(JobInfo jobInfo) throws Exception;

	/**
	 * Save Job
	 * 
	 * @param Job
	 *            jobDetails
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public String saveMultipleJob(MultipartFile file, String fileType, String recruiterId, String companyId)
			throws Exception;

	/**
	 * Edit Job Record
	 * 
	 * @param Integer
	 *            id
	 * 
	 * @return Job
	 * 
	 */

	public JobInfo editJobInfo(Integer jobId);

	/**
	 * Delete Job Record
	 * 
	 * @param Integer
	 *            id
	 * @return void
	 */
	public boolean deleteJob(Integer jobId);

	/**
	 * Get Job Record
	 * 
	 * 
	 * @return List
	 */
	public List getAllJobsDetails();

	/**
	 * Search Job By Selection
	 * 
	 * 
	 * @return List
	 */
	public List<JobInfo> searchJobBySelection(JobInfo searchJob);

	public List<JobInfo> searchJobFilterForHomePage(JobInfo searchJob);

	/**
	 * @param updateJobInfo
	 * @return
	 */
	public boolean updateJobInfo(JobInfo updateJobInfo);

	public List<JobInfo> getJobsByFilter(JobFilterDTO jobFilter);

}
