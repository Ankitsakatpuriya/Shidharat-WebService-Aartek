package com.hyringspree.repository;

import com.hyringspree.model.RecomendationInfo;

public interface RecomendationRepository {

	public RecomendationInfo editRecomendation(Integer recomendationId);

	public boolean updateRecomendationInfo(RecomendationInfo updateRecomendationInfo);
}
