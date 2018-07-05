package com.hyringspree.service;

import org.springframework.stereotype.Service;

import com.hyringspree.model.ContactUs;

@Service
public interface ContactUsService  {

	/**
	 * Save contactDetails
	 * 
	 * @param String
	 *            contact
	 * @return
	 */
	public boolean saveContactDetails(ContactUs contactDetails);


}
