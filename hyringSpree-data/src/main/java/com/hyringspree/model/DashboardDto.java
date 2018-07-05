package com.hyringspree.model;

public class DashboardDto {

	private Integer totalRecruitedJobs;
	private Long totalEmployer;
	private Long totalJobseeker;
	private Long totalJobs;

	public Integer getTotalRecruitedJobs() {
		return totalRecruitedJobs;
	}

	public void setTotalRecruitedJobs(Integer totalRecruitedJobs) {
		this.totalRecruitedJobs = totalRecruitedJobs;
	}

	public Long getTotalEmployer() {
		return totalEmployer;
	}

	public void setTotalEmployer(Long totalEmployer) {
		this.totalEmployer = totalEmployer;
	}

	public Long getTotalJobseeker() {
		return totalJobseeker;
	}

	public void setTotalJobseeker(Long totalJobseeker) {
		this.totalJobseeker = totalJobseeker;
	}

	public Long getTotalJobs() {
		return totalJobs;
	}

	public void setTotalJobs(Long totalJobs) {
		this.totalJobs = totalJobs;
	}

}
