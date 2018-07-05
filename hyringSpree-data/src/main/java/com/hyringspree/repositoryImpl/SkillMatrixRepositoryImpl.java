package com.hyringspree.repositoryImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyringspree.model.SkillMatrixInfo;
import com.hyringspree.repository.SkillMatrixRepository;

@Repository
public class SkillMatrixRepositoryImpl implements SkillMatrixRepository {
	@Autowired
	private SessionFactory factory;

	public SkillMatrixInfo editSkillMatrix(Integer skillId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		SkillMatrixInfo skillMatrixInfo = session.get(SkillMatrixInfo.class, skillId);
		session.close();
		return skillMatrixInfo;
	}

	public boolean updateSkillMatrix(SkillMatrixInfo updateSkillMatrix) {
		if (updateSkillMatrix.getSkillId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(updateSkillMatrix);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

}
