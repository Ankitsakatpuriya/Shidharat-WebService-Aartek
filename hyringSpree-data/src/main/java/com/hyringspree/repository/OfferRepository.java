package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.JobFilterDTO;
import com.hyringspree.model.JobInfo;
import com.hyringspree.model.Offer;
import com.hyringspree.model.OfferFilterDTO;
import com.hyringspree.model.UsZips;

public interface OfferRepository {

	public boolean saveOffer(Offer offerDetails);
	
	public List<Offer> searchOfferBySelection(Offer offerdetail);
	
	public Offer editOffer(Integer id);
	
	public boolean deleteOffer(Integer id);
	
	public List<Offer> getAllOffers(Offer offerdetail);
	
	public List<Offer> getAllOffersForHistory();
	
	public UsZips getStateAndZip(String locationCity);
	
	public UsZips getStateAndCity(String zip);
	
	public boolean updateOffer(Offer updateOffer);
	
	public List<Offer> getOffersByFilter(OfferFilterDTO offerFilter);

	public List<Offer> pdfForOfferDetail(Integer offerId);

}
