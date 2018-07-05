package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.RecruiterInfo;
import com.hyringspree.model.RecruiterInfoDto;

public interface RecruiterRepository {

	public List<RecruiterInfo> searchRecruiterByselection(RecruiterInfo recruiterdetail);

	public String saveRecruiter(RecruiterInfo recruiterDetails);

	public RecruiterInfo edieditRecruitert(Integer id);

	public boolean deleteById(Integer recruiterId);

	public List getAllDetails();

	public boolean updateRecruiterInfo(RecruiterInfo updateRecruiterInfo);

	public List<RecruiterInfo> searchByRecruiterFilter(RecruiterInfoDto recruiterfilter);

	public String checkEmployerEmailId(String emailId);
	
	public Long countOfAllRecruiter();

}
