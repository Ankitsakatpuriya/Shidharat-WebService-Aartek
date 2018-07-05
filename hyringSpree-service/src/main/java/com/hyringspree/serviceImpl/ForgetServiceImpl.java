package com.hyringspree.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.common.util.MailUtility;
import com.hyringspree.model.User;
import com.hyringspree.repository.ForgetRepository;
import com.hyringspree.service.ForgetService;

@Service
public class ForgetServiceImpl implements ForgetService {

	@Autowired
	private ForgetRepository forgetRepository;

	/**
	 * findByEmailId
	 * 
	 * @param userEmail
	 *            the model
	 * @return boolean
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean findByEmailId(User userEmail) {

		String emailId = forgetRepository.findById(userEmail);
		if (emailId != null) {
			MailUtility.sendMailForForgotPassword(emailId);
			return true;
		} else {
			return false;
		}
	}

}
