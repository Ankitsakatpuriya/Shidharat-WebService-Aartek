package com.hyringspree.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyringspree.model.Compensation;
import com.hyringspree.model.ImmigrationStatus;
import com.hyringspree.model.JobType;
import com.hyringspree.model.TexTerm;

@Service
public interface JobExtraFieldsService {

	/**
	 * Get JobType
	 * 
	 * 
	 * @return List
	 */
	public List<JobType> getjobTypeData();

	/**
	 * Get TexTerm
	 * 
	 * 
	 * @return List
	 */
	public List<TexTerm> getTexTermData();

	/**
	 * Get Immigration
	 * 
	 * 
	 * @return List
	 */
	public List<ImmigrationStatus> getImmigrationStatusData();

	/**
	 * Get Immigration
	 * 
	 * 
	 * @return List
	 */
	public List<Compensation> getCompensationData();
}
