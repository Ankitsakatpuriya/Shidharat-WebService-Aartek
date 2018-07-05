package com.hyringspree.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyringspree.model.RecomendationInfo;
import com.hyringspree.repository.RecomendationRepository;
import com.hyringspree.service.RecomendationService;

@Service
public class RecomendationServiceImpl implements RecomendationService{
	
	@Autowired
	private RecomendationRepository recomendationRepository;
	
	public RecomendationInfo editRecomendation(Integer recomendationId){
		return recomendationRepository.editRecomendation(recomendationId);
		
	}

	public boolean updateRecomendationInfo(RecomendationInfo updateRecomendationInfo) {
		
		return recomendationRepository.updateRecomendationInfo(updateRecomendationInfo);
	}

}
