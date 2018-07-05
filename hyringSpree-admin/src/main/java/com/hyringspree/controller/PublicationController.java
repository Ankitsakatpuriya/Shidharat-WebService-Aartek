package com.hyringspree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.PublicationInfo;
import com.hyringspree.service.PublicationService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class PublicationController {

	@Autowired
	private PublicationService publicationService;

	@GetMapping(path = IConstant.EDIT_PUBLICATIONINFO_PUBLICATIONID)
	public PublicationInfo editPublicationInfo(@PathVariable Integer publicationId) {
		return publicationService.editPublicationInfo(publicationId);
	}

	@DeleteMapping(path = IConstant.DELETE_PUBLICATIONINFO_PUBLICATIONID)
	public String deletePublicationInfo(@PathVariable("publicationId") Integer publicationId) {
		boolean status = publicationService.deletePublicationInfo(publicationId);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@PostMapping(path = IConstant.UPDATE_PUBLICATIONINFO)
	public String updatePublicationInfo(@RequestBody String publicationInfo) {
		Gson gson = new Gson();
		PublicationInfo UpdatePublicationInfo = gson.fromJson(publicationInfo, PublicationInfo.class);
		boolean status = publicationService.updatePublicationInfo(UpdatePublicationInfo);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	/**
	 * Save jobSeekerPublication
	 *
	 * @param String
	 *            publicationInfo
	 */
	@PostMapping(path = IConstant.SAVEJOBSEEKER_PUBLICATION)
	public String savePublication(@RequestBody String publicationInfo) {
		Gson gson = new Gson();
		PublicationInfo publicationInfoDetails = gson.fromJson(publicationInfo, PublicationInfo.class);
		boolean status = publicationService.savePublicationInfo(publicationInfoDetails);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path =IConstant.GET_PUBLICATIONINFO_BY_PROFILEID_PROFILEID)
	public List<PublicationInfo> getPublication(@PathVariable Integer profileId) {
		return publicationService.getPublication(profileId);
	}

}
