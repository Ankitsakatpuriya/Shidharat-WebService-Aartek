package com.hyringspree.service;

import java.io.IOException;
import java.util.List;

import com.hyringspree.model.CompanyInfo;
import com.hyringspree.model.Offer;


public interface CompanyService {
	
	public boolean saveCompanyInfo(CompanyInfo saveCompanyInfo);
	public List<CompanyInfo>  getAllCompanyDetails();
	public boolean editCompanyRecord(CompanyInfo editCompanyInfo);
	public boolean deleteCompanyRecord(Integer id);
	public List<CompanyInfo> searchCompanyBySelection(CompanyInfo searchcompany);
	public CompanyInfo editCompanyInfoById(Integer id);
	public List<CompanyInfo> pdfForCompanyProfileDetail(Integer companyId);
	public List<CompanyInfo> sendMailCompanyProfilePdf(Integer companyId) throws IOException;
	public List<CompanyInfo> getCompanyProfileById(Integer companyId);

}
