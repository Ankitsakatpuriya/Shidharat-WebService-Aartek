package com.hyringspree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.ContactUs;
import com.hyringspree.service.ContactUsService;
import com.hyringspree.util.IConstant;

@RestController
public class ContactUsController {

	@Autowired
	private ContactUsService contactUsService;
	
	/**
	 * Save contactDtails
	 * 
	 * @param String
	 *            contact
	 * @return
	 */
	@PostMapping(path =IConstant.SAVECONTACT_DETAILS)
	public String save(@RequestBody String contact){
		Gson gson = new Gson();
		ContactUs contactDetails = gson.fromJson(contact, ContactUs.class);
		boolean status = contactUsService.saveContactDetails(contactDetails);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}
}
