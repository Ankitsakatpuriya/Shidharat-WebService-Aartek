package com.hyringspree.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyringspree.model.DashboardDto;
import com.hyringspree.repository.JobRepository;
import com.hyringspree.repository.JobSeekerRepository;
import com.hyringspree.repository.RecruiterRepository;
import com.hyringspree.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private RecruiterRepository recruiterRepo;

	@Autowired
	private JobSeekerRepository jobseekerRepo;

	@Autowired
	private JobRepository jobRepo;

	public DashboardDto getALLCountForDashboard() {
		DashboardDto dashboardDto = new DashboardDto();
		dashboardDto.setTotalEmployer(recruiterRepo.countOfAllRecruiter());
		dashboardDto.setTotalJobs(jobRepo.countOfAllJobs());
		dashboardDto.setTotalJobseeker(jobseekerRepo.countOfAllJobSeeker());
		dashboardDto.setTotalRecruitedJobs(0);
		return dashboardDto;
	}

}
