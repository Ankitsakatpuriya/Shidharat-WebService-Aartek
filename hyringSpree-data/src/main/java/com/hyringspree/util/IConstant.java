package com.hyringspree.util;

import java.text.SimpleDateFormat;

/**
 * The Interface IConstant
 */
public interface IConstant {
	public static final String SMTP_HOST = "mail.smtp.host";
	public static final String SMTP_AUTH = "mail.smtp.auth";
	public static final String SMTP_PORT = "mail.smtp.port";
	public static final String SMTP_SOCKET_FACTORY = "mail.smtp.socketFactory.class";

	public static final String PROP_SMTP_HOST = "smtp.gmail.com";
	public static final String PROP_SMTP_AUTH = "true";
	public static final String PROP_SMTP_PORT = "465";
	public static final String PROP_SMTP_SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";

	public static final String HYRING_SPREE_MAIL_ID = "spreehyring@gmail.com";
	public static final String HYRING_SPREE_PASSWORD = "HS@123456#";

	public static final String FORGOT_PASSWORD_SUBJECT = "change password";
	public static final String REGISTRATION_SUBJECT = "verification";
	public static final String FORGOT_PASSWORD_MESSAGE = "please click on below link to change your password";
	public static final String REGISTRATION_MESSAGE = "please click on below link for verification" ;
	public static final String TEXT = "text/html";

	public static final String OFFER_DETAIL_SUBJECT = "Offer Detail";
	public static final String PROFILEPDF_SUBJECT = "Jobseeker profile with attachment";
	public static final String PROFILEPDF_MESSAGE = "Please find  attachment";

	public static final String SUCCESS = "200";
	public static final String ERROR = "400";

	public static final String JOB_SEEKER_DETAIL_SUBJECT = "Job Seeker Profile Detail";

	public static final String PATH = "Home\\Desktop\\Multiple_job_save_file";
	public static final String TAG = "Job";
	public static final String CSV = "csv";
	public static final String XML = "xml";
	public static final String SAMPLE_CSV_FILENAME_WITHPATH = "Home\\Desktop\\Multiple_job_save_file";

	public static final SimpleDateFormat FORMATTER_DD_MM_YY = new SimpleDateFormat("dd/MM/yyyy");
	public static final String IMAGE_PATH = "/home/amit/Desktop/images";

	public static final String DELETE_CERTIFICATIONINFO_CERTIFICATIONID = "/deleteCertificationInfo/{certificationId}";
	public static final String EDITCERTIFICATIONINFO_CERTIFICATIONID = "/editCertificationInfo/{certificationId}";
	public static final String SAVEJOBSEEKER_CERTIFICATE = "/savejobSeekerCertificate";
	public static final String UPDATE_CERTIFICATEINFO = "/updateCertificationInfo";
	public static final String GET_CERTIFICATE_BY_PROFILEID = "/getCertificationByProfileId/{profileId}";

	public static final String DELETE_COMPANY_RECORDID = "/deleteCompanyRecord/{id}";
	public static final String EDITCOMPANYINFO_BYID = "/editCompanyInfoById/{id}";
	public static final String SAVECOMPANY_INFO = "/saveCompanyInfo";
	public static final String UPDATE_COMPANYINFO = "/updateCompanyInfo";
	public static final String GETALLCOMPANY_DETAILS = "/getAllCompanyDetails";
	public static final String SEARCHCOMPANY_BY_SELECTION = "/searchCompanyBySelection";
	public static final String GET_COMPANY_BY_FILTER = "/getCompanyByFilter";

	public static final String SEARCH_JOB_FILTER_FOR_HOMEPAGE = "/searchJobFilterForHomepage";

	public static final String DELETECOMPENSATION_COMPENSATIONID = "/deleteCompensation/{compensationId}";

	public static final String SAVECONTACT_DETAILS = "/saveContactDetails";

	public static final String DOWNLOAD_SAMPLE_CSV = "/downloadSampleCSV";

	public static final String DELETE_EDUCATIONINFO_EDUCATIONID = "/deleteEducationInfo/{educationId}";
	public static final String EDIT_EDUCATIONINFO_EDUCATIONID = "/editEducationInfo/{educationId}";
	public static final String SAVEJOBSEEKER_EDUCATION = "/jobSeekerEducation";
	public static final String UPDATE_EDUCATIONINFO = "/updateEducationInfo";
	public static final String GET_EDUCATIONINFO_BY_PROFILEID_PROFILEID = "/getEducationInfoByProfileId/{profileId}";

	public static final String DELETE_EXPERIENCEINFO_EXPERIENCEID = "/deleteExperienceInfo/{experienceId}";
	public static final String EDIT_EXPERIENCEINFO_EXPERIENCEID = "/editExperienceInfo/{experienceId}";
	public static final String SAVEJOBSEEKER_EXPERIENCE = "/jobSeekerExperience";
	public static final String UPDATE_EXPERIENCEINFO = "/updateExperienceInfo";
	public static final String GET_EXPERIENCEINFO_BY_PROFILEID_PROFILEID = "/getExperienceInfoByProfileId/{profileId}";

	public static final String FORGET_PASSWORD = "/forgetPassword";

	public static final String DELETE_JOB_JOBID = "/deleteJob/{jobId}";
	public static final String EDIT_JOBINFO_JOBID = "/editJobInfo/{jobId}";
	public static final String SAVE_SINGLEJOB = "/saveJob";
	public static final String UPDATE_JOBINFO = "/updateJobInfo";
	public static final String GET_ALLJOBS_DETAILS = "/getAllJobsDetails";
	public static final String SAVE_MULTIPLEJOB = "/saveMultipleJob";
	public static final String SEARCH_JOB_BY_SELECTION = "/searchJobBySelection";

	public static final String GET_JOBTYPE_DATA = "/jobType";
	public static final String GET_TEXTERM_DATA = "/texTerm";
	public static final String GET_IMMIGRATINON_DATA = "/immigrationStatus";
	public static final String GET_COMPENSATION_DATA = "/compensation";

	public static final String DELETE_JOBSEEKER_PROFILEID = "/deleteJobSeeker/{profileId}";
	public static final String EDIT_JOBSEEKER_PROFILE_PROFILEID = "/editJobSeekerProfile/{profileId}";
	public static final String SAVEJOBSEEKER_DETAILS = "/saveJobSeekersDetails";
	public static final String UPDATE_JOBSEEKER_PROFILE = "/updateJobSeekerProfile";
	public static final String GET_JOBSEEKER_BY_PROFILEID_PROFILEID = "/getJobseekerByProfileId/{profileId}";
	public static final String SEARCH_PROFILE_BY_PROFILEID = "/searchProfileByProfileId";
	public static final String SEARCH_JOBSEEKER_PROFILE_BY_KEYWORDS = "/searchJobSeekerProfileByKeywords";
	public static final String GET_JOBSEEKER_BY_PROFILEID = "/getJobseekerByProfileId/{profileId}";
	public static final String SEND_PROFILE_PDFMAIL = "/sendProfilePdfMail";
	public static final String GET_PROFILE_DETAIL_BYID = "/getprofileDetailById/{profileId}";

	public static final String DELETE_MEMBERSHIP_MEMBERSHIPID = "/deleteMembership/{membershipId}";
	public static final String EDIT_MEMBERSHIP_MEMBERSHIPID = "/editMembership/{membershipId}";
	public static final String SAVEJOBSEEKER_MEMBERSHIP = "/jobSeekerMembership";
	public static final String UPDATE_MEMBERSHIP = "/updateMembership";
	public static final String GET_MEMBERSHIP_BY_PROFILEID_PROFILEID = "/getMembershipByProfileId/{profileId}";

	public static final String DELETE_OFFER_ID = "/deleteOffer/{id}";
	public static final String SAVE_OFFER = "/saveOffer";
	public static final String UPDATE_OFFER = "/updateOffer";
	public static final String EDIT_OFFER_ID = "/editOffer/{id}";
	public static final String GET_ALL_OFFERS = "/getAllOffers";
	public static final String SEARCH_OFFER_BY_SELECTION = "/searchOfferBySelection";
	public static final String GET_ALL_OFFERS_FOR_HISTORY = "/getAllOffersForHistory";
	public static final String GET_STATE_AND_ZIP_LOCATIONCITY = "/getStateAndZip/{locationCity}";
	public static final String GET_STATE_AND_CITY_ZIP = "/getStateAndCity/{zip}";

	public static final String DELETE_PATANTINFO_PATENTID = "/deletePatentInfo/{patentId}";
	public static final String EDIT_PATENTINFO_PATENTID = "/editPatentInfo/{patentId}";
	public static final String SAVEJOBSEEKER_PATENT = "/jobSeekerPatent";
	public static final String UPDATE_PATENTINFO = "/updatePatentInfo";
	public static final String GET_PATENTINFO_BY_PROFILEID_PROFILEID = "/getPatentInfoByProfileId/{profileId}";

	public static final String DELETE_PROFILE_ID = "/deleteProfile/{id}";
	public static final String EDIT_PROFILE_ID = "/editProfile/{id}";
	public static final String SAVE_PROFILE = "/saveProfile";
	public static final String GET_PROFILES = "/getProfiles";

	public static final String DELETE_PUBLICATIONINFO_PUBLICATIONID = "/deletePublicationInfo/{publicationId}";
	public static final String EDIT_PUBLICATIONINFO_PUBLICATIONID = "/editPublicationInfo/{publicationId}";
	public static final String SAVEJOBSEEKER_PUBLICATION = "/jobSeekerPublication";
	public static final String UPDATE_PUBLICATIONINFO = "/updatePublicationInfo";
	public static final String GET_PUBLICATIONINFO_BY_PROFILEID_PROFILEID = "/getPublicationInfoByProfileId/{profileId}";

	public static final String EDIT_RECOMENDATION_RECOMENDATIONID = "/editRecomendation/{recomendationId}";
	public static final String UPDATE_RECOMENDATIONINFO = "/updateRecomdationInfo";

	public static final String DELETE_RECRUITER_ID = "/deleteRecruiter/{id}";
	public static final String EDIT_RECRUITER_ID = "/editRecruiter/{id}";
	public static final String SAVE_RECRUITER = "/saveRecruiter";
	public static final String GET_ALL_RECRUITER_DETAILS = "/getAllRecruiterDetails";
	public static final String SEARCH_RECRUITER_BY_SELECTION = "/searchRecruiterBySelection";
	public static final String SEARCH_BY_RECRUITER_FILTER = "/searchByRecruiterFilter";
	public static final String UPDATE_RECRUITERINFO = "/updateRecruiterInfo";

	public static final String EDIT_SKILLMATRIX_SKILLID = "/editSkillMatrix/{skillId}";
	public static final String UPDATE_SKILLMATRIX = "/updateSkillMatrix";

	public static final String LOGIN_USER = "/login";
	public static final String LOGOUT_USER = "/logout";
	public static final String GET_JOB_BY_FILTER = "/getJobsByFilter";
	public static final String GET_OFFER_BY_FILTER = "/getOffersByFilter";
	public static final String USER_TOKEN = "/token";
	public static final String GET_OFFER_DETAIL_BYID = "/getOfferDetailById/{offerId}";

	public static final String SEND_MAIL_FOR_OFFER_DETAIL = "/sendMailForOfferDetail";
	public static final String OFFERdETAILPDF_SUBJECT = "Offer Detail with attachment";
	public static final String OFFERdETAILPDF_MESSAGE = "Please find  attachment";
	
	public static final String GENRATE_COMPANY_PDF = "/genrateCompanyPdf/{companyId}";
	public static final String SEND_MAIL_FOR_COMPANY_PROFILE = "/sendMailForCompanyProfile/{companyId}";
	public static final String COMPANY_PROFILE_PDF_SUBJECT = "Company Profile with attachment";
	public static final String COMPANY_PROFILE_PDF_MESSAGE = "Please find  attachment";
	public static final String GET_COMPANY_PROFILE_BY_ID = "/getCompanyProfileById/{companyId}";
	public static final String RESET_PASSWORD = "/resetPassword";
	public static final String CHECK_JOBSEEKER_BY_EMAILID = "/checkJobseekerByEmail/{emailId}";
	public static final String CHECK_EMPLOYER_BY_EMAILID = "/checkemployerByEmail/{emailId}";
	public static final String GET_ALL_COUNT_FOR_DASHBOARD ="/getALLCountForDashboard";
	
}
