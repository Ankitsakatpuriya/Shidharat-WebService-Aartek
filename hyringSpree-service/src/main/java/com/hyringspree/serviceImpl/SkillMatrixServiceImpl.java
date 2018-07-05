package com.hyringspree.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyringspree.model.SkillMatrixInfo;
import com.hyringspree.repository.SkillMatrixRepository;
import com.hyringspree.service.SkillMatrixService;

@Service
public class SkillMatrixServiceImpl implements SkillMatrixService {
	@Autowired
	private SkillMatrixRepository skillMatrixRepository;
	
	public SkillMatrixInfo editSkillMatrix( Integer skillId){
		return skillMatrixRepository.editSkillMatrix(skillId);
		
	}

	public boolean updateSkillMatrix(SkillMatrixInfo updateSkillMatrix) {
		return skillMatrixRepository.updateSkillMatrix(updateSkillMatrix);
	}

}
