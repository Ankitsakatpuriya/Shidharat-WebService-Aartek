package com.hyringspree.repositoryImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.ContactUs;
import com.hyringspree.repository.ContactUsRepository;

@Repository
public class ContactUsRepositoryImpl implements ContactUsRepository {

	@Autowired
	private SessionFactory factory;

	/**
	 * Save contactDetails
	 * 
	 * @param String
	 *            contact
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean saveContactDetails(ContactUs contactDetails) {
		if (contactDetails.getComment() != null && !contactDetails.getComment().equals("")
				|| contactDetails.getEmail() != null && !contactDetails.getEmail().equals("")
				|| contactDetails.getFirstName() != null && !contactDetails.getFirstName().equals("")
				|| contactDetails.getLastName() != null && !contactDetails.getLastName().equals("")
				|| contactDetails.getPhoneNumber() != null && !contactDetails.getPhoneNumber().equals("")) {
			System.out.println(contactDetails);
			Session session = factory.openSession();
			Transaction txt = session.beginTransaction();
			session.save(contactDetails);
			txt.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

}
