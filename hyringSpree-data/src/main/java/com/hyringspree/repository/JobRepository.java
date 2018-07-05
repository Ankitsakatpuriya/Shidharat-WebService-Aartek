package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.JobFilterDTO;
import com.hyringspree.model.JobHavingError;
import com.hyringspree.model.JobInfo;

public interface JobRepository {

	public String saveMultipleJobs(JobInfo jobDetails, String recruiterId, String companyId);

	public String saveNullJob(JobHavingError jobDetails, String recruiterId, String companyId);

	public String saveSingleJobs(JobInfo jobDetails);

	public JobInfo editJobInfo(Integer jobId);

	public boolean deleteById(Integer jobId);

	public List getAllJobsDetails();

	public List<JobInfo> searchJobBySelection(JobInfo searchJob);

	public List<JobInfo> searchJobFilterForHomePage(JobInfo searchJob);

	public boolean updateJobInfo(JobInfo updateJobInfo);

	public List<JobInfo> getJobsByFilter(JobFilterDTO jobFilter);
	
	public Long countOfAllJobs();

}
