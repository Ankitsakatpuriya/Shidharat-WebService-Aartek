package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.CompanyInfo;

public interface CompanyRepository {

	public boolean saveCompanyInfo(CompanyInfo saveCompanyInfo);
	
	public List<CompanyInfo> getAllCompanyDetails();
	
	public boolean editCompanyRecord(CompanyInfo editCompanyInfo);
	
	public boolean deleteCompanyRecord(Integer id);
	
	public List<CompanyInfo> searchCompanyBySelection(CompanyInfo searchCompany);
	
	public CompanyInfo editCompanyInfoById(Integer id);


	public List<CompanyInfo> pdfForCompanyProfileDetail(Integer companyId);

	public List<CompanyInfo> sendMailCompanyProfilePdf(Integer companyId);

	public List<CompanyInfo> getCompanyProfileById(Integer companyId);
}
