package com.hyringspree.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.CertificationInfo;
import com.hyringspree.repository.CertificationInfoRepository;
import com.hyringspree.service.CertificationInfoService;

@Service
public class CertificationInfoServiceImpl implements CertificationInfoService {

	@Autowired
	private CertificationInfoRepository certificationRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteCertificationInfo(Integer certificationId) {
		return certificationRepository.deleteCertificationInfo(certificationId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public CertificationInfo editCertificationInfo(Integer certificationId) {
		return certificationRepository.editCertificationInfo(certificationId);
	}

	/*
	 * save CertificateInfo
	 * 
	 * @param certificateInfo saveCertificateInfo
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveCertificateInfo(CertificationInfo certificationInfo) {
		return certificationRepository.saveJobCertificateDetails(certificationInfo);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateCertificationInfo(CertificationInfo updateCertificationInfo) {
		return certificationRepository.updateCertificationInfo(updateCertificationInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<CertificationInfo> getCertificationInfo(Integer profileId) {
		return certificationRepository.getCertificationInfo(profileId);
	}
}
