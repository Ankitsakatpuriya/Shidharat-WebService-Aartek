package com.hyringspree.repositoryImpl;

import static com.hyringspree.util.Dateutills.generateIdFormat;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.CompanyInfo;
import com.hyringspree.model.JobInfo;
import com.hyringspree.model.Offer;
import com.hyringspree.model.OfferFilterDTO;
import com.hyringspree.model.UsZips;
import com.hyringspree.repository.OfferRepository;

@Repository
public class OfferRepositoryImpl implements OfferRepository {

	@Autowired
	private SessionFactory factory;

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean saveOffer(Offer offerDetails) {

		Integer incrementiId = 0;
		Integer maxResult = getOfferMaxId();
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}

		String formatedProfileId = idFormat + incrementiId;
		Long convertTime;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		convertTime = timestamp.getTime();

		Long startDate = Long.parseLong(offerDetails.getOfferStartDate());
		Long endDate = Long.parseLong(offerDetails.getOfferEndDate());

		Date startDates = new Date(startDate);
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		String startDateText = df2.format(startDates);

		Date endDates = new Date(endDate);
		String endDateText = df2.format(endDates);

		offerDetails.setOfferStartDate(startDateText);
		offerDetails.setOfferEndDate(endDateText);
		offerDetails.setCreateTs(convertTime);
		offerDetails.setDeleteStatus(true);
		offerDetails.setOfferId(Integer.parseInt(formatedProfileId));

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		CompanyInfo company = null;
		List list = session.createQuery("select c from CompanyInfo c where c.companyName= :name")
				.setParameter("name", offerDetails.getCompanyName()).getResultList();

		Iterator<CompanyInfo> iterator = list.iterator();
		while (iterator.hasNext()) {
			company = iterator.next();
		}

		// offerDetails.setParent(company);
		session.saveOrUpdate(offerDetails);

		transaction.commit();
		session.close();
		return true;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getOfferMaxId() {

		String sqlQuery = "select max(offerId) from Offer";

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(sqlQuery);
		Integer maxProfileId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;

		transaction.commit();
		session.close();

		return maxProfileId;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Offer> searchOfferBySelection(Offer offerdetail) {
		Session session = factory.openSession();
		List<Offer> offerList = null;

		if (offerdetail.getFromDate() != null && offerdetail.getToDate() != null) {
			String queryString = "select * from offer where delete_status = true AND (";

			if (offerdetail.getOfferId() != null) {
				queryString += "offer_id= :offerId ";
			}
			if (offerdetail.getOfferId() != null) {
				if (offerdetail.getZip() != null && !offerdetail.getZip().equals("")) {
					queryString += "OR ";
				}
			}
			if (offerdetail.getZip() != null && !offerdetail.getZip().equals("")) {
				queryString += "zip= :zip OR ";
			}
			if (offerdetail.getOfferId() != null) {
				if (StringUtils.isBlank(offerdetail.getZip())) {
					queryString += "OR ";
				}
			}

			Long convertTime;
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			convertTime = timestamp.getTime();

			// Long startDate = offerdetail.getFromDate();
			// Long endDate = convertTime;

			// Long endDate = convertTime;
			// String currentDate = generateCurrentDate();
			Long startDate = offerdetail.getFromDate();
			Long endDate = offerdetail.getToDate();

			Date startDates = new Date(startDate);
			SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
			String startDateText = df2.format(startDates);

			Date endDates = new Date(endDate);
			// SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
			String endDateText = df2.format(endDates);
			
			System.out.println(startDateText +" hiiii1111111111111 "+  endDateText);

			if (startDate != null && endDate != null) {
				/*
				 * queryString +=
				 * "to_date (offer_start_date, 'DD/MM/YYYY') >= to_date (:fromDate, 'DD/MM/YYYY') AND "
				 * +
				 * "to_date (offer_start_date, 'DD/MM/YYYY')<= to_date (:toDate, 'DD/MM/YYYY') "
				 * ;
				 */
				queryString += "offer_start_date BETWEEN :fromDate AND :toDate  AND offer_end_date >= :toDate )";
			}
			Date d1 = null;
			Date d2 = null;
			Query<Offer> query = session.createSQLQuery(queryString).addEntity(Offer.class);
			if (offerdetail.getOfferId() != null) {
				query.setParameter("offerId", offerdetail.getOfferId());
			}
			if (offerdetail.getZip() != null && !offerdetail.getZip().equals("")) {
				query.setParameter("zip", offerdetail.getZip());
			}
			// query.setParameter("currentDate", currentDate);
			query.setParameter("fromDate", startDateText);
			query.setParameter("toDate", endDateText);
			

			offerList = query.getResultList();
			session.close();
		} else {
			String queryString = "select * from offer where delete_status = true and (";
			if (offerdetail.getOfferId() != null) {
				queryString += "offer_id= :offerId ";
			}
			if (offerdetail.getOfferId() != null) {
				/*
				 * if (offerdetail.getZip() == null &&
				 * offerdetail.getZip().equals("")) { queryString += ")"; }
				 */
				if (offerdetail.getZip() != null && !offerdetail.getZip().equals("")) {
					queryString += "OR ";
				}
			}
			if (offerdetail.getZip() != null && !offerdetail.getZip().equals("")) {
				queryString += "zip= :zip ";
			}
			queryString += ")";
			Query q = session.createSQLQuery(queryString).addEntity(Offer.class);
			if (offerdetail.getOfferId() != null) {
				q.setParameter("offerId", offerdetail.getOfferId());
				if (offerdetail.getOfferId() != null
						&& (offerdetail.getZip() != null && !offerdetail.getZip().equals(""))) {
					q.setParameter("offerId", offerdetail.getOfferId());
					q.setParameter("zip", offerdetail.getZip());
				}

			} else {
				if (offerdetail.getZip() != null && !offerdetail.getZip().equals("")) {
					q.setParameter("zip", offerdetail.getZip());
				}
			}
			offerList = q.getResultList();
			session.close();
		}
		return offerList;

	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public static boolean checkOfferId(String offerId, Session session) {
		List<Offer> offerlist = session.createQuery("select o from Offer o where o.offerId='" + offerId + "'").list();
		if (offerlist.isEmpty()) {
			session.close();
			return true;
		} else {
			session.close();
			return false;
		}

	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Offer editOffer(Integer id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Offer offer = session.get(Offer.class, id);
		transaction.commit();
		session.close();
		return offer;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deleteOffer(Integer id) {
		if (id != null) {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Offer offer = session.get(Offer.class, id);
			Boolean status = offer.getDeleteStatus();
			if (status) {
				offer.setDeleteStatus(false);
			}
			session.saveOrUpdate(offer);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}

	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Offer> getAllOffers(Offer offerdetail) {
		Session session = factory.openSession();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// Date date = new Date();
		List<Offer> offer = session.createQuery("from Offer where delete_status = true").list();
		session.close();
		return offer;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Offer> getAllOffersForHistory() {
		Session session = factory.openSession();
		List<Offer> offerList = null;

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String strDate = dateFormat.format(date);

		// System.out.println(offerdetail.getOfferEndDate()); //BETWEEN
		// OFFER_END_DATE AND
		String strQuery = "select * from offer where OFFER_END_DATE <= ?1";

		Query<Offer> q = session.createSQLQuery(strQuery).addEntity(Offer.class);
		// q.setParameter("OFFER_END_DATE", offerdetail.getOfferEndDate());
		q.setParameter(1, strDate);

		offerList = q.getResultList();
		session.close();
		return offerList;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public UsZips getStateAndZip(String locationCity) {
		Session session = factory.openSession();
		// String strQuery = "select * from uszips where city = ?1";
		// String strQueryN = "select * from uszips where upper(city) like
		// '%"+locationCity+"%' or lower(city) like '%"+locationCity+"%' or city
		// like '%"+locationCity+"%' ";
		String strQuery = "select * from uszips where lower(city) like :lowerCity";

		Query query = session.createSQLQuery(strQuery).addEntity(UsZips.class);
		query.setParameter("lowerCity", '%' + locationCity.toLowerCase() + '%');
		
		List<UsZips> uszip = query.getResultList();
		UsZips uszip1 = new UsZips();

		for (UsZips listzip : uszip) {
			String state = listzip.getdState();
			uszip1.setdState(state);
			System.out.println("uszip.getState()" + state);
			String zip = listzip.getZip();
			uszip1.setZip(zip);
			System.out.println("uszip.getZip()" + zip);
		}
		session.close();
		return uszip1;

	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public UsZips getStateAndCity(String zip) {
		Session session = factory.openSession();
		String strQuery = "select * from uszips where zip = ?1";

		Query query = session.createSQLQuery(strQuery).addEntity(UsZips.class);
		query.setParameter(1, zip);
		List<UsZips> uszip = query.getResultList();
		UsZips uszip1 = new UsZips();

		for (UsZips listzip : uszip) {
			String state = listzip.getdState();
			uszip1.setdState(state);
			System.out.println("uszip.getState()" + state);
			String city = listzip.getCity();
			uszip1.setCity(city);
			System.out.println("listzip.getCity()" + city);
		}
		session.close();
		return uszip1;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updateOffer(Offer updateOffer) {
		if (updateOffer.getOfferId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(updateOffer);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {

			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Offer> getOffersByFilter(OfferFilterDTO offerFilter) {
		Session session = factory.openSession();
		List<Offer> offerList = null;
		String sqlQuery = "";

		if ((offerFilter.getAutomobile() != null && !offerFilter.getAutomobile().equals(""))
				|| (offerFilter.getAnalytics() != null && !offerFilter.getAnalytics().equals(""))
				|| (offerFilter.getBusiness_Intelligence() != null
						&& !offerFilter.getBusiness_Intelligence().equals(""))
				|| (offerFilter.getBeauty_Spa() != null && !offerFilter.getBeauty_Spa().equals(""))
				|| (offerFilter.getBanking_Financial() != null && !offerFilter.getBanking_Financial().equals(""))
				|| (offerFilter.getBaby_Kids_Toys() != null && !offerFilter.getBaby_Kids_Toys().equals(""))
				|| (offerFilter.getConstruction() != null && !offerFilter.getConstruction().equals(""))
				|| (offerFilter.getDelivery() != null && !offerFilter.getDelivery().equals(""))
				|| (offerFilter.getEntertainment() != null && !offerFilter.getEntertainment().equals(""))
				|| (offerFilter.getElectronics() != null && !offerFilter.getElectronics().equals(""))
				|| (offerFilter.getExport_Import() != null && !offerFilter.getExport_Import().equals(""))
				|| (offerFilter.getFood_Drinks() != null && !offerFilter.getFood_Drinks().equals(""))
				|| (offerFilter.getHome_Improvement() != null && !offerFilter.getHome_Improvement().equals(""))
				|| (offerFilter.getOil_Gas() != null && !offerFilter.getOil_Gas().equals(""))) {
			sqlQuery = "select * from offer where delete_status = true ";

			if (offerFilter.getAutomobile() != null && offerFilter.getAutomobile() != "") {
				if (offerFilter.getAutomobile().equals("brand")) {
					System.out.println("Automobile.........");
					sqlQuery += " AND offer_name = 'brand'";
					// lower(company_info.company_name) = lower('Google')
				}
			}

			if (offerFilter.getAnalytics() != null && offerFilter.getAnalytics() != "") {
				if (offerFilter.getAnalytics().equals("brand")) {
					sqlQuery += " AND offer_name = 'brand'";
				}
			}

			if (offerFilter.getBusiness_Intelligence() != null && offerFilter.getBusiness_Intelligence() != "") {
				if (offerFilter.getBusiness_Intelligence().equals("brand")) {
					sqlQuery += " AND offer_name = 'brand'";
				}
			}

			if (offerFilter.getBeauty_Spa() != null && offerFilter.getBeauty_Spa() != "") {
				if (offerFilter.getBeauty_Spa().equals("brand")) {
					sqlQuery += " AND offer_name = 'brand'";
				}
			}

			if (offerFilter.getBanking_Financial() != null && offerFilter.getBanking_Financial() != "") {
				if (offerFilter.getBanking_Financial().equals("brand")) {
					sqlQuery += " AND offer_name = 'brand'";
				}
			}

			if (offerFilter.getBaby_Kids_Toys() != null && offerFilter.getBaby_Kids_Toys() != "") {
				if (offerFilter.getBaby_Kids_Toys().equals("brand")) {
					sqlQuery += " AND offer_name = 'brand'";
				}
			}

			if (offerFilter.getConstruction() != null && offerFilter.getConstruction() != "") {
				if (offerFilter.getConstruction().equals("brand")) {
					sqlQuery += " AND offer_name = 'brand'";
				}
			}

			if (offerFilter.getDelivery() != null && offerFilter.getDelivery() != "") {
				if (offerFilter.getDelivery().equals("brand")) {
					sqlQuery += " AND offer_name = 'brand'";
				}
			}

			if (offerFilter.getEntertainment() != null && offerFilter.getEntertainment() != "") {
				if (offerFilter.getEntertainment().equals("Holtsville")) {
					sqlQuery += " AND location_city = 'Holtsville'";
				}
			}

			if (offerFilter.getElectronics() != null && offerFilter.getElectronics() != "") {
				if (offerFilter.getElectronics().equals("Holtsville")) {
					sqlQuery += " AND location_city = 'Holtsville'";
				}
			}

			if (offerFilter.getExport_Import() != null && offerFilter.getExport_Import() != "") {
				if (offerFilter.getExport_Import().equals("Holtsville")) {
					sqlQuery += " AND location_city = 'Holtsville'";
				}
			}

			if (offerFilter.getFood_Drinks() != null && offerFilter.getFood_Drinks() != "") {
				if (offerFilter.getFood_Drinks().equals("Holtsville")) {
					sqlQuery += " AND location_city = 'Holtsville'";
				}
			}

			if (offerFilter.getHome_Improvement() != null && offerFilter.getHome_Improvement() != "") {
				if (offerFilter.getHome_Improvement().equals("Holtsville")) {
					sqlQuery += " AND location_city = 'Holtsville'";
				}
			}

			if (offerFilter.getOil_Gas() != null && offerFilter.getOil_Gas() != "") {
				if (offerFilter.getOil_Gas().equals("Holtsville")) {
					sqlQuery += " AND location_city = 'Holtsville'";
				}
			}

			Query<Offer> query = session.createSQLQuery(sqlQuery).addEntity(Offer.class);
			offerList = query.getResultList();
			session.close();
		}
		session.close();
		return offerList;
	}
	@Transactional(isolation = Isolation.READ_COMMITTED)
    public List<Offer> pdfForOfferDetail(Integer offerId) {
		Session session = factory.openSession();
		List offerList;
		String queryString = "SELECT * FROM offer where offer_id=?1";

		Query query = session.createSQLQuery(queryString).addEntity(Offer.class);
		query.setParameter(1, offerId);
		offerList = query.getResultList();
		session.close();
		return offerList;
}

}
