package com.hyringspree.common.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyringspree.model.RecruiterInfo;
import com.hyringspree.service.CompanyService;
import com.hyringspree.service.OfferService;
import com.hyringspree.service.ProfileService;
import com.hyringspree.util.IConstant;

@Service
public class MailUtility {

	@Autowired
	private OfferService offerService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private CompanyService companyService;

	/**
	 * getSession
	 * 
	 * @return session
	 */

	public static Session getSession() {
		Properties props = new Properties();
		props.put(IConstant.SMTP_HOST, IConstant.PROP_SMTP_HOST);
		props.put(IConstant.SMTP_AUTH, IConstant.PROP_SMTP_AUTH);
		props.put(IConstant.SMTP_PORT, IConstant.PROP_SMTP_PORT);

		props.put(IConstant.SMTP_SOCKET_FACTORY, IConstant.PROP_SMTP_SOCKET_FACTORY);
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(IConstant.HYRING_SPREE_MAIL_ID, IConstant.HYRING_SPREE_PASSWORD);
			}
		});
		return session;
	}

	/**
	 * sendMailForForgotPassword
	 * 
	 * @param emailId
	 * 
	 */
	public static void sendMailForForgotPassword(String emailId) {
		try {
			MimeMessage message = new MimeMessage(getSession());
			message.setFrom(new InternetAddress(IConstant.HYRING_SPREE_MAIL_ID));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
			message.setSubject(IConstant.FORGOT_PASSWORD_SUBJECT);
			final MimeBodyPart textPart = new MimeBodyPart();
			textPart.setContent(IConstant.FORGOT_PASSWORD_MESSAGE, IConstant.TEXT);
			final MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(
					"\n<a href='http://localhost:4200/resetPassword'>resetPassword</a>",
					"text/html");
			final Multipart mp = new MimeMultipart("alternative");
			mp.addBodyPart(textPart);
			mp.addBodyPart(htmlPart);
			message.setContent(mp);
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("success message for forgot password");
	}

	/**
	 * sendMailForRegistration
	 * 
	 * @param emailId
	 * 
	 */

	public static void sendMailForRegistration(String emailId) {
		try {
			MimeMessage message = new MimeMessage(getSession());
			message.setFrom(new InternetAddress(IConstant.HYRING_SPREE_MAIL_ID));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
			message.setSubject(IConstant.REGISTRATION_SUBJECT);
			message.setContent(IConstant.REGISTRATION_MESSAGE, IConstant.TEXT);

			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("success message for registration");
	}

	public boolean sendMailProfilePdf(String profileEmail, Integer profileId) throws IOException {

		String directory = "ProfileDetailPdf";
		String fileName = "jobseekerProfile" + profileId;
		File file = new File(directory + "/" + fileName + ".pdf");
		// File file = new File("");
		String path = file.getAbsolutePath();
		System.out.println(path);
		if (!file.exists()) {
			profileService.pdfForProfileDetail(profileId);
		}
		try {
			MimeMessage message = new MimeMessage(getSession());
			message.setFrom(new InternetAddress(IConstant.HYRING_SPREE_MAIL_ID));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(profileEmail));
			message.setSubject(IConstant.PROFILEPDF_SUBJECT);
			message.setText(IConstant.PROFILEPDF_MESSAGE, IConstant.TEXT);
			MimeBodyPart attachPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			String attachFile = path;
			attachPart.attachFile(attachFile);
			multipart.addBodyPart(attachPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("pdf send successfully");
		return true;
	}

	public boolean sendMailOfferPdf(String offerEmail, Integer offerId) throws IOException {
		String directory = "OfferDetailPdf";
		String fileName = "OfferDetail" + offerId;
		File file = new File(directory + "/" + fileName + ".pdf");
		// File file = new File("");
		String path = file.getAbsolutePath();
		System.out.println(path);
		if (!file.exists()) {
			offerService.pdfForOfferDetail(offerId);
		}
		try {
			MimeMessage message = new MimeMessage(getSession());
			message.setFrom(new InternetAddress(IConstant.HYRING_SPREE_MAIL_ID));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(offerEmail));
			message.setSubject(IConstant.OFFERdETAILPDF_SUBJECT);
			message.setText(IConstant.OFFERdETAILPDF_MESSAGE, IConstant.TEXT);
			MimeBodyPart attachPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			String attachFile = path;
			attachPart.attachFile(attachFile);
			multipart.addBodyPart(attachPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(" offer pdf send successfully");
		return true;
	}

	public boolean sendMailCompanyProfilePdf(String recruiterEmail, Integer companyId) throws IOException {
		String directory = "CompanyProfilePdf";
		String fileName = "CompanyProfile" + companyId;
		File file = new File(directory + "/" + fileName + ".pdf");
		// File file = new File("");
		String path = file.getAbsolutePath();
		System.out.println(path);
		if (!file.exists()) {
			companyService.pdfForCompanyProfileDetail(companyId);
		}
		try {
			MimeMessage message = new MimeMessage(getSession());
			message.setFrom(new InternetAddress(IConstant.HYRING_SPREE_MAIL_ID));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recruiterEmail));
			message.setSubject(IConstant.COMPANY_PROFILE_PDF_SUBJECT);
			message.setText(IConstant.COMPANY_PROFILE_PDF_MESSAGE, IConstant.TEXT);
			MimeBodyPart attachPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			String attachFile = path;
			attachPart.attachFile(attachFile);
			multipart.addBodyPart(attachPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(" Company Profile pdf send successfully");
		return true;

	}

}
