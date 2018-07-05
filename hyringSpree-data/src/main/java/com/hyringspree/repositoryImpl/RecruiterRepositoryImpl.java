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

import com.google.gson.JsonObject;
import com.hyringspree.model.JobInfo;
import com.hyringspree.model.ProfileInfo;
import com.hyringspree.model.Recruiter;
import com.hyringspree.model.RecruiterInfo;
import com.hyringspree.model.RecruiterInfoDto;
import com.hyringspree.repository.RecruiterRepository;

@Repository
public class RecruiterRepositoryImpl implements RecruiterRepository {
	@Autowired
	private SessionFactory factory;

	/*
	 * get search Recruiter
	 * 
	 * return list
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<RecruiterInfo> searchRecruiterByselection(RecruiterInfo recruiterdetail) {
		Session session = factory.openSession();
		
		List<RecruiterInfo> recruiterList = null;

		if (recruiterdetail.getFromDate() != null && recruiterdetail.getToDate() != null) {
			String queryString = "select * from recruiter_info where delete_status = true and (";

			if (recruiterdetail.getRecruiterId() != null) {
				queryString += "recruiter_id= :recruiterId ";
			}
			if (recruiterdetail.getRecruiterId() != null) {
				if (recruiterdetail.getRecruiterPostalCode() != null && !recruiterdetail.getRecruiterPostalCode().equals("")) {
					queryString += "OR ";
				}
			}
			if (recruiterdetail.getRecruiterPostalCode()!= null && !recruiterdetail.getRecruiterPostalCode().equals("")) {
				queryString += "RECRUITER_POSTAL_CODE= :RECRUITER_POSTAL_CODE OR ";
			}
			if (recruiterdetail.getRecruiterId() != null) {
				if (StringUtils.isBlank(recruiterdetail.getRecruiterPostalCode())) {
					queryString += "OR ";
				}

			}
			
			Long startDate = recruiterdetail.getFromDate();
			Long convertTime;
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			convertTime = timestamp.getTime();
			
			Long endDate = recruiterdetail.getToDate();

			if (startDate != null && endDate != null) {
				/*queryString += "to_date (recruiter_created_date, 'DD/MM/YYYY') >= to_date (:fromDate, 'DD/MM/YYYY') AND "
						+ "to_date (recruiter_created_date, 'DD/MM/YYYY')<= to_date (:toDate, 'DD/MM/YYYY') )";*/
				
				queryString += "CREATE_TS BETWEEN :fromDate AND :toDate )";

			}

			Query<RecruiterInfo> query = session.createSQLQuery(queryString).addEntity(RecruiterInfo.class);

			if (recruiterdetail.getRecruiterId() != null) {
				query.setParameter("recruiterId", recruiterdetail.getRecruiterId());
			}
			if (recruiterdetail.getRecruiterPostalCode() != null && !recruiterdetail.getRecruiterPostalCode().equals("")) {
				query.setParameter("RECRUITER_POSTAL_CODE", recruiterdetail.getRecruiterPostalCode());
			}

			query.setParameter("fromDate", startDate);
			query.setParameter("toDate", endDate);

			recruiterList = query.getResultList();
			session.close();
		} else {
			String queryString = "select * from recruiter_info where delete_status = true and (";
			if (recruiterdetail.getRecruiterId() != null) {
				queryString += "recruiter_id= :recruiterId ";
			}
			if (recruiterdetail.getRecruiterId() != null) {
				if (recruiterdetail.getRecruiterPostalCode() != null && !recruiterdetail.getRecruiterPostalCode().equals("")) {
					queryString += "OR ";
				}
			}
			if (recruiterdetail.getRecruiterPostalCode() != null && !recruiterdetail.getRecruiterPostalCode().equals("")) {
				queryString += "RECRUITER_POSTAL_CODE= :RECRUITER_POSTAL_CODE ";
			}
			queryString += ")";
			Query q = session.createSQLQuery(queryString).addEntity(RecruiterInfo.class);

			if (recruiterdetail.getRecruiterId() != null) {
				q.setParameter("recruiterId", recruiterdetail.getRecruiterId());
				if (recruiterdetail.getRecruiterId() != null
						&& (recruiterdetail.getRecruiterPostalCode() != null && !recruiterdetail.getRecruiterPostalCode().equals(""))) {
					q.setParameter("recruiterId", recruiterdetail.getRecruiterId());
					q.setParameter("RECRUITER_POSTAL_CODE", recruiterdetail.getRecruiterPostalCode());
				}

			} else {
				if (!recruiterdetail.getRecruiterPostalCode().equals("")) {
					q.setParameter("RECRUITER_POSTAL_CODE", recruiterdetail.getRecruiterPostalCode());
				}
			}
			recruiterList = q.getResultList();
			session.close();
		}
		return recruiterList;
	}
	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<RecruiterInfo> searchByRecruiterFilter(RecruiterInfoDto recruiterfilter) {
		
		Session session = factory.openSession();
		List<RecruiterInfo> recruiterList = null;
		
		
		
		
		String sqlQuery = "select company_info.company_name,recruiter_info.* from recruiter_info, company_info"
				+ " where recruiter_info.company_id = company_info.company_id AND recruiter_info.delete_status = true " ;
		
		    if(recruiterfilter.getTexas()!=null &&  recruiterfilter.getTexas()!= "" ){
	    	      if(recruiterfilter.getTexas().equals("Holtsville")){
		              sqlQuery += " AND recruiter_info.RECRUITER_CITY = 'Holtsville' ";
	    	       }
	           }
		       
		         if(recruiterfilter.getNew_Jersey()!=null && recruiterfilter.getNew_Jersey()!=""){
		        	 if(recruiterfilter.getNew_Jersey().equals("Holtsville")){
		        		 sqlQuery += " AND recruiter_info.RECRUITER_CITY = 'Holtsville' ";
		                }
		         }
		       
				
				if(recruiterfilter.getNew_York()!=null && recruiterfilter.getNew_York()!=""){
					if(recruiterfilter.getNew_York().equals("Holtsville")){
						sqlQuery += "AND recruiter_info.RECRUITER_CITY = 'Holtsville' ";
				      }
					
				}
				
				/*if(recruiterfilter.getComputer_IT_Service()!=null && recruiterfilter.getComputer_IT_Service()!=""){
					if(recruiterfilter.getComputer_IT_Service().equals("shweta")){
						sqlQuery += "AND RECRUITER_FNAME = :Computer_IT_Service ";
				      }
					
				}
				
				
				if(recruiterfilter.getHealthcare_Service()!=null && recruiterfilter.getHealthcare_Service()!=""){
					if(recruiterfilter.getHealthcare_Service().equals("shweta")){
						sqlQuery += "AND RECRUITER_FNAME = :Healthcare_Service ";
				    }
					
				}
				
				
				if(recruiterfilter.getRestaurant_Food()!=null && recruiterfilter.getRestaurant_Food()!=""){
					if(recruiterfilter.getRestaurant_Food().equals("shweta")){
						sqlQuery += "AND RECRUITER_FNAME = :Restaurant_Food ";
				}
					
				}
				*/
				
				if(recruiterfilter.getBing()!=null && recruiterfilter.getBing()!=""){
					if(recruiterfilter.getBing().equals("dxc")){
						sqlQuery += "AND company_info.COMPANY_NAME = 'dxc' ";
				}
					
				}
				
				
				if(recruiterfilter.getGoogle()!=null && recruiterfilter.getGoogle()!=""){
					if(recruiterfilter.getGoogle().equals("dxc")){
						sqlQuery += "AND company_info.COMPANY_NAME = 'dxc' ";
				}
					
				}
				
				
				if(recruiterfilter.getYahoo()!=null && recruiterfilter.getYahoo()!=""){
					if(recruiterfilter.getYahoo().equals("dxc")){
						sqlQuery += "AND company_info.COMPANY_NAME = 'dxc' ";
				}
					
				}
		       
		     
			    Query<RecruiterInfo> query = session.createSQLQuery(sqlQuery).addEntity(RecruiterInfo.class);
			    
			  /*  if(recruiterfilter.getTexas()!=null &&  recruiterfilter.getTexas()!= "" ){
		    		   query.setParameter(1,recruiterfilter.getTexas());
		    		   
		    	
		        }
			   */
			    
			    /*if(recruiterfilter.getNew_Jersey()!=null && recruiterfilter.getNew_Jersey()!=""){
			    	query.setParameter("Holtsville", recruiterfilter.getNew_Jersey());
			    }
			    
			    if(recruiterfilter.getNew_York()!=null && recruiterfilter.getNew_York()!=""){
			    	query.setParameter("Holtsville", recruiterfilter.getNew_York());
			    }*/
			    
			   /* if(recruiterfilter.getComputer_IT_Service()!=null && recruiterfilter.getComputer_IT_Service()!="" ){
			    	query.setParameter("Computer_IT_Service", recruiterfilter.getComputer_IT_Service());
			    }
			    
			    if(recruiterfilter.getHealthcare_Service()!=null && recruiterfilter.getHealthcare_Service()!=""){
			    	query.setParameter("Healthcare_Service", recruiterfilter.getHealthcare_Service());
			    }
			    
			    if(recruiterfilter.getRestaurant_Food()!=null && recruiterfilter.getRestaurant_Food()!=""){
			    	query.setParameter("Restaurant_Food", recruiterfilter.getRestaurant_Food());
			    }
			    */
			    
			    /*if(recruiterfilter.getBing()!=null && recruiterfilter.getBing()!=""){
			    	query.setParameter(2, recruiterfilter.getBing());
			    }*/
			  /*  
			    if(recruiterfilter.getGoogle()!=null && recruiterfilter.getGoogle()!=""){
			    	query.setParameter(2, recruiterfilter.getGoogle());
			    }
			    
			    if(recruiterfilter.getYahoo()!=null && recruiterfilter.getYahoo()!=""){
			    	query.setParameter(2, recruiterfilter.getYahoo());
			    }
			    */
			    
				recruiterList = query.getResultList();
				session.close();
		
		       	return recruiterList;
}

	   
	
	
	
		
	




	/**
	 * Save Recruiter
	 * 
	 * @param String
	 *            recruiter
	 * @return boolean
	 */


	@Transactional(isolation = Isolation.READ_COMMITTED)
	public String saveRecruiter(RecruiterInfo recruiterDetails) {
		String emailId = null;
		Integer incrementiId = 0;
		Integer maxResult = getRecruiterMaxId();
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}

		String formatedProfileId = idFormat + incrementiId;
		System.out.println(formatedProfileId);
		recruiterDetails.setRecruiterId(Integer.parseInt(formatedProfileId));
		recruiterDetails.setDeleteStatus(true);

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Long convertTime;
		convertTime = timestamp.getTime();
		System.out.println(convertTime);

		recruiterDetails.setCreateTs(convertTime);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(recruiterDetails);
		transaction.commit();
		session.close();
		emailId = recruiterDetails.getRecruiterEmail();
		return emailId;

		// Company company = null;
		// String emailId = null;
		// List list = session.createQuery("select c from Company c where
		// c.companyName = :name")
		// .setParameter("name",
		// recruiterDetails.getCompanyName()).getResultList();
		//
		// Iterator<Company> iterator = list.iterator();
		// while (iterator.hasNext()) {
		// company = iterator.next();
		// }
		// recruiterDetails.setParent(company);

		// session.saveOrUpdate(recruiterDetails);
		// transaction.commit();
		// return recruiterId;

		// emailId = recruiterDetails.getEmail();
		// System.out.println(emailId);
		// return emailId;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getRecruiterMaxId() {

		String sqlQuery = "select max(recruiterId) from RecruiterInfo";
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(sqlQuery);
		System.out.println("query ... " + query.getResultList().get(0));
		Integer maxRecruiterId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;

		transaction.commit();
		session.close();

		return maxRecruiterId;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public static boolean checkRecruiterId(String recruiterId, Session session) {
		List<RecruiterInfo> recruiterlist = session
				.createQuery("select r from Recruiter r where r.recruiterId='" + recruiterId + "'").list();
		if (recruiterlist.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Edit Recruiter
	 * 
	 * @param Integer
	 *            id
	 * @return
	 * @return Recruiter
	 * 
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public RecruiterInfo edieditRecruitert(Integer id) {
		Session session = factory.openSession();
		RecruiterInfo recruiterDetails = session.get(RecruiterInfo.class, id);
		session.close();
		return recruiterDetails;

	}

	/**
	 * Delete Recruiter
	 * 
	 * @param Integer
	 *            id
	 * @return void
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deleteById(Integer recruiterId) {
		if (recruiterId != null) {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			RecruiterInfo recruiterDetails = session.get(RecruiterInfo.class, recruiterId);
			Boolean status = recruiterDetails.getDeleteStatus();
			if (status) {
				recruiterDetails.setDeleteStatus(false);
			}
			session.saveOrUpdate(recruiterDetails);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List getAllDetails() {
		Session session = factory.openSession();
		// Query query = session.createQuery("from RecruiterInfo");
		List<Recruiter> recruiterList = session.createQuery("from RecruiterInfo where delete_status = true").list();
		// List<Recruiter> recruiterList = query.list();
		session.close();
		return recruiterList;

	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updateRecruiterInfo(RecruiterInfo updateRecruiterInfo) {
		if (updateRecruiterInfo.getRecruiterId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(updateRecruiterInfo);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	public String checkEmployerEmailId(String emailId) {
		System.out.println("method email .. "+emailId);
		JsonObject obj = new JsonObject();
		Session session = factory.openSession();
		String sqlQuery = "select * from recruiter_info where recruiter_email like ?1 ";
		Query query = session.createSQLQuery(sqlQuery).addEntity(RecruiterInfo.class);
		query.setParameter(1,  emailId+'%' );
		
		List<RecruiterInfo> recruiterList = query.getResultList();
		System.out.println(recruiterList.size());
		if (recruiterList.size() > 0){
		session.close();
		return "200";
		} 	 
		session.close();
		return "400";
	
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Long countOfAllRecruiter() {
		
		Session session = factory.openSession();
		Long count =  (Long) session.createQuery("select count(*) from RecruiterInfo where delete_status = true").getSingleResult();
		session.close();
		return count;
	}
	

}
