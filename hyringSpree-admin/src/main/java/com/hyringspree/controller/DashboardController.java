package com.hyringspree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.DashboardDto;
import com.hyringspree.service.DashboardService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping(path = IConstant.GET_ALL_COUNT_FOR_DASHBOARD)
	public DashboardDto getALLCountForDashboard() {
		return dashboardService.getALLCountForDashboard();
	}

}
