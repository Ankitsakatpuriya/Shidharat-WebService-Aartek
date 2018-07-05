package com.hyringspree.repositoryImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.User;
import com.hyringspree.repository.ForgetRepository;

@Repository
public class ForgetRepositoryImpl implements ForgetRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * findById
	 * @param userEmail the model
	 * @return list of user
	 * */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String findById(User userEmail) {
		String emailId = null;
		@SuppressWarnings("unchecked")
		Session session = sessionFactory.openSession();
		List<User> userData = session.createQuery("select u from User u where u.emailId ='" + userEmail.getEmailId() + "'").list();

		Iterator<User> iterator = userData.iterator();
		 while (iterator.hasNext()) {
			User user = iterator.next();
			emailId = user.getEmailId();
		}
		 session.close();
		return emailId;

	}
}
