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

import com.hyringspree.model.ExperienceInfo;
import com.hyringspree.repository.ExperienceInfoRepository;

@Repository
public class ExperienceInfoRepositoryImpl implements ExperienceInfoRepository {

	@Autowired
	private SessionFactory factory;

	/**
	 * @param experienceId
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deleteExperienceInfo(Integer experienceId) {
		if (experienceId != null) {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			ExperienceInfo profile = session.get(ExperienceInfo.class, experienceId);
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
	public ExperienceInfo editExperienceInfo(Integer experienceId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		ExperienceInfo experienceInfo = session.get(ExperienceInfo.class, experienceId);
		session.close();
		return experienceInfo;
	}

	/**
	 * save getExperienceMaxId
	 * 
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getExperienceMaxId() {

		String sqlQuery = "select max(experienceId) from ExperienceInfo";
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery(sqlQuery);

		Integer maxProfileId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;

		transaction.commit();
		session.close();

		return maxProfileId;
	}

	/**
	 * save JobExperienceDetails
	 * 
	 * @param ExperienceInfo
	 *            experienceInfo
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean saveJobExperienceDetails(ExperienceInfo experienceInfo) {

		Integer incrementiId = 0;
		Integer maxResult = getExperienceMaxId();
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}
		if (experienceInfo != null) {
			String formatedProfileId = idFormat + incrementiId;
			experienceInfo.setExperienceId(Integer.parseInt(formatedProfileId));
			experienceInfo.setDeleteStatus(true);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			Long convertTime;

			convertTime = timestamp.getTime();
			experienceInfo.setCreateTs(convertTime);
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(experienceInfo);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updateExperienceInfo(ExperienceInfo updatedExperienceInfo) {
		if (updatedExperienceInfo.getExperienceId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(updatedExperienceInfo);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<ExperienceInfo> getExperienceInfoByProfileId(Integer profileId) {
		List<ExperienceInfo> publicationInfoList = null;
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String getPublication = "select * from experience_info where profile_id = ?1 and delete_status = true";
		Query query = session.createSQLQuery(getPublication).addEntity(ExperienceInfo.class);
		query.setParameter(1, profileId);
		publicationInfoList = query.getResultList();
		// ExperienceInfo experienceInfo = session.get(ExperienceInfo.class,
		// profileId);
		session.close();
		return publicationInfoList;

	}
}
