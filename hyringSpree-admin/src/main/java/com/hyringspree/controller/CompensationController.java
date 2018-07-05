package com.hyringspree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hyringspree.service.CompensationService;
import com.hyringspree.util.IConstant;

@RestController
public class CompensationController {
	
	@Autowired
	private CompensationService compensationService;
	
	@DeleteMapping(path=IConstant.DELETECOMPENSATION_COMPENSATIONID)
	public void deleteCompensation(@PathVariable("compensationId") Integer compensationId) {
		compensationService.deleteCompensation(compensationId);
	}

}
