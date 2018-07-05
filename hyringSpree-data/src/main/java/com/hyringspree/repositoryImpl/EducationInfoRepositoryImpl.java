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

import com.hyringspree.model.EducationInfo;
import com.hyringspree.repository.EducationInfoRepository;

@Repository
public class EducationInfoRepositoryImpl implements EducationInfoRepository {

	@Autowired
	private SessionFactory factory;

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deleteEducationInfo(Integer educationId) {
		if (educationId != null) {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			EducationInfo profile = session.get(EducationInfo.class, educationId);
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

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public EducationInfo editEducationInfo(Integer educationId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		EducationInfo educationInfo = session.get(EducationInfo.class, educationId);
		session.close();
		return educationInfo;
	}

	/**
	 * Get Education MaxId
	 * 
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getEducationMaxId() {

		String sqlQuery = "select max(educationId) from EducationInfo";
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery(sqlQuery);

		Integer maxProfileId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;

		transaction.commit();
		session.close();

		return maxProfileId;
	}

	/**
	 * save JobEducationDetails
	 * 
	 * @param EducationInfo
	 *            educationInfo
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean saveJobEducationDetails(EducationInfo educationInfo) {

		Integer incrementiId = 0;
		Integer maxResult = getEducationMaxId();
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}
		if (educationInfo != null) {
			String formatedProfileId = idFormat + incrementiId;
			educationInfo.setEducationId(Integer.parseInt(formatedProfileId));
			educationInfo.setDeleteStatus(true);

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			Long convertTime;

			convertTime = timestamp.getTime();

			educationInfo.setCreateTs(convertTime);

			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(educationInfo);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updateEducationInfo(EducationInfo updatedEducationInfo) {
		if (updatedEducationInfo.getEducationId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(updatedEducationInfo);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}

	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<EducationInfo> getEducationInfoByProfileId(Integer profileId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<EducationInfo> educationList = null;
		String queryString = "select * from education_info where profile_id = ?1 and delete_status = true";
		Query query = session.createSQLQuery(queryString).addEntity(EducationInfo.class);
		query.setParameter(1, profileId);
		educationList = query.getResultList();
		transaction.commit();
		session.close();
		return educationList;
	}
}
