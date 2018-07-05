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
import com.hyringspree.model.CertificationInfo;
import com.hyringspree.service.CertificationInfoService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class CertificationInfoController {

	@Autowired
	private CertificationInfoService certificationService;

	@DeleteMapping(path = IConstant.DELETE_CERTIFICATIONINFO_CERTIFICATIONID)
	public String deleteCertificationInfo(@PathVariable Integer certificationId) {

		boolean status = certificationService.deleteCertificationInfo(certificationId);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path = IConstant.EDITCERTIFICATIONINFO_CERTIFICATIONID)
	public CertificationInfo editCertificationInfo(@PathVariable Integer certificationId) {
		return certificationService.editCertificationInfo(certificationId);

	}

	/**
	 * Save jobSeekerCertificate
	 *
	 * @param String
	 *            certificateInfo
	 */
	@PostMapping(path = IConstant.SAVEJOBSEEKER_CERTIFICATE)
	public String savejobSeekerCertificate(@RequestBody String certificateInfo) {
		Gson gson = new Gson();
		CertificationInfo certificateInfoDetails = gson.fromJson(certificateInfo, CertificationInfo.class);
		boolean status = certificationService.saveCertificateInfo(certificateInfoDetails);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@PostMapping(path = IConstant.UPDATE_CERTIFICATEINFO)
	public String updateCertificationInfo(@RequestBody String certificateInfo) {
		Gson gson = new Gson();
		CertificationInfo updateCertificationInfo = gson.fromJson(certificateInfo, CertificationInfo.class);
		boolean status = certificationService.updateCertificationInfo(updateCertificationInfo);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path = IConstant.GET_CERTIFICATE_BY_PROFILEID)
	public List<CertificationInfo> getCertificationInfo(@PathVariable Integer profileId) {
		return certificationService.getCertificationInfo(profileId);
	}

}
