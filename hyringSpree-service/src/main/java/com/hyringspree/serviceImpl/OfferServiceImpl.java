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
import com.hyringspree.model.Offer;
import com.hyringspree.model.OfferFilterDTO;
//import com.hyringspree.model.UsZip;
import com.hyringspree.model.UsZips;
import com.hyringspree.repository.OfferRepository;
import com.hyringspree.service.OfferService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

@Service
public class OfferServiceImpl implements OfferService {

	private static final Offer Offer = null;

	@Autowired
	private OfferRepository offerRepository;

	@Autowired
	private MailUtility mailUtility;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveOffer(Offer offerDetails) {
		return offerRepository.saveOffer(offerDetails);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Offer editOffer(Integer id) {
		return offerRepository.editOffer(id);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteOffer(Integer id) {
		return offerRepository.deleteOffer(id);
	}

	/*
	 * public List<Offer> getAllOffersForHistory(Offer offerDetails) {
	 * List<Offer> offerList =
	 * offerRepository.getAllOffersForHistory(offerDetails); return offerList;
	 * 
	 * }
	 */

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Offer> getAllOffers(Offer offerDetails) {
		return offerRepository.getAllOffers(offerDetails);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Offer> searchOfferBySelection(Offer offerdetail) {
		return offerRepository.searchOfferBySelection(offerdetail);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public UsZips getStateAndZip(String locationCity) {
		return offerRepository.getStateAndZip(locationCity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public UsZips getStateAndCity(String zip) {
		return offerRepository.getStateAndCity(zip);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateOffer(Offer updateOffer) {
		return offerRepository.updateOffer(updateOffer);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Offer> getAllOffersForHistory() {
		List<Offer> offerList = offerRepository.getAllOffersForHistory();
		return offerList;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Offer> getOffersByFilter(OfferFilterDTO OfferFilter) {

		return offerRepository.getOffersByFilter(OfferFilter);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Offer> pdfForOfferDetail(Integer offerId) {
		String directory = "OfferDetailPdf";
		String fileName = "OfferDetail" + offerId;
		File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File file = new File(directory + "/" + fileName + ".pdf");
		String path = file.getAbsolutePath();
		System.out.println(path);

		List<Offer> list = offerRepository.pdfForOfferDetail(offerId);

		for (Offer offer : list) {
			Document document = new Document();
			try {
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
				document.open();

				Font f = new Font(FontFamily.TIMES_ROMAN, 12.0f, Font.BOLD);
				Font f1 = new Font(FontFamily.TIMES_ROMAN, 8.0f);

				Paragraph right = new Paragraph("OFFER DETAILS", f);
				right.setIndentationLeft(50);
				document.add(right);
				Chunk glue = new Chunk(new VerticalPositionMark());

				PdfPTable table = new PdfPTable(1);
				Chunk c4 = new Chunk(offer.getOfferName() + "\n\n", f1);
				Chunk c5 = new Chunk(offer.getOfferStartDate(), f1);
				Chunk c10 = new Chunk("$"+offer.getOfferCost() +"\n\n", f);
                Chunk c6 = new Chunk(offer.getOfferDescription(), f1);
				Paragraph p2 = new Paragraph();

				p2.add(new Chunk(c4));
				p2.add(new Chunk(c5));
				p2.add(glue);
				p2.add(new Chunk(c10));
				p2.add(new Chunk(c6));
		    	PdfPCell cell1 = new PdfPCell(p2);
				Paragraph p = new Paragraph();
				Chunk c7 = new Chunk("Expiry:" + offer.getOfferEndDate(), f1);
				Chunk c8 = new Chunk("No.of Slot:" + offer.getNoOfSlot(), f1);
				Chunk c9 = new Chunk("City:" + offer.getLocationCity() + "," + offer.getState(), f1);
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
				Chunk c = new Chunk("Terms & conditions" + "\n\n", f);
				Chunk c1 = new Chunk(offer.getOfferTermsConditions() + "\n\n", f1);
				Chunk c2 = new Chunk("Additional informations" + "\n\n", f);
				Chunk c3 = new Chunk(offer.getAdditionalDetails() + "\n\n", f1);

				Paragraph p1 = new Paragraph();

				p1.add(new Chunk(c));
				p1.add(new Chunk(c1));
				p1.add(new Chunk(c2));
				p1.add(new Chunk(c3));

				PdfPCell cell = new PdfPCell(p1);
				cell.setFixedHeight(100);
				table1.addCell(cell);

				document.add(table1);
//		        PdfContentByte canvas = writer.getDirectContent();
//                Rectangle rect2 = new Rectangle(700, 700, 100, 700);
//			        rect2.setBackgroundColor(BaseColor.WHITE);
//			        rect2.setBorder(Rectangle.BOX);
//			        rect2.setBorderColor(BaseColor.BLUE);
//			        rect2.setBorderWidth(0.5f);
//			        canvas.rectangle(rect2);

				document.close();
				writer.close();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		return offerRepository.pdfForOfferDetail(offerId);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean sendOfferPdf(Offer pdfDetail) throws IOException {
		String offerEmail = pdfDetail.getEmail();
		Integer offerId = pdfDetail.getOfferId();
		System.out.println(offerEmail + offerId);
		if (offerEmail != null) {
			mailUtility.sendMailOfferPdf(offerEmail, offerId);
			return true;
		} else {
			return false;
		}
	}
}
