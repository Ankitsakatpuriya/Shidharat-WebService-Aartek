package com.hyringspree.service;

import com.hyringspree.model.SkillMatrixInfo;

public interface SkillMatrixService {
	
	public SkillMatrixInfo editSkillMatrix(Integer skillId);

	public boolean updateSkillMatrix(SkillMatrixInfo updateSkillMatrix);

}
