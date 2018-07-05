package com.hyringspree.repositoryImpl;

import static com.hyringspree.util.Dateutills.generateIdFormat;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.PatentInfo;
import com.hyringspree.repository.PatentRepository;

@Repository
public class PatentRepositoryImpl implements PatentRepository {
	@Autowired
	private SessionFactory factory;

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PatentInfo editPatentInfo(Integer patentId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		PatentInfo patentInfo = session.get(PatentInfo.class, patentId);
		session.close();
		return patentInfo;

	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deletePatentInfo(Integer patentId) {
		if (patentId != null) {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			PatentInfo profile = session.get(PatentInfo.class, patentId);
			Boolean status = profile.getDeleteStatus();
			if (status) {
				profile.setDeleteStatus(false);
			}

			session.saveOrUpdate(profile);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get Patent MaxId
	 * 
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getPatentMaxId() {

		String sqlQuery = "select max(patentId) from PatentInfo";
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery(sqlQuery);

		Integer maxProfileId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;

		transaction.commit();
		session.close();

		return maxProfileId;
	}

	/**
	 * save JobPatentDetails
	 * 
	 * @param PatentInfo
	 *            patentInfo
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean saveJobPatentDetails(PatentInfo patentInfo) {

		Integer incrementiId = 0;
		Integer maxResult = getPatentMaxId();
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}
		if (patentInfo != null) {
			String formatedProfileId = idFormat + incrementiId;
			patentInfo.setPatentId(Integer.parseInt(formatedProfileId));
			patentInfo.setDeleteStatus(true);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			Long convertTime;

			convertTime = timestamp.getTime();

			patentInfo.setCreateTs(convertTime);
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(patentInfo);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updatePatentInfo(PatentInfo updatePatentInfo) {
		if (updatePatentInfo.getPatentId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(updatePatentInfo);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PatentInfo> getPatentInfo(Integer profileId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<PatentInfo> patentList = null;
		String queryString = "select * from patent_info where profile_id = ?1 and delete_status = true";
		Query query = session.createSQLQuery(queryString).addEntity(PatentInfo.class);
		query.setParameter(1, profileId);
		patentList = query.getResultList();
		transaction.commit();
		session.close();
		return patentList;
	}

}
