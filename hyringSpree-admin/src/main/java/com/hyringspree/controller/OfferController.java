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
import com.hyringspree.model.Offer;
import com.hyringspree.model.OfferFilterDTO;
import com.hyringspree.model.UsZips;
import com.hyringspree.service.OfferService;
import com.hyringspree.util.IConstant;

@CrossOrigin(origins = "*")
@RestController
public class OfferController {

	@Autowired
	private OfferService offerService;

	@PostMapping(path = IConstant.SAVE_OFFER)
	public String saveOffer(@RequestBody String offer) {
		Gson gson = new Gson();
		Offer offerDetails = gson.fromJson(offer, Offer.class);
		boolean status = offerService.saveOffer(offerDetails);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@PostMapping(path = IConstant.SEARCH_OFFER_BY_SELECTION)
	public List<Offer> searchOfferBySelection(@RequestBody String searchoffer) {

		Gson gson = new Gson();
		Offer offerdetail = gson.fromJson(searchoffer, Offer.class);
		return offerService.searchOfferBySelection(offerdetail);
	}

	@GetMapping(path = IConstant.EDIT_OFFER_ID)
	public Offer editOffer(@PathVariable Integer id) {
		return offerService.editOffer(id);
	}

	@PostMapping(path = IConstant.UPDATE_OFFER)
	public String updateOffer(@RequestBody String offer) {
		Gson gson = new Gson();
		Offer updateOffer = gson.fromJson(offer, Offer.class);
		boolean status = offerService.updateOffer(updateOffer);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@DeleteMapping("/deleteOffer/{id}")
	public String deleteOffer(@PathVariable Integer id) {
		boolean status = offerService.deleteOffer(id);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path = IConstant.GET_ALL_OFFERS)
	public List<Offer> getAllOffers(Offer offerDetails) {
		return offerService.getAllOffers(offerDetails);
	}

	@GetMapping(path = IConstant.GET_ALL_OFFERS_FOR_HISTORY)
	public List<Offer> getAllOffersForHistory() {

		List<Offer> offerList = offerService.getAllOffersForHistory();
		return offerList;
	}

	@GetMapping(path = IConstant.GET_STATE_AND_ZIP_LOCATIONCITY)
	public UsZips getStateAndZip(@PathVariable String locationCity) { 

		return offerService.getStateAndZip(locationCity);
	}

	@GetMapping(path = IConstant.GET_STATE_AND_CITY_ZIP)
	public UsZips getStateAndCity(@PathVariable String zip) {

		return offerService.getStateAndCity(zip);
	}
	
	@PostMapping(path = IConstant.GET_OFFER_BY_FILTER)
	public List<Offer> getOffersByFilter(@RequestBody String offerFilter){
		Gson gson = new Gson();
		OfferFilterDTO filterOffers = gson.fromJson(offerFilter, OfferFilterDTO.class);
		return offerService.getOffersByFilter(filterOffers);
	}
	@GetMapping(path = IConstant.GET_OFFER_DETAIL_BYID)
	public List<Offer> pdfForOfferDetail(@PathVariable Integer offerId) {
		System.out.println("pdf........");
		return offerService.pdfForOfferDetail(offerId);
		
	}
	@PostMapping(path = IConstant.SEND_MAIL_FOR_OFFER_DETAIL)
	public boolean sendOfferPdf(@RequestBody String sendEmailObj) throws IOException {
		Gson gson = new Gson();
		Offer pdfDetail = gson.fromJson(sendEmailObj, Offer.class);
		return offerService.sendOfferPdf(pdfDetail);

	}
}
