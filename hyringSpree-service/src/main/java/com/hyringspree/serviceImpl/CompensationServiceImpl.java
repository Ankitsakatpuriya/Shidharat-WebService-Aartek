package com.hyringspree.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.repository.CompensationRepository;
import com.hyringspree.service.CompensationService;

@Service
public class CompensationServiceImpl implements CompensationService{
	
	@Autowired CompensationRepository compensationRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteCompensation(Integer compensationId) {
		compensationRepository.deleteCompensation(compensationId);
		
	}

}
