package com.hyringspree.service;

import java.util.List;

import com.hyringspree.model.RecruiterInfo;
import com.hyringspree.model.RecruiterInfoDto;

public interface RecruiterService {

	/**
	 * Save Recruiter
	 * 
	 * @param String
	 *            recruiter
	 * @return boolean
	 */
	public boolean saveRecruiter(RecruiterInfo recruiterDetails);

	/**
	 * Edit Recruiter
	 * 
	 * @param Integer
	 *            id
	 * @return Recruiter
	 * 
	 */
	public RecruiterInfo editRecruiter(Integer id);

	/**
	 * Delete Recruiter
	 * 
	 * @param Integer
	 *            id
	 * @return void
	 */
	public boolean deleteById(Integer id);

	/**
	 * Get Recruiter
	 * 
	 * 
	 * @return List
	 */
	public List getAllDetails();

	public List<RecruiterInfo> searchRecruiterByselection(RecruiterInfo recruiterDetail);

	public boolean updateRecruiterInfo(RecruiterInfo updateRecruiterInfo);

	public List<RecruiterInfo> searchByRecruiterFilter(RecruiterInfoDto recruiterfilter);

	public String checkEmployerEmailId(String emailId);

}
