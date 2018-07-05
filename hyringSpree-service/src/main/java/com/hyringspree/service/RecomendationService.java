package com.hyringspree.service;

import com.hyringspree.model.RecomendationInfo;

public interface RecomendationService {

	public RecomendationInfo editRecomendation(Integer recomendationId);

	public boolean updateRecomendationInfo(RecomendationInfo updateRecomendationInfo);

}