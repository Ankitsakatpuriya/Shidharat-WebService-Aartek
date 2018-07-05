package com.hyringspree.repositoryImpl;

import static com.hyringspree.util.Dateutills.generateIdFormat;

import java.sql.Timestamp;
import java.util.Date;
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
import com.hyringspree.repository.CompanyRepository;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

	@Autowired
	private SessionFactory factory;

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean saveCompanyInfo(CompanyInfo saveCompanyInfo) {
		Integer incrementiId = 0;
		Integer maxResult = getCompanyMaxId();
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}
		if (saveCompanyInfo != null) {
			String formatedProfileId = idFormat + incrementiId;
			Long convertTime;
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			convertTime = timestamp.getTime();
			saveCompanyInfo.setCompanyId(Integer.parseInt(formatedProfileId));
			saveCompanyInfo.setCreateTs(convertTime);
			saveCompanyInfo.setDeleteStatus(true);

			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(saveCompanyInfo);
			tx.commit();
			session.close();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Get Company MaxId
	 * 
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getCompanyMaxId() {

		String sqlQuery = "select max(companyId) from CompanyInfo";
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery(sqlQuery);

		Integer maxProfileId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;

		transaction.commit();
		session.close();

		return maxProfileId;
	}

	/**
	 * save JobMembershipDetails
	 * 
	 * @param Membership
	 *            memberInfo
	 * @return
	 */

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<CompanyInfo> getAllCompanyDetails() {
		Session session = factory.openSession();
		List<CompanyInfo> companyInfo = session.createQuery("from CompanyInfo where delete_status = true").list();
		session.close();
		return companyInfo;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean editCompanyRecord(CompanyInfo editCompanyInfo) {

		if (editCompanyInfo.getCompanyId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(editCompanyInfo);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}

	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deleteCompanyRecord(Integer id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		CompanyInfo companyDetails = session.get(CompanyInfo.class, id);
		if (companyDetails != null) {
			Boolean status = companyDetails.getDeleteStatus();
			if (status) {
				companyDetails.setDeleteStatus(false);
			}
			session.saveOrUpdate(companyDetails);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<CompanyInfo> searchCompanyBySelection(CompanyInfo searchCompany) {
		Session session = factory.openSession();
		List<CompanyInfo> companyList = null;

		if (searchCompany.getFromDate() != null && searchCompany.getToDate() != null) {
			String queryString = "select * from company_info where delete_status = true AND ( ";
			if (searchCompany.getCompanyId() != null) {
				queryString += "COMPANY_ID= :companyId ";
			}
			if (searchCompany.getCompanyId() != null) {
				if (searchCompany.getCompanyPostalCode() != null && !searchCompany.getCompanyPostalCode().equals("")) {
					queryString += "OR ";
				}
			}
			if (searchCompany.getCompanyPostalCode() != null && !searchCompany.getCompanyPostalCode().equals("")) {
				queryString += "COMPANY_POSTAL_CODE = :COMPANY_POSTAL_CODE OR ";
			}
			if (searchCompany.getCompanyId() != null) {
				if (StringUtils.isBlank(searchCompany.getCompanyPostalCode())) {
					queryString += "OR ";
				}

			}
			Long startDate = searchCompany.getFromDate();
			Long convertTime;
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			convertTime = timestamp.getTime();

			Long endDate = searchCompany.getToDate();
			// Long endDate = convertTime;

			if (startDate != null && endDate != null) {
				/*
				 * queryString +=
				 * "to_date (job_posted_date, 'DD/MM/YYYY') >= to_date (:fromDate, 'DD/MM/YYYY') AND "
				 * +
				 * "to_date (job_posted_date, 'DD/MM/YYYY')<= to_date (:toDate, 'DD/MM/YYYY') "
				 * ;
				 */
				queryString += "CREATE_TS BETWEEN :fromDate AND :toDate )";
			}
			Date d1 = null;
			Date d2 = null;
			Query<CompanyInfo> query = session.createSQLQuery(queryString).addEntity(CompanyInfo.class);
			if (searchCompany.getCompanyId() != null) {
				query.setParameter("companyId", searchCompany.getCompanyId());
			}
			if (searchCompany.getCompanyPostalCode() != null && !searchCompany.getCompanyPostalCode().equals("")) {
				query.setParameter("COMPANY_POSTAL_CODE", searchCompany.getCompanyPostalCode());
			}
			if (startDate != null && endDate != null) {
				query.setParameter("fromDate", startDate);
				query.setParameter("toDate", endDate);
			}
			companyList = query.getResultList();
			session.close();
		} else {
			String queryString = "select * from company_info where delete_status = true and ( ";
			if (searchCompany.getCompanyId() != null) {
				queryString += "COMPANY_ID= :companyId ";
			}
			if (searchCompany.getCompanyId() != null) {
				if (searchCompany.getCompanyPostalCode() != null && !searchCompany.getCompanyPostalCode().equals("")) {
					queryString += "OR ";
				}
			}
			if (searchCompany.getCompanyPostalCode() != null && !searchCompany.getCompanyPostalCode().equals("")) {
				queryString += "COMPANY_POSTAL_CODE= :COMPANY_POSTAL_CODE ";
			}

			queryString += ")";

			Query q = session.createSQLQuery(queryString).addEntity(CompanyInfo.class);
			if (searchCompany.getCompanyId() != null) {
				q.setParameter("companyId", searchCompany.getCompanyId());
				if (searchCompany.getCompanyId() != null && (searchCompany.getCompanyPostalCode() != null
						&& !searchCompany.getCompanyPostalCode().equals(""))) {
					q.setParameter("companyId", searchCompany.getCompanyId());
					q.setParameter("COMPANY_POSTAL_CODE", searchCompany.getCompanyPostalCode());
				}

			} else {
				if (searchCompany.getCompanyPostalCode() != null && !searchCompany.getCompanyPostalCode().equals("")) {
					q.setParameter("COMPANY_POSTAL_CODE", searchCompany.getCompanyPostalCode());
				}
			}
			companyList = q.getResultList();
			session.close();
		}

		return companyList;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public CompanyInfo editCompanyInfoById(Integer id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		CompanyInfo companyInfo = session.get(CompanyInfo.class, id);
		transaction.commit();
		session.close();
		return companyInfo;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<CompanyInfo> pdfForCompanyProfileDetail(Integer companyId) {
		Session session = factory.openSession();
		String queryString = "select * from Company_Info where delete_status = true and company_id=?1";
		Query query = session.createSQLQuery(queryString).addEntity(CompanyInfo.class);
		query.setParameter(1, companyId);
		List<CompanyInfo> companyInfo = query.getResultList();
		session.close();
		return companyInfo;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<CompanyInfo> sendMailCompanyProfilePdf(Integer companyId) {
		Session session = factory.openSession();
		String queryString = "select * from Company_Info where delete_status = true and company_id=?1";
		Query query = session.createSQLQuery(queryString).addEntity(CompanyInfo.class);
		query.setParameter(1, companyId);
		List<CompanyInfo> companyInfo = query.getResultList();
		session.close();
		return companyInfo;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<CompanyInfo> getCompanyProfileById(Integer companyId) {
		Session session = factory.openSession();
		String queryString = "select * from Company_Info where delete_status = true and company_id=?1";
		Query query = session.createSQLQuery(queryString).addEntity(CompanyInfo.class);
		query.setParameter(1, companyId);
		List<CompanyInfo> companyInfo = query.getResultList();
		session.close();
		return companyInfo;
	}

}
