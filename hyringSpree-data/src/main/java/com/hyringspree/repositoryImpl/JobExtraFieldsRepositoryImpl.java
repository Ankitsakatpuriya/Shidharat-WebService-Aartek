package com.hyringspree.repositoryImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.Compensation;
import com.hyringspree.model.ImmigrationStatus;
import com.hyringspree.model.JobType;
import com.hyringspree.model.TexTerm;
import com.hyringspree.repository.JobExtraFieldsRepository;

@Repository
public class JobExtraFieldsRepositoryImpl implements JobExtraFieldsRepository {

	@Autowired
	private SessionFactory factory;

	/**
	 * Get JobType
	 * 
	 * 
	 * @return List
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<JobType> getjobTypeData() {
		Session session = factory.openSession();
		Query<JobType> queryJobType = session.createQuery("from JobType");
		List<JobType> jobTypeList = queryJobType.list();
		session.close();
		return jobTypeList;
	}

	/**
	 * Get TexTerm
	 * 
	 * 
	 * @return List
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<TexTerm> getTexTermData() {
		Session session = factory.openSession();
		Query<TexTerm> queryTexTerm = session.createQuery("from TexTerm");
		List<TexTerm> texTermList = queryTexTerm.list();
		session.close();
		return texTermList;
	}

	/**
	 * Get Immigration
	 * 
	 * 
	 * @return List
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<ImmigrationStatus> getImmigrationStatusData() {
		Session session = factory.openSession();
		Query<ImmigrationStatus> queryImmigrationStatus = session.createQuery("from ImmigrationStatus");
		List<ImmigrationStatus> immigrationStatusList = queryImmigrationStatus.list();
		session.close();
		return immigrationStatusList;
	}

	/**
	 * Get Compensation
	 * 
	 * 
	 * @return List
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Compensation> getCompensationData() {
		Session session = factory.openSession();
		Query<Compensation> queryCompensation = session.createQuery("from Compensation");
		List<Compensation> compensationList = queryCompensation.list();
		session.close();
		return compensationList;
	}
}
