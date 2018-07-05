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

import com.hyringspree.model.PublicationInfo;
import com.hyringspree.repository.PublicationRepository;

@Repository
public class PublicationRepositoryImpl implements PublicationRepository {
	@Autowired
	private SessionFactory factory;

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PublicationInfo editPublicationInfo(Integer publicationId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		PublicationInfo publicationInfo = session.get(PublicationInfo.class, publicationId);
		session.close();
		return publicationInfo;

	}

	/**
	 * @param publicationId
	 *            delete PublicationInfo
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deletePublicationInfo(Integer publicationId) {
		if (publicationId != null) {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			PublicationInfo profile = session.get(PublicationInfo.class, publicationId);
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

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updatePublicationInfo(PublicationInfo updatePublicationInfo) {
		if (updatePublicationInfo.getPublicationId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(updatePublicationInfo);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get Publication MaxId
	 * 
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getPublicatonMaxId() {
		String sqlQuery = "select max(publicationId) from PublicationInfo";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		org.hibernate.query.Query query = session.createQuery(sqlQuery);
		Integer maxProfileId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;
		transaction.commit();
		session.close();

		return maxProfileId;
	}

	/**
	 * save saveJobPublicationDetails
	 * 
	 * @param PublicationInfo
	 *            publicationInfo
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean saveJobPublicationDetails(PublicationInfo publicationInfo) {
		Integer incrementiId = 0;
		Integer maxResult = getPublicatonMaxId();
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}
		if (publicationInfo != null) {
			String formatedProfileId = idFormat + incrementiId;
			publicationInfo.setPublicationId(Integer.parseInt(formatedProfileId));
			publicationInfo.setDeleteStatus(true);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			Long convertTime;
			convertTime = timestamp.getTime();
			publicationInfo.setCreateTs(convertTime);
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(publicationInfo);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PublicationInfo> getPublication(Integer profileId) {
		List<PublicationInfo> publicationInfoList = null;
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String getPublication = "select * from publication_info where profile_id = ?1 and delete_status = true";
		Query query = session.createSQLQuery(getPublication).addEntity(PublicationInfo.class);
		query.setParameter(1, profileId);
		publicationInfoList = query.getResultList();
		transaction.commit();
		session.close();
		return publicationInfoList;
	}

}
