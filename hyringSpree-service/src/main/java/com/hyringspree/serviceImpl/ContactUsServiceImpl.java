package com.hyringspree.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.ContactUs;
import com.hyringspree.repository.ContactUsRepository;
import com.hyringspree.service.ContactUsService;

@Service
public class ContactUsServiceImpl implements ContactUsService {
@Autowired
private ContactUsRepository contactUsRepository;


/**
 * Save contactDetails
 * 
 * @param String
 *            contact
 * @return
 */
    @Transactional(propagation = Propagation.REQUIRED)
	public boolean saveContactDetails(ContactUs contactDetails) {
    	
    		return contactUsRepository.saveContactDetails(contactDetails);
    }	
}
