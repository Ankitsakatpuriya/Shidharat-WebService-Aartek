package com.hyringspree.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.CertificationInfo;
import com.hyringspree.model.EducationInfo;
import com.hyringspree.model.ExperienceInfo;
import com.hyringspree.model.Membership;
import com.hyringspree.model.PatentInfo;
import com.hyringspree.model.Profile;
import com.hyringspree.model.ProfileInfo;
import com.hyringspree.model.PublicationInfo;
import com.hyringspree.repository.ProfileRepository;
import com.hyringspree.service.ProfileService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	/**
	 * Save Profile
	 * 
	 * @param Profile
	 *            profileDetails
	 * @return boolean
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveProfile(Profile profileDetails) {
		Integer serilizeId = profileRepository.saveProfile(profileDetails);
		if (serilizeId != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Edit Profile
	 * 
	 * @param Integer
	 *            id
	 * @return Profile
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Profile editProfile(Integer id) {
		return profileRepository.editProfile(id);
	}

	/**
	 * Delete Profile
	 * 
	 * @param Integer
	 *            id
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteProfile(Integer id) {
		profileRepository.deleteProfile(id);
	}

	/**
	 * Get Profiles
	 * 
	 * @return list
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List getProfiles() {
		return profileRepository.getProfiles();
	}

	private static void buildNestedTablesForExperience(PdfPTable outerTable, List<ProfileInfo> list) {
		for (ProfileInfo profile : list) {
			List<ExperienceInfo> experienceList = profile.getExperienceInfo();
			for (ExperienceInfo experience : experienceList) {
				System.out.println(experience.getCompanyName());

				PdfPTable innerTable1 = new PdfPTable(1);
				PdfPCell innerCell1 = new PdfPCell(new Paragraph(
						"Company Name :  \n" + experience.getCompanyName() + "\nJobRole: \n" + experience.getJobRole()
								+ "\nDescription : " + "                      \t\t\t\t\t\t Duration \n"
								+ experience.getDescriptionExperience() + "                    \t\t\t\t\t\t"
								+ experience.getJoiningDate() + "-" + experience.getRelievingDate()));
				// PdfPCell innerCell2 = new PdfPCell(new Paragraph("cell2"));
				innerCell1.setFixedHeight(80);
				// innerCell2.setFixedHeight(40);
				innerTable1.addCell(innerCell1);
				// innerTable1.addCell(innerCell2);
				outerTable.addCell(innerTable1);
			}
		}

	}

	private static void buildNestedTablesForSkills(PdfPTable outerTable) {
		PdfPCell innerCell1 = null;
		String techSkilll = "TECHNICAL SKILLS\n"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.\n"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.";
		String fuctionSkill = "FUNCTION SKILLS\n"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.\n"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.";
		String softSkill = "SOFT SKILLS\n"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.\n"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus.";
		for (int i = 0; i < 3; i++) {
			PdfPTable innerTable1 = new PdfPTable(1);
			if (i == 0) {
				innerCell1 = new PdfPCell(new Paragraph(techSkilll));
			}
			if (i == 1) {
				innerCell1 = new PdfPCell(new Paragraph(fuctionSkill));
			}
			if (i == 2) {
				innerCell1 = new PdfPCell(new Paragraph(softSkill));
			}
			// innerCell1.setFixedHeight(40);
			innerTable1.addCell(innerCell1);
			outerTable.addCell(innerTable1);
		}

	}

	private static void buildNestedTablesForEducation(PdfPTable outerTable, List<ProfileInfo> list) {
		for (ProfileInfo profile : list) {
			List<EducationInfo> educationList = profile.getEducationInfo();
			for (EducationInfo education : educationList) {
				PdfPTable innerTable1 = new PdfPTable(1);
				PdfPCell innerCell1 = new PdfPCell(new Paragraph("Course Name :\n" + education.getCourseName()
						+ "\nInstitute Name: \n" + education.getInstitutionName() + "\nCourse Completed"
						+ "                    " + "Location \n" + education.getCourseCompleted()
						+ "                                 " + education.getEducationLocation()));
				innerCell1.setFixedHeight(80);
				innerTable1.addCell(innerCell1);
				outerTable.addCell(innerTable1);
			}
		}
	}

	private static void buildNestedTablesForCertification(PdfPTable outerTable, List<ProfileInfo> list) {
		for (ProfileInfo profile : list) {
			List<CertificationInfo> certificationList = profile.getCertificationInfo();
			for (CertificationInfo certification : certificationList) {
				PdfPTable innerTable1 = new PdfPTable(1);
				PdfPCell innerCell1 = new PdfPCell(new Paragraph("Certification Name:\n "
						+ certification.getCertificationName() + "\n\nCerified On                    issued By \n"
						+ certification.getCertifidOn() + "                    " + certification.getIssuedBy()));
				innerCell1.setFixedHeight(80);
				innerTable1.addCell(innerCell1);
				outerTable.addCell(innerTable1);
			}
		}
	}

	private static void buildNestedTablesForMemberships(PdfPTable outerTable, List<ProfileInfo> list) {
		for (ProfileInfo profile : list) {
			List<Membership> membershipList = profile.getMembership();
			for (Membership membership : membershipList) {
				PdfPTable innerTable1 = new PdfPTable(1);
				PdfPCell innerCell1 = new PdfPCell(new Paragraph("Memberships Title \n"
						+ membership.getMembershipTitle() + "\nMembership Description\n"
						+ membership.getMembershipDescription() + "\n\nMemberSince\n" + membership.getMemberSince()));
				innerCell1.setFixedHeight(90);
				innerTable1.addCell(innerCell1);
				outerTable.addCell(innerTable1);
			}
		}
	}

	private static void buildNestedTablesForPatents(PdfPTable outerTable, List<ProfileInfo> list) {
		for (ProfileInfo profile : list) {
			List<PatentInfo> patentList = profile.getPatentInfo();
			for (PatentInfo patent : patentList) {
				PdfPTable innerTable1 = new PdfPTable(1);
				PdfPCell innerCell1 = new PdfPCell(new Paragraph("Patents Title\n" + patent.getPatentTitle()
						+ "\nPatentsDescription\n" + patent.getPatentDes() + "\n\nIssued on                Country\n"
						+ patent.getIssuedOn() + "              " + patent.getPatentIssueCountry()));
				innerCell1.setFixedHeight(90);
				innerTable1.addCell(innerCell1);
				outerTable.addCell(innerTable1);
			}
		}
	}

	private static void buildNestedTablesForPublications(PdfPTable outerTable, List<ProfileInfo> list) {
		for (ProfileInfo profile : list) {
			List<PublicationInfo> publicationList = profile.getPublicationInfo();
			for (PublicationInfo publication : publicationList) {
				PdfPTable innerTable1 = new PdfPTable(1);
				PdfPCell innerCell1 = new PdfPCell(new Paragraph("PublicationTitle\n"
						+ publication.getPublicationTitle() + "\nPublicationsDescription\n"
						+ publication.getPublicationsDescription() + "\n\nDate                         Publisher\n"
						+ publication.getDate() + "               " + publication.getPublisherName()));
				innerCell1.setFixedHeight(90);
				innerTable1.addCell(innerCell1);
				outerTable.addCell(innerTable1);
			}
		}
	}

	private static void buildNestedTablesForRecommendations(PdfPTable outerTable) {
		PdfPTable innerTable1 = new PdfPTable(1);
		PdfPCell innerCell1 = new PdfPCell(new Paragraph("TOM,ALEX" + "\n" + "Xyz Inc" + "\n"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce finibus mauris nisi, sit amet dapibus mi scelerisque ac. Morbi at justo nec turpis vehicula dapibus"
				+ "\n" + "Date" + "\n" + "02 Feb 2017"));
		// innerCell1.setFixedHeight(40);
		innerTable1.addCell(innerCell1);
		outerTable.addCell(innerTable1);
	}

	public List pdfForProfileDetail(Integer profileId) {

		String directory = "ProfileDetailPdf";
		String fileName = "jobseekerProfile" + profileId;
		File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File file = new File(directory + "/" + fileName + ".pdf");
		String path = file.getAbsolutePath();
		System.out.println(path);

		List<ProfileInfo> list = profileRepository.pdfForProfileDetail(profileId);

		for (ProfileInfo profile : list) {
			System.out.println(profile.getProfileFname());
			System.out.println(profile.getProfileImage());

			Document document = new Document();
			try {
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
				document.open();

//				Image image2 = null;
//				try {
//					image2 = Image.getInstance("/home/aartek/Downloads/img.jpeg");
//					image2.scaleToFit(100f, 80f);
//					image2.setAbsolutePosition(88, 725);
//				} catch (MalformedURLException e) {
//
//					e.printStackTrace();
//				} catch (IOException e) {
//
//					e.printStackTrace();
//				}

				PdfPTable profiletable = new PdfPTable(3); // 2 columns.
				profiletable.setWidths(new int[] { 1, 1, 2 });
				PdfPCell pcell = new PdfPCell(new Paragraph(""));
				PdfPCell pCell1 = null;

				PdfPCell pCell2 = null;

				if (profile.getDesignation() == null && profile.getDescription() == null) {
					pCell1 = new PdfPCell(new Paragraph(profile.getProfileFname() + "\n" + "  " + "\n" + ""));
				} else {
					pCell1 = new PdfPCell(new Paragraph(profile.getProfileFname() + "\n" + profile.getDesignation()
							+ "\n" + profile.getDescription()));
				}

				if (profile.getProfileId() != null || profile.getProfileMobilePhone() != null
						|| profile.getProfileEmail() != null || profile.getExperience() != null
						|| profile.getProfileCity() != null) {

					pCell2 = new PdfPCell(new Paragraph("ID:    "
							+ (profile.getProfileId() != null ? profile.getProfileId() : " ") + "\n" + "Phone:    "
							+ (profile.getProfileMobilePhone() != null ? profile.getProfileMobilePhone() : " ") + "\n"
							+ "Email:   " + (profile.getProfileEmail() != null ? profile.getProfileEmail() : " ") + "\n"
							+ "Experience:    " + (profile.getExperience() != null ? profile.getExperience() : " ")
							+ "\n" + "Location:    "
							+ (profile.getProfileCity() != null ? profile.getProfileCity() : " ")));
				} else {
					pCell2 = new PdfPCell(new Paragraph("ID:    " + " " + "\n" + "Phone:    " + " " + "\n" + "Email:   "
							+ " " + "\n" + "Experience:    " + " " + "\n" + "Location:    " + " "));

				}
				pcell.setRight(80);
				pCell1.setFixedHeight(80);
				pCell2.setFixedHeight(80);
				profiletable.addCell(pcell);
				profiletable.addCell(pCell1);
				profiletable.addCell(pCell2);
				profiletable.setSpacingBefore(5f);
				profiletable.setSpacingAfter(5f);

				document.add(profiletable);
				// document.add(image2);

				PdfPTable table = new PdfPTable(1); // 3 columns.
				PdfPCell eCell1 = new PdfPCell(new Paragraph("EXPERIENCE"));
				;
				eCell1.setFixedHeight(40);
				table.addCell(eCell1);
				table.setSpacingBefore(5f);
				table.setSpacingAfter(5f);
				buildNestedTablesForExperience(table, list);
				document.add(table);

				PdfPTable table1 = new PdfPTable(1); // 3 columns.
				PdfPCell sCell1 = new PdfPCell(new Paragraph("SKILL"));
				sCell1.setFixedHeight(40);
				table1.addCell(sCell1);
				table1.setSpacingBefore(5f);
				table1.setSpacingAfter(5f);
				buildNestedTablesForSkills(table1);
				document.add(table1);

				PdfPTable table2 = new PdfPTable(1); // 3 columns.
				PdfPCell edCell1 = new PdfPCell(new Paragraph("Education"));
				edCell1.setFixedHeight(40);
				table2.addCell(edCell1);
				table2.setSpacingBefore(5f);
				table2.setSpacingAfter(5f);
				buildNestedTablesForEducation(table2, list);
				document.add(table2);

				PdfPTable table3 = new PdfPTable(1); // 3 columns.
				PdfPCell cCell1 = new PdfPCell(new Paragraph("Certification"));
				cCell1.setFixedHeight(40);
				table3.addCell(cCell1);
				table3.setSpacingBefore(5f);
				table3.setSpacingAfter(5f);
				buildNestedTablesForCertification(table3, list);
				document.add(table3);

				PdfPTable table4 = new PdfPTable(1); // 3 columns.
				PdfPCell mCell1 = new PdfPCell(new Paragraph("Memberships"));
				mCell1.setFixedHeight(40);
				table4.addCell(mCell1);
				table4.setSpacingBefore(5f);
				table4.setSpacingAfter(5f);
				buildNestedTablesForMemberships(table4, list);
				document.add(table4);

				PdfPTable table5 = new PdfPTable(1); // 3 columns.
				PdfPCell ptCell1 = new PdfPCell(new Paragraph("Patents"));
				ptCell1.setFixedHeight(40);
				table5.addCell(ptCell1);
				table5.setSpacingBefore(5f);
				table5.setSpacingAfter(5f);
				buildNestedTablesForPatents(table5, list);
				document.add(table5);

				PdfPTable table6 = new PdfPTable(1); // 3 columns.
				PdfPCell pbCell1 = new PdfPCell(new Paragraph("Publications"));
				pbCell1.setFixedHeight(40);
				table6.addCell(pbCell1);
				table6.setSpacingBefore(5f);
				table6.setSpacingAfter(5f);
				buildNestedTablesForPublications(table6, list);
				document.add(table6);

				PdfPTable table7 = new PdfPTable(1); // 3 columns.
				PdfPCell rCell1 = new PdfPCell(new Paragraph("Recommendations"));
				rCell1.setFixedHeight(40);
				table7.addCell(rCell1);
				table7.setSpacingBefore(5f);
				table7.setSpacingAfter(5f);
				buildNestedTablesForRecommendations(table7);
				document.add(table7);

				System.out.println("hhjiio");
				document.close();
				writer.close();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return profileRepository.pdfForProfileDetail(profileId);

	}

}
