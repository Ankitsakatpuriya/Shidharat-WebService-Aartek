package com.hyringspree.service;

import java.io.IOException;
import java.util.List;

import com.hyringspree.model.Offer;
import com.hyringspree.model.OfferFilterDTO;
import com.hyringspree.model.UsZips;

public interface OfferService {

	public boolean saveOffer(Offer offerDetails);
	
	public Offer editOffer(Integer id);
	
	public boolean deleteOffer(Integer id);
	
	public List<Offer> getAllOffers(Offer offerDetails);
	
	public List<Offer> getAllOffersForHistory();
	
	public List<Offer> searchOfferBySelection(Offer offerdetail);
	
	public  UsZips getStateAndZip(String locationCity);
	
	public UsZips getStateAndCity(String zip);

	public boolean updateOffer(Offer updateOffer);
	
	public List<Offer> getOffersByFilter(OfferFilterDTO OfferFilter);

	public List<Offer> pdfForOfferDetail(Integer offerId);

	public boolean sendOfferPdf(Offer pdfDetail) throws IOException ;

	
	
}
