package com.hyringspree.repositoryImpl;

import static com.hyringspree.util.Dateutills.generateIdFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonObject;
import com.hyringspree.model.ProfileInfo;
import com.hyringspree.model.ProfileInfoDTO;
import com.hyringspree.repository.JobSeekerRepository;
import com.hyringspree.util.IConstant;

@Repository
public class JobSeekerRepositoryImpl implements JobSeekerRepository {

	@Autowired
	private SessionFactory factory;

	/**
	 * Save JobSeeker
	 * 
	 * @param String
	 *            jobSeeker
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public String saveJobSeekersDetails(ProfileInfo profileInfo) {

		String emailId = null;
		Integer incrementiId = 0;
		Integer maxResult = getMaxId();
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}

		String formatedProfileId = idFormat + incrementiId;
		profileInfo.setProfileId(Integer.parseInt(formatedProfileId));
		profileInfo.setDeleteStatus(true);

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		Long convertTime;
		convertTime = timestamp.getTime();

		profileInfo.setProfileCreateDate(convertTime);
		// profileInfo.setProfileCreateDate(timestamp);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(profileInfo);
		transaction.commit();
		session.close();
		emailId = profileInfo.getProfileEmail();
		return emailId;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getMaxId() {

		String sqlQuery = "select max(profileId) from ProfileInfo";
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery(sqlQuery);

		Integer maxProfileId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;

		transaction.commit();
		session.close();

		return maxProfileId;
	}

	/**
	 * Edit JobSeeker
	 *
	 * @param Integer
	 *            id repo * @return jobSeeker
	 */
	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public ProfileInfo editJobSeekerProfile(Integer profileId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		ProfileInfo profileinfo = session.get(ProfileInfo.class, profileId);
        session.close();
		return profileinfo;
	}

	//
	// /**
	// * Edit JobSeeker
	// *
	// * @param Integer
	// * id
	// * @return jobSeeker
	// */
	//
	// public JobSeeker editJobSeeker(Integer id) {
	// Session session = factory.openSession();
	// Transaction transaction = session.beginTransaction();
	// JobSeeker jobseeker = session.get(JobSeeker.class, id);
	// return jobseeker;
	// }
	//
	/**
	 * Delete JobSeeker
	 *
	 * @param Integer
	 *            profileId
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deleteJobSeeker(Integer profileId) {
		if (profileId != null) {

			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			ProfileInfo profile = session.get(ProfileInfo.class, profileId);
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

	// /**
	// * Get JobSeeker
	// *
	// * @return list
	// */
	//
	// public List getAllJobSeekersDtails() {
	// Session session = factory.openSession();
	// Query<JobSeeker> query = session.createQuery("from JobSeeker");
	// List<JobSeeker> list = query.list();
	// return list;
	// }
	//
	// /**
	// * Get JobSeeker
	// *
	// * @return list
	// */
	//
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public ProfileInfo updateJobSeekerProfile(ProfileInfo jobSeekerUpdateProfile) {

		if (jobSeekerUpdateProfile.getProfileId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(jobSeekerUpdateProfile);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			
			}
		return jobSeekerUpdateProfile;
	}
	/**
	 * @Shweta soni searchJobseekerData
	 * 
	 * @param jobSeeker
	 * 
	 * @return list
	 */
	// public List<JobSeeker> searchJobseekerData(JobSeeker jobseeker) {
	// Session session = factory.openSession();
	// List<JobSeeker> jobseekerList = null;
	//
	// if (StringUtils.isNotBlank(jobseeker.getFromDate()) &&
	// StringUtils.isNotBlank(jobseeker.getToDate())) {
	// String queryString = "select * from jobseeker where ";
	//
	// if (jobseeker.getId() != null) {
	// queryString += "jobseeker_id= :id ";
	// }
	// if (jobseeker.getId() != null) {
	// if (jobseeker.getZip() != null && !jobseeker.getZip().equals("")) {
	// queryString += "OR ";
	// }
	// }
	// if (jobseeker.getZip() != null && !jobseeker.getZip().equals("")) {
	// queryString += "zip= :zip OR ";
	// }
	// if (jobseeker.getId() != null) {
	// if (StringUtils.isBlank(jobseeker.getZip())) {
	// queryString += "OR ";
	// }
	//
	// }
	// String startDate = jobseeker.getFromDate();
	// String endDate = jobseeker.getToDate();
	//
	// if (startDate != null && endDate != null) {
	// queryString += "to_date (joining_date, 'DD/MM/YYYY') >= to_date
	// (:fromDate, 'DD/MM/YYYY') AND "
	// + "to_date (joining_date, 'DD/MM/YYYY')<= to_date (:toDate, 'DD/MM/YYYY')
	// ";
	// }
	// Date d1 = null;
	// Date d2 = null;
	// Query<JobSeeker> query =
	// session.createSQLQuery(queryString).addEntity(JobSeeker.class);
	// if (jobseeker.getId() != null) {
	// query.setParameter("id", jobseeker.getId());
	// }
	// if (jobseeker.getZip() != null && !jobseeker.getZip().equals("")) {
	// query.setParameter("zip", jobseeker.getZip());
	// }
	//
	// query.setParameter("fromDate", startDate);
	// query.setParameter("toDate", endDate);
	//
	// jobseekerList = query.getResultList();
	// session.close();
	// } else {
	// String queryString = "select * from jobseeker where ";
	// if (jobseeker.getId() != null) {
	// queryString += "jobseeker_id= :id ";
	// }
	// if (jobseeker.getId() != null) {
	// if (jobseeker.getZip() != null && !jobseeker.getZip().equals("")) {
	// queryString += "OR ";
	// }
	// }
	// if (jobseeker.getZip() != null && !jobseeker.getZip().equals("")) {
	// queryString += "zip= :zip ";
	// }
	// Query q = session.createSQLQuery(queryString).addEntity(JobSeeker.class);
	// if (jobseeker.getId() != null) {
	// q.setParameter("id", jobseeker.getId());
	// if (jobseeker.getId() != null && (jobseeker.getZip() != null &&
	// !jobseeker.getZip().equals(""))) {
	// q.setParameter("id", jobseeker.getId());
	// q.setParameter("zip", jobseeker.getZip());
	// }
	//
	// } else {
	// if (!jobseeker.getZip().equals("")) {
	// q.setParameter("zip", jobseeker.getZip());
	// }
	// }
	// jobseekerList = q.getResultList();
	// session.close();
	// }
	// return jobseekerList;
	// }

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<ProfileInfo> searchProfileByProfileId(ProfileInfo profileInfo) {
		Session session = factory.openSession();
		List<ProfileInfo> list = session.createQuery("select p from ProfileInfo p where p.profileId = :profileId")
				.setParameter("profileId", profileInfo.getProfileId()).getResultList();
		session.close();
		return list;
	}

	// public void jbseekerCreateProfileDetailsWithImage() {
	//
	// }
	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<ProfileInfo> searchJobSeekerProfileByKeywords(ProfileInfoDTO profileInfo) {

		Session session = factory.openSession();
		List<ProfileInfo> ProfileInfoList = null;

		if ((profileInfo.getProfileCreateDate() != null) && profileInfo.getProfileEndDate() != null) {
			String queryString = "select * from profile_info where delete_status = true AND ( ";

			if (profileInfo.getProfileId() != null) {
				queryString += "profile_id= :id ";
			}
			if (profileInfo.getProfileId() != null) {
				if (profileInfo.getProfilePostalCode() != null && !profileInfo.getProfilePostalCode().equals("")) {
					queryString += "OR ";
				}
			}
			if (profileInfo.getProfilePostalCode() != null && !profileInfo.getProfilePostalCode().equals("")) {
				queryString += "profile_postal_code = :zip OR ";
			}
			if (profileInfo.getProfileId() != null) {
				if (StringUtils.isBlank(profileInfo.getProfilePostalCode())) {
					queryString += "OR ";
				}

			}

			Long convertTime;
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			convertTime = timestamp.getTime();

			Long startDate = profileInfo.getProfileCreateDate();
			//Long endDate = convertTime;

			Long endDate = profileInfo.getProfileEndDate();

			if (startDate != null && endDate != null) {
				/*
				 * queryString +=
				 * "to_date (DATE, 'DD/MM/YYYY') >= to_date (:fromDate, 'DD/MM/YYYY') AND "
				 * +
				 * "to_date (DATE, 'DD/MM/YYYY')<= to_date (:toDate, 'DD/MM/YYYY') "
				 * ;
				 */
				queryString += "date BETWEEN :fromDate AND :toDate ) ";

			}

			Date d1 = null;
			Date d2 = null;
			Query<ProfileInfo> query = session.createSQLQuery(queryString).addEntity(ProfileInfo.class);
			if (profileInfo.getProfileId() != null) {
				query.setParameter("id", profileInfo.getProfileId());
			}
			if (profileInfo.getProfilePostalCode() != null && !profileInfo.getProfilePostalCode().equals("")) {
				query.setParameter("zip", profileInfo.getProfilePostalCode());
			}

			query.setParameter("fromDate", startDate);
			query.setParameter("toDate", endDate);

			ProfileInfoList = query.getResultList();
			session.close();
		} else {
			String queryString = "select * from profile_info where delete_status = true and ( ";
			if (profileInfo.getProfileId() != null) {
				queryString += "Profile_id= :id ";
			}
			if (profileInfo.getProfileId() != null) {
				if (profileInfo.getProfilePostalCode() != null && !profileInfo.getProfilePostalCode().equals("")) {
					queryString += "OR ";
				}
			}
			if (profileInfo.getProfilePostalCode() != null && !profileInfo.getProfilePostalCode().equals("")) {
				queryString += "profile_postal_code= :zip ";
			}
			
			queryString+=")";

			Query q = session.createSQLQuery(queryString).addEntity(ProfileInfo.class);
			if (profileInfo.getProfileId() != null) {
				q.setParameter("id", profileInfo.getProfileId());
				if (profileInfo.getProfileId() != null && (profileInfo.getProfilePostalCode() != null
						&& !profileInfo.getProfilePostalCode().equals(""))) {
					q.setParameter("id", profileInfo.getProfileId());
					q.setParameter("zip", profileInfo.getProfilePostalCode());
				}

			} else {
				if (profileInfo.getProfilePostalCode() != null && !profileInfo.getProfilePostalCode().equals("")) {
					q.setParameter("zip", profileInfo.getProfilePostalCode());
				}
			}
			ProfileInfoList = q.getResultList();
			session.close();
		}

		return ProfileInfoList;
	}
	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<ProfileInfo> getJobseekerByProfileId(Integer profileId) {
		List<ProfileInfo> JobSeekerList = null;
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String getJobSeekerList = "select * from profile_info where profile_id = ?1 and delete_status = true";
		Query query = session.createSQLQuery(getJobSeekerList).addEntity(ProfileInfo.class);
		query.setParameter(1, profileId);
		JobSeekerList = query.getResultList();
		// ExperienceInfo experienceInfo = session.get(ExperienceInfo.class,
		// profileId);
		session.close();
		return JobSeekerList;
	}

	public String checkJobSeekerEmailId(String EmailId) {
		System.out.println("method email .. "+EmailId);
		JsonObject obj = new JsonObject();
		Session session = factory.openSession();
		String sqlQuery = "select * from profile_info where profile_email like ?1 ";
		Query query = session.createSQLQuery(sqlQuery).addEntity(ProfileInfo.class);
		query.setParameter(1,  EmailId+'%' );
		List<ProfileInfo> jobSeekerList = query.getResultList();
		if (jobSeekerList.size() > 0){
		session.close();
		return IConstant.SUCCESS;
		} 	 
		session.close();
		return IConstant.ERROR;
	}
	
	public Long countOfAllJobSeeker() {
		Session session = factory.openSession();
		Long count = (Long) session
				.createQuery("select count(*) from ProfileInfo where delete_status = true").getSingleResult();
		session.close();
		return count;
	}

}
