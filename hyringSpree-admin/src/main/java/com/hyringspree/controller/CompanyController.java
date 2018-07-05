package com.hyringspree.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.CompanyInfo;
import com.hyringspree.model.Offer;
import com.hyringspree.service.CompanyService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping(path = IConstant.SAVECOMPANY_INFO)
	public String saveCompanyInfo(@RequestBody String companyInfo) {
		Gson gson = new Gson();
		CompanyInfo companyInfoDetails = gson.fromJson(companyInfo, CompanyInfo.class);
		boolean companyInfoStatus = companyService.saveCompanyInfo(companyInfoDetails);
		if (companyInfoStatus) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path = IConstant.GETALLCOMPANY_DETAILS)
	public List<CompanyInfo> getAllCompanyDetails() {
		return companyService.getAllCompanyDetails();
	}

	@PostMapping(path = IConstant.UPDATE_COMPANYINFO)
	public String updateCompanyRecord(@RequestBody String companyInfo) {
		Gson gson = new Gson();
		CompanyInfo companyInfoDetails = gson.fromJson(companyInfo, CompanyInfo.class);
		boolean status = companyService.editCompanyRecord(companyInfoDetails);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@DeleteMapping(path = IConstant.DELETE_COMPANY_RECORDID)
	public String deleteCompanyRecord(@PathVariable("id") Integer id) {

		boolean status = companyService.deleteCompanyRecord(id);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@PostMapping(path = IConstant.SEARCHCOMPANY_BY_SELECTION)
	public List<CompanyInfo> searchCompanyBySelection(@RequestBody String searchcompany) {

		Gson gson = new Gson();
		CompanyInfo companydetail = gson.fromJson(searchcompany, CompanyInfo.class);

		return companyService.searchCompanyBySelection(companydetail);
	}

	@GetMapping(path = IConstant.EDITCOMPANYINFO_BYID)
	public CompanyInfo editCompanyInfoById(@PathVariable Integer id) {
		return companyService.editCompanyInfoById(id);
	}
	
	@GetMapping(path = IConstant.GENRATE_COMPANY_PDF)
	public List<CompanyInfo> pdfForCompanyProfileDetail(@PathVariable Integer companyId) {
		return companyService.pdfForCompanyProfileDetail(companyId);
	}
	@GetMapping(path = IConstant.SEND_MAIL_FOR_COMPANY_PROFILE)
	public List<CompanyInfo> sendMailCompanyProfilePdf(@PathVariable Integer companyId) throws IOException {
		return companyService.sendMailCompanyProfilePdf(companyId);

	}
	
	@GetMapping(path = IConstant.GET_COMPANY_PROFILE_BY_ID)
	public List<CompanyInfo> getCompanyProfileById(@PathVariable Integer companyId){
		return companyService.getCompanyProfileById(companyId);

	}

}
