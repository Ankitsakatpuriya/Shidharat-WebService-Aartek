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

import com.hyringspree.model.Membership;
import com.hyringspree.repository.MembershipRepository;

@Repository
public class MembershipRepositoryImpl implements MembershipRepository {

	@Autowired
	private SessionFactory factory;

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deleteMembership(Integer membershipId) {
		if(membershipId!=null){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Membership profile = session.get(Membership.class, membershipId);
		Boolean status = profile.getDeleteStatus();
		if (status) {
			profile.setDeleteStatus(false);
		}
		session.saveOrUpdate(profile);
		transaction.commit();
		session.close();
		return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Get Membership MaxId
	 * 
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getMembershipMaxId() {

		String sqlQuery = "select max(membershipId) from Membership";
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery(sqlQuery);
		
		Integer maxProfileId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;

		transaction.commit();
		session.close();

		return maxProfileId;
	}

	/**
	 * save JobMembershipDetails
	 * 
	 * @param Membership
	 *            memberInfo
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean saveJobMembershipDetails(Membership memberInfo) {

		Integer incrementiId = 0;
		Integer maxResult = getMembershipMaxId();
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}
		if (memberInfo != null) {
			String formatedProfileId = idFormat + incrementiId;
			memberInfo.setMembershipId(Integer.parseInt(formatedProfileId));
			memberInfo.setDeleteStatus(true);
			Long convertTime;

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			convertTime = timestamp.getTime();

			memberInfo.setCreateTs(convertTime);

			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(memberInfo);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Membership> getMembershipByProfileId(Integer profileId) {
		List<Membership> listOfMember = null;
		Session session = factory.openSession();
		String getMemberQuery = "select * from membership where profile_id = ?1 and delete_status = true";

		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery(getMemberQuery).addEntity(Membership.class);
		query.setParameter(1, profileId);
		listOfMember = query.getResultList();
		session.close();
		return listOfMember;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updateMembership(Membership updateMembership) {
		if (updateMembership.getMembershipId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(updateMembership);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Membership editMembership(Integer memberInfoId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Membership membership = session.get(Membership.class, memberInfoId);
		session.close();
		return membership;
	}

}
