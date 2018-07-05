package com.hyringspree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.RecruiterInfo;
import com.hyringspree.model.SkillMatrixInfo;
import com.hyringspree.repository.SkillMatrixRepository;
import com.hyringspree.service.SkillMatrixService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class SkillMatrixController {
	
	@Autowired
	private SkillMatrixService skillMatrixService;
	
	@GetMapping(path= IConstant.EDIT_SKILLMATRIX_SKILLID)
	public SkillMatrixInfo editSkillMatrix(@PathVariable Integer skillId){
		
		return skillMatrixService.editSkillMatrix(skillId);
		
	}
	@PostMapping(path =IConstant.UPDATE_SKILLMATRIX)
	public String updateSkillMatrix(@RequestBody String skillMatrixInfo) {
		Gson gson = new Gson();
		SkillMatrixInfo updateSkillMatrix = gson.fromJson(skillMatrixInfo, SkillMatrixInfo.class);
		boolean status = skillMatrixService.updateSkillMatrix(updateSkillMatrix);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

}
