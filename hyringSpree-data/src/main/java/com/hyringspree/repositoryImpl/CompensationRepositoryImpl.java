package com.hyringspree.repositoryImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.Compensation;
import com.hyringspree.repository.CompensationRepository;

@Repository
public class CompensationRepositoryImpl implements CompensationRepository {
	
	@Autowired
	private SessionFactory factory;
	
	
	/**
	 * @param compensationId
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void deleteCompensation(Integer compensationId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Compensation profile = session.get(Compensation.class, compensationId);
		session.delete(profile);
		transaction.commit();
		session.close();
	}
	

}
