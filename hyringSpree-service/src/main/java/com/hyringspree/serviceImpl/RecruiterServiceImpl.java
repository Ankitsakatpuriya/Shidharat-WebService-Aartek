package com.hyringspree.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.common.util.MailUtility;
import com.hyringspree.model.RecruiterInfo;
import com.hyringspree.model.RecruiterInfoDto;
import com.hyringspree.repository.RecruiterRepository;
import com.hyringspree.service.RecruiterService;

@Service
public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	private RecruiterRepository recruiterRepository;
	
	private static final SimpleDateFormat FORMATTER_DD_MM_YY = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Save Recruiter
	 * 
	 * @param String
	 *            recruiter
	 * @return boolean
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveRecruiter(RecruiterInfo recruiterDetails) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String createdDate = dateFormat.format(date);
		recruiterDetails.setRecruiterCreatedDate(createdDate);
		String emailId = recruiterRepository.saveRecruiter(recruiterDetails);
		if (emailId != null) {
			MailUtility.sendMailForRegistration(emailId);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Edit Recruiter
	 * 
	 * @param Integer
	 *            id
	 * @return Recruiter
	 * 
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public RecruiterInfo editRecruiter(Integer id) {
		return recruiterRepository.edieditRecruitert(id);
	}

	/**
	 * Delete Recruiter
	 * 
	 * @param Integer
	 *            id
	 * @return void
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteById(Integer id) {
		return recruiterRepository.deleteById(id);
	}

	/**
	 * Get Recruiter
	 * 
	 * 
	 * @return List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List getAllDetails() {
		return recruiterRepository.getAllDetails();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<RecruiterInfo> searchRecruiterByselection(RecruiterInfo recruiterDetail) {
		return recruiterRepository.searchRecruiterByselection(recruiterDetail);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateRecruiterInfo(RecruiterInfo updateRecruiterInfo) {

		return recruiterRepository.updateRecruiterInfo(updateRecruiterInfo);
	}
	

	@Transactional(propagation = Propagation.REQUIRED)
	public List<RecruiterInfo> searchByRecruiterFilter(RecruiterInfoDto recruiterfilter) {
		
		return recruiterRepository.searchByRecruiterFilter(recruiterfilter);
	}

	public String checkEmployerEmailId(String emailId) {
		return recruiterRepository.checkEmployerEmailId(emailId);
	}

}
