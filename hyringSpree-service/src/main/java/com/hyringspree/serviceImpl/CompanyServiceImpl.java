package com.hyringspree.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.common.util.MailUtility;
import com.hyringspree.model.CompanyInfo;
import com.hyringspree.model.JobInfo;
import com.hyringspree.model.Offer;
import com.hyringspree.model.PatentInfo;
import com.hyringspree.model.RecruiterInfo;
import com.hyringspree.repository.CompanyRepository;
import com.hyringspree.service.CompanyService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private MailUtility mailUtility;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveCompanyInfo(CompanyInfo saveCompanyInfo) {
		return companyRepository.saveCompanyInfo(saveCompanyInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<CompanyInfo> getAllCompanyDetails() {

		return companyRepository.getAllCompanyDetails();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean editCompanyRecord(CompanyInfo editCompanyInfo) {

		return companyRepository.editCompanyRecord(editCompanyInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteCompanyRecord(Integer id) {

		return companyRepository.deleteCompanyRecord(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<CompanyInfo> searchCompanyBySelection(CompanyInfo searchcompany) {
		return companyRepository.searchCompanyBySelection(searchcompany);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public CompanyInfo editCompanyInfoById(Integer id) {
		return companyRepository.editCompanyInfoById(id);

	}
	@Transactional(propagation = Propagation.REQUIRED)
    public List<CompanyInfo> pdfForCompanyProfileDetail(Integer companyId) {
		String directory = "CompanyProfilePdf";
		String fileName = "CompanyProfile" + companyId;
		File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File file = new File(directory + "/" + fileName + ".pdf");
		String path = file.getAbsolutePath();
		System.out.println(path);

		List<CompanyInfo> list = companyRepository.pdfForCompanyProfileDetail(companyId);

		for (CompanyInfo companyInfo : list) {
			Document document = new Document();
			try {
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
				document.open();

				Font f = new Font(FontFamily.TIMES_ROMAN, 12.0f, Font.BOLD);
				Font f1 = new Font(FontFamily.TIMES_ROMAN, 8.0f);

				Paragraph right = new Paragraph("COMPANY PROFILE", f);
				right.setIndentationLeft(50);
				document.add(right);
				Chunk glue = new Chunk(new VerticalPositionMark());

				PdfPTable table = new PdfPTable(1);
				Chunk c4 = new Chunk(companyInfo.getCompanyName() + "\n\n", f1);
				Chunk c5 = new Chunk(companyInfo.getCompanyCity() + "," + companyInfo.getCompanyState() + "     "
						+ companyInfo.getWebsiteUrl(), f1);
				Paragraph p2 = new Paragraph();

				p2.add(new Chunk(c4));
				p2.add(new Chunk(c5));
				PdfPCell cell1 = new PdfPCell(p2);
				Paragraph p = new Paragraph();
				Chunk c7 = new Chunk("Employees:" + companyInfo.getNoOfEmployees(), f1);
				Chunk c8 = new Chunk("Founded:" + companyInfo.getCreateTs(), f1);
				Chunk c9 = new Chunk("Industry:" + "Computer hardware / software & Consumer electronics,etc.", f1);
				p.add(new Chunk(c7));
				p.add(glue);
				p.add(new Chunk(c8));
				p.add(glue);
				p.add(new Chunk(c9));
				PdfPCell cell2 = new PdfPCell(p);

				cell1.setFixedHeight(75);
				cell1.setUseVariableBorders(true);
				cell1.setBorderColorBottom(BaseColor.WHITE);
				table.addCell(cell1);
				cell2.setFixedHeight(25);
				cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
				cell2.setUseVariableBorders(true);
				cell2.setBorderColorTop(BaseColor.WHITE);
				table.addCell(cell2);

				table.setSpacingBefore(10f);
				table.setSpacingAfter(10f);

				document.add(table);

				PdfPTable table1 = new PdfPTable(1);
				Chunk c = new Chunk("Overview & Description" + "\n\n", f);
				Chunk c1 = new Chunk(companyInfo.getCompanyDes(), f1);

				Paragraph p1 = new Paragraph();

				p1.add(new Chunk(c));
				p1.add(new Chunk(c1));

				PdfPCell cell = new PdfPCell(p1);
				cell.setFixedHeight(60);
				table1.addCell(cell);

				document.add(table1);
				List<JobInfo> jobList = companyInfo.getJobInfo();
				for (JobInfo job : jobList) {
					PdfPTable jobTable = new PdfPTable(1);
					PdfPCell jobCell1 = new PdfPCell(new Paragraph("Jobs", f));
					jobCell1.setUseVariableBorders(true);
					jobCell1.setBorderColorBottom(BaseColor.WHITE);
					jobTable.setSpacingBefore(10f);
					jobTable.setSpacingAfter(10f);
					PdfPTable nestedTable = new PdfPTable(1);
					nestedTable.setWidthPercentage(90);
                 	Chunk ck1 = new Chunk(job.getJobTitle(), f1);
					Paragraph para = new Paragraph();
					para.add(new Chunk(ck1));
					PdfPCell jobCell2 = new PdfPCell(para);
					Chunk ck3 = new Chunk(
							job.getJobType() + "                 " + job.getJobCity() + "," + job.getJobState(), f1);
					Paragraph para1 = new Paragraph();
					para1.add(new Chunk(ck3));
					PdfPCell jobCell3 = new PdfPCell(para1);
					nestedTable.addCell(jobCell2);
					jobCell2.setFixedHeight(60);
					jobCell3.setFixedHeight(15);
					jobCell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
					jobCell3.setUseVariableBorders(true);
					jobCell3.setBorderColorTop(BaseColor.WHITE);
					nestedTable.addCell(jobCell3);
					jobCell2.setUseVariableBorders(true);
					jobCell2.setBorderColorTop(BaseColor.WHITE);
					jobCell2.setPaddingTop(25);
					jobCell2.addElement(nestedTable);
					jobTable.addCell(jobCell1);
					jobTable.addCell(jobCell2);
					document.add(jobTable);
				}
				List<RecruiterInfo> recruiterList = companyInfo.getRecruiterInfo();
				for (RecruiterInfo recruiter : recruiterList) {
					PdfPTable jobTable = new PdfPTable(1);
					PdfPCell jobCell1 = new PdfPCell(new Paragraph("Recruiters | HR", f));
					jobCell1.setUseVariableBorders(true);
					jobCell1.setBorderColorBottom(BaseColor.WHITE);
					jobTable.setSpacingBefore(10f);
					jobTable.setSpacingAfter(10f);
					PdfPTable nestedTable = new PdfPTable(1);
					nestedTable.setWidthPercentage(90);
					Chunk ck1 = new Chunk(recruiter.getRecruiterFName(), f1);
					Paragraph para = new Paragraph();
					para.add(new Chunk(ck1));
					PdfPCell jobCell2 = new PdfPCell(para);
					Chunk ck3 = new Chunk(recruiter.getRecruiterCity() + "," + recruiter.getRecruiterState()
							+ "           " + "Phone:" + recruiter.getRecruiterPhone() + "           " + "Email:"
							+ recruiter.getRecruiterEmail(), f1);
					Paragraph para1 = new Paragraph();
					para1.add(new Chunk(ck3));
					PdfPCell jobCell3 = new PdfPCell(para1);
					nestedTable.addCell(jobCell2);
					jobCell2.setFixedHeight(60);
					jobCell3.setFixedHeight(15);
					jobCell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
					jobCell3.setUseVariableBorders(true);
					jobCell3.setBorderColorTop(BaseColor.WHITE);
					nestedTable.addCell(jobCell3);
					jobCell2.setUseVariableBorders(true);
					jobCell2.setBorderColorTop(BaseColor.WHITE);
					jobCell2.setPaddingTop(20);
					jobCell2.addElement(nestedTable);
					jobTable.addCell(jobCell1);
					jobTable.addCell(jobCell2);
					document.add(jobTable);
				}

				document.close();
				writer.close();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

		return companyRepository.pdfForCompanyProfileDetail(companyId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
    public List<CompanyInfo> sendMailCompanyProfilePdf(Integer companyId) throws IOException {
		System.out.println("sendMailCompanyProfilePdf");
		List<CompanyInfo> list = companyRepository.pdfForCompanyProfileDetail(companyId);

		for (CompanyInfo companyInfo : list) {
			List<RecruiterInfo> recruiterInfo = companyInfo.getRecruiterInfo();
			companyId = companyInfo.getCompanyId();
			for (RecruiterInfo email : recruiterInfo) {
				String recruiterEmail = email.getRecruiterEmail();
				System.out.println(email.getRecruiterEmail() + companyId);
				if (recruiterEmail != null) {
					mailUtility.sendMailCompanyProfilePdf(recruiterEmail, companyId);
				}
			}

		}
		return companyRepository.sendMailCompanyProfilePdf(companyId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
     public List<CompanyInfo> getCompanyProfileById(Integer companyId) {
		return companyRepository.getCompanyProfileById(companyId);

	}
}
