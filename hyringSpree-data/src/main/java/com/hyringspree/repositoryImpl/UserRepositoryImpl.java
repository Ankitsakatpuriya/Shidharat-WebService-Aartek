package com.hyringspree.repositoryImpl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.hyringspree.model.User;
import com.hyringspree.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory factory;

	@Autowired
	private HttpServletRequest request;

	/*
	 * @Autowired private User u ;
	 */
	/**
	 * findByEmailIdAndPassword
	 * 
	 * @param userData
	 *            the model
	 * @return List of user
	 */

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<User> findByEmailIdAndPassword(User userData) {

		String decryptedPassword = new String(java.util.Base64.getDecoder().decode(userData.getPassword()));

		/*
		 * ServletContext context = request.getSession().getServletContext();
		 * 
		 * context.setAttribute("sessionPassword", decryptedPassword);
		 * context.setAttribute("sessionEmailId", userData.getEmailId());
		 */
		System.out.println(request.getSession().getAttribute("token"));
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<User> userDetails = session.createQuery("select u from User u where u.emailId='" + userData.getEmailId()
				+ "' and u.password='" + decryptedPassword + "'").list();
		session.close();
		return userDetails;
	}

	/*
	 * @Transactional(isolation = Isolation.READ_UNCOMMITTED) public User
	 * findByUsername(String userName) {
	 * 
	 * }
	 */

	public String errorJson() {
		JsonObject obj = new JsonObject();
		obj.addProperty("errorsMessage", "UnAuhtorizedUser");
		obj.addProperty("statusCode", "400");

		String jsonObj = obj.toString();
		return jsonObj;
	}

	public String LogoutUserRepository() {
		HttpSession session = request.getSession();
		// request.getSession().removeAttribute("user");
		session.invalidate();
		JsonObject obj = new JsonObject();
		obj.addProperty("statusCode", "400");
		obj.addProperty("errorsMessage", "userLogout");
		String jsonObj = obj.toString();
		return jsonObj;
	}

	public <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<User> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<User> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

	public void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public User findByUsername(String userName) {
		// TODO Auto-generated method stub
		/*
		 * Session session=factory.openSession(); Transaction
		 * transaction=session.beginTransaction(); User userDetails = (User)
		 * session.createQuery("select u from User u where u.emailId='"+
		 * userName + "'"); System.out.println(userDetails+"ggggggg");
		 * session.close();
		 */
		return null;
	}

	@SuppressWarnings("deprecation")
	public Boolean resetPassword(User userData) {
		if (userData.getEmailId() != null) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String queryString = "UPDATE user_admin SET password=:password where email_id=:emailId";
		Query query = session.createSQLQuery(queryString).addEntity(User.class);
		query.setString("password", userData.getPassword());
		query.setString("emailId", userData.getEmailId());
	    query.executeUpdate();
	    transaction.commit();
		session.close();
		return true;
	} else {
		return false;
	}
	}
  
}