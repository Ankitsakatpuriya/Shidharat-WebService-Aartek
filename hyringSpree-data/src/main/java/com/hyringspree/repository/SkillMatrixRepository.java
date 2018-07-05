package com.hyringspree.repository;

import com.hyringspree.model.SkillMatrixInfo;

public interface SkillMatrixRepository {

	public SkillMatrixInfo editSkillMatrix(Integer skillId);

	public boolean updateSkillMatrix(SkillMatrixInfo updateSkillMatrix);
}
