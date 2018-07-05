package com.hyringspree.service;

import java.util.List;

import com.hyringspree.model.CertificationInfo;

public interface CertificationInfoService {

	public boolean deleteCertificationInfo(Integer certificationId);

	public CertificationInfo editCertificationInfo(Integer certificationId);

	/*
	 * Save CertificateInfo
	 * 
	 * @param String certificationInfo
	 */
	public boolean saveCertificateInfo(CertificationInfo certificationInfo);

	public boolean updateCertificationInfo(CertificationInfo updateCertificationInfo);
	
	public List<CertificationInfo> getCertificationInfo(Integer profileId);



}
