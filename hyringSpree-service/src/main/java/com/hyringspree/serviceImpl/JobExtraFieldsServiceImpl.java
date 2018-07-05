package com.hyringspree.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.Compensation;
import com.hyringspree.model.ImmigrationStatus;
import com.hyringspree.model.JobType;
import com.hyringspree.model.TexTerm;
import com.hyringspree.repository.JobExtraFieldsRepository;
import com.hyringspree.service.JobExtraFieldsService;

@Service
public class JobExtraFieldsServiceImpl implements JobExtraFieldsService {

	@Autowired
	private JobExtraFieldsRepository jobExtraFieldsRepository;

	/**
	 * Get JobType
	 * 
	 * 
	 * @return List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<JobType> getjobTypeData() {
		return jobExtraFieldsRepository.getjobTypeData();
	}

	/**
	 * Get TexTerm
	 * 
	 * 
	 * @return List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TexTerm> getTexTermData() {
		return jobExtraFieldsRepository.getTexTermData();
	}

	/**
	 * Get Immigration
	 * 
	 * 
	 * @return List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ImmigrationStatus> getImmigrationStatusData() {
		return jobExtraFieldsRepository.getImmigrationStatusData();
	}

	/**
	 * Get Compensation
	 * 
	 * 
	 * @return List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Compensation> getCompensationData() {
		return jobExtraFieldsRepository.getCompensationData();
	}

}
