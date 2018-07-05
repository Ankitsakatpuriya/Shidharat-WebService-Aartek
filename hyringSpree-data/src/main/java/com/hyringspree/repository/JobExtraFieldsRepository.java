package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.Compensation;
import com.hyringspree.model.ImmigrationStatus;
import com.hyringspree.model.JobType;
import com.hyringspree.model.TexTerm;

public interface JobExtraFieldsRepository {
	
	public List<JobType> getjobTypeData();
	
	public List<TexTerm> getTexTermData();
	
	public List<ImmigrationStatus> getImmigrationStatusData();
	
	public List<Compensation> getCompensationData();

}
