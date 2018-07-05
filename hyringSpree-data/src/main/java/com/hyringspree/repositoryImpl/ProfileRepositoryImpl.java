package com.hyringspree.repositoryImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.Job;
import com.hyringspree.model.Offer;
import com.hyringspree.model.PatentInfo;
import com.hyringspree.model.Profile;
import com.hyringspree.model.ProfileInfo;
import com.hyringspree.repository.ProfileRepository;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

	@Autowired
	private SessionFactory factory;

	/**
	 * Save Profile
	 * 
	 * @param Profile
	 *            profileDetails
	 * @return Integer
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public Integer saveProfile(Profile profileDetails) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Integer serilizedId = (Integer) session.save(profileDetails);
		transaction.commit();
		session.close();
		return serilizedId;

	}

	/**
	 * Edit Profile
	 * 
	 * @param Integer
	 *            id
	 * @return Profile
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Profile editProfile(Integer id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Profile profile = session.get(Profile.class, id);
		session.close();
		return profile;

	}

	/**
	 * Delete Profile
	 * 
	 * @param Integer
	 *            id
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void deleteProfile(Integer id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Profile profile = session.get(Profile.class, id);
		session.delete(profile);
		transaction.commit();
		session.close();
	}

	/**
	 * Get Profiles
	 * 
	 * @return list
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List getProfiles() {
		Session session = factory.openSession();
		Query<Job> query = session.createQuery("from ProfileInfo");
		List list = query.list();
		session.close();
		return list;
	}

	public List pdfForProfileDetail(Integer profileId) {
		Session session = factory.openSession();
		List profileList;
		String queryString = "SELECT * FROM profile_info where profile_id=?1";

		Query query = session.createSQLQuery(queryString).addEntity(ProfileInfo.class);
		query.setParameter(1, profileId);
		profileList = query.getResultList();
		session.close();
		return profileList;
	}
}
