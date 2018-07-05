package com.hyringspree.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.PatentInfo;
import com.hyringspree.repository.PatentRepository;
import com.hyringspree.service.PatentService;

@Service
public class PatentServiceImpl implements PatentService {

	@Autowired
	private PatentRepository patentRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public PatentInfo editPatentInfo(Integer patentId) {
		return patentRepository.editPatentInfo(patentId);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deletePatentInfo(Integer patentId) {
		return patentRepository.deletePatentInfo(patentId);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean savePatentInfo(PatentInfo patentInfo) {
		return patentRepository.saveJobPatentDetails(patentInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updatePatentInfo(PatentInfo updatePatentInfo) {
		return patentRepository.updatePatentInfo(updatePatentInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<PatentInfo> getPatentInfo(Integer profileId) {
		return patentRepository.getPatentInfo(profileId);
	}
}
