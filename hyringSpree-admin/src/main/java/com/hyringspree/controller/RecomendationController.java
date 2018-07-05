package com.hyringspree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hyringspree.model.RecomendationInfo;
import com.hyringspree.service.RecomendationService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@ResponseBody
public class RecomendationController {

	@Autowired
	private RecomendationService recomendationService;

	@GetMapping(path = IConstant.EDIT_RECOMENDATION_RECOMENDATIONID)
	public RecomendationInfo editRecomendation(@PathVariable Integer recomendationId) {

		return recomendationService.editRecomendation(recomendationId);

	}

	@PostMapping(path = IConstant.UPDATE_RECOMENDATIONINFO)
	public String updateRecomendationInfo(@RequestBody String recomendationInfo) {
		Gson gson = new Gson();
		RecomendationInfo updateRecomendationInfo = gson.fromJson(recomendationInfo, RecomendationInfo.class);
		boolean status = recomendationService.updateRecomendationInfo(updateRecomendationInfo);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

}
