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

import com.hyringspree.model.CertificationInfo;
import com.hyringspree.repository.CertificationInfoRepository;

@Repository
public class CertificationRepositoryImpl implements CertificationInfoRepository {

	@Autowired
	private SessionFactory factory;

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deleteCertificationInfo(Integer certificationId) {
		if (certificationId != null) {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			CertificationInfo profile = session.get(CertificationInfo.class, certificationId);
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
	public CertificationInfo editCertificationInfo(Integer certificationId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		CertificationInfo certificationInfo = session.get(CertificationInfo.class, certificationId);
		session.close();
		return certificationInfo;

	}

	/**
	 * Get Certificate MaxId
	 * 
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getCertificateMaxId() {

		String sqlQuery = "select max(certificationId) from CertificationInfo";
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery(sqlQuery);

		Integer maxProfileId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;

		transaction.commit();
		session.close();

		return maxProfileId;
	}

	/**
	 * save JobCertificateDetails
	 * 
	 * @param CertificateInfo
	 *            certificateInfo
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean saveJobCertificateDetails(CertificationInfo certificateInfo) {

		Integer incrementiId = 0;
		Integer maxResult = getCertificateMaxId();
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}

		if (certificateInfo != null) {

			String formatedProfileId = idFormat + incrementiId;
			certificateInfo.setCertificationId(Integer.parseInt(formatedProfileId));
			certificateInfo.setDeleteStatus(true);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			Long convertTime;

			convertTime = timestamp.getTime();

			certificateInfo.setCreateTs(convertTime);
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(certificateInfo);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * update CertificationInfo
	 * 
	 * @param CertificationInfo
	 *            updateCertificationInfo
	 * 
	 * @return
	 */

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updateCertificationInfo(CertificationInfo updateCertificationInfo) {
		if (updateCertificationInfo != null) {

			Session session = factory.openSession();
			session.saveOrUpdate(updateCertificationInfo);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<CertificationInfo> getCertificationInfo(Integer profileId) {
		List<CertificationInfo> certificationInfo = null;
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String getCertification = "select * from certification_info where profile_id = ?1 and delete_status = true";
		Query query = session.createSQLQuery(getCertification).addEntity(CertificationInfo.class);
		query.setParameter(1, profileId);
		// PublicationInfo
		// publicationInfo=session.get(PublicationInfo.class,profileId);
		certificationInfo = query.getResultList();
		transaction.commit();
		session.close();
		return certificationInfo;
	}
}
