package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.CertificationInfo;

public interface CertificationInfoRepository {
	
	public boolean deleteCertificationInfo(Integer certificationId);
	
	public CertificationInfo editCertificationInfo(Integer certificationId);
	
	public boolean saveJobCertificateDetails(CertificationInfo certificateInfo);
	
	public boolean updateCertificationInfo(CertificationInfo updateCertificationInfo);
	
	public List<CertificationInfo> getCertificationInfo(Integer profileId);

}
