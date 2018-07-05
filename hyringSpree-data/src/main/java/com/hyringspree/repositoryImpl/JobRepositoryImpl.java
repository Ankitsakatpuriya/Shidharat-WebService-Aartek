package com.hyringspree.repositoryImpl;

import static com.hyringspree.util.Dateutills.generateIdFormat;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.hyringspree.model.Job;
import com.hyringspree.model.JobFilterDTO;
import com.hyringspree.model.JobHavingError;
import com.hyringspree.model.JobInfo;
import com.hyringspree.repository.JobRepository;

@Repository
public class JobRepositoryImpl implements JobRepository {

	@Autowired
	private SessionFactory factory;

	/**
	 * Save Job
	 * 
	 * @param Job
	 *            jobDetails
	 * 
	 * @return Integer serilizeId
	 */

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public String saveMultipleJobs(JobInfo jobDetails, String recruiterId, String companyId) {

		Integer incrementiId = 0;
		String errorCheck = "saveWithoutError";
		Integer maxResult = getJobMaxId(errorCheck);
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}

		String formatedProfileId = idFormat + incrementiId;
		jobDetails.setJobId(Integer.parseInt(formatedProfileId));
		jobDetails.setDeleteStatus(true);
		jobDetails.setRecruiterId(Integer.parseInt(recruiterId));
		jobDetails.setCompanyId(Integer.parseInt(companyId));

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Long convertTime;
		convertTime = timestamp.getTime();
		jobDetails.setJobPostedDt(convertTime);

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String today = formatter.format(new Date());

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(today);
			jobDetails.setCreateTs(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(jobDetails);
		transaction.commit();
		session.close();
		return "200";

	}

	/**
	 * Save Job Null Record
	 * 
	 * @param Job
	 * 
	 * 
	 * @return boolean
	 * 
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public String saveNullJob(JobHavingError jobDetails, String recruiterId, String companyId) {
		Integer incrementiId = 0;
		String errorCheck = "saveHavingError";
		Integer maxResult = getJobMaxId(errorCheck);
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}

		String formatedProfileId = idFormat + incrementiId;
		jobDetails.setJobId(Integer.parseInt(formatedProfileId));
		jobDetails.setDeleteStatus(true);
		jobDetails.setRecruiterId(Integer.parseInt(recruiterId));
		jobDetails.setCompanyId(Integer.parseInt(companyId));

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Long convertTime;
		convertTime = timestamp.getTime();
		jobDetails.setJobPostedDt(convertTime);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(jobDetails);
		transaction.commit();
		session.close();
		return "400";
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public String saveSingleJobs(JobInfo jobDetails) {

		Integer incrementiId = 0;
		String errorCheck = "saveWithoutError";
		Integer maxResult = getJobMaxId(errorCheck);
		String idFormat = generateIdFormat();
		if (maxResult != 0) {
			String maxDigit = maxResult.toString().substring(6);
			incrementiId = Integer.parseInt(maxDigit) + 1;
		} else {
			incrementiId = 1;
		}

		String formatedProfileId = idFormat + incrementiId;
		jobDetails.setJobId(Integer.parseInt(formatedProfileId));
		jobDetails.setDeleteStatus(true);

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Long convertTime;
		convertTime = timestamp.getTime();
		jobDetails.setJobPostedDt(convertTime);

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String today = formatter.format(new Date());

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(today);
			jobDetails.setCreateTs(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(jobDetails);
		transaction.commit();
		session.close();
		return "200";

	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Integer getJobMaxId(String errorCheck) {
		String sqlQuery = "";
		if (errorCheck.equals("saveWithoutError")) {
			sqlQuery = "select max(jobId) from JobInfo";
		} else if (errorCheck.equals("saveHavingError")) {
			sqlQuery = "select max(jobId) from JobHavingError";
		}

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(sqlQuery);
		Integer maxProfileId = query.getResultList().get(0) != null ? (Integer) query.getResultList().get(0) : 0;

		transaction.commit();
		session.close();

		return maxProfileId;
	}

	/*
	 * Edit Job
	 * 
	 * @param Integer jobId
	 * 
	 * 
	 * @return JobInfo
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public JobInfo editJobInfo(Integer jobId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		JobInfo jobInfo = session.get(JobInfo.class, jobId);
		transaction.commit();
		session.close();
		return jobInfo;
	}

	/**
	 * Delete Job
	 * 
	 * @param Integer
	 *            id
	 * @return void
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean deleteById(Integer jobId) {
		if (jobId != null) {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			JobInfo jobDetails = session.get(JobInfo.class, jobId);
			Boolean status = jobDetails.getDeleteStatus();
			if (status) {
				jobDetails.setDeleteStatus(false);
			}
			session.saveOrUpdate(jobDetails);
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get Job
	 * 
	 * 
	 * @return List (Job)
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List getAllJobsDetails() {
		Session session = factory.openSession();
		Query<Job> query = session.createQuery("from JobInfo where delete_status = true");
		List list = query.list();
		session.close();
		return list;
	}

	/**
	 * Search Job By Selection
	 * 
	 * 
	 * @return List
	 * 
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<JobInfo> searchJobBySelection(JobInfo searchJob) {
		Session session = factory.openSession();
		List<JobInfo> jobList = null;

		if (searchJob.getFromDate() != null && searchJob.getToDate() != null) {
			String queryString = "select * from job_info where delete_status = true AND ( ";

			if (searchJob.getJobId() != null) {
				queryString += "job_id= :jobId ";
			}
			if (searchJob.getJobId() != null) {
				if (searchJob.getJobPostalCode() != null && !searchJob.getJobPostalCode().equals("")) {
					queryString += "OR ";
				}
			}
			if (searchJob.getJobPostalCode() != null && !searchJob.getJobPostalCode().equals("")) {
				queryString += "JOB_POSTAL_CODE= :JOB_POSTAL_CODE OR ";
			}
			if (searchJob.getJobId() != null) {
				if (StringUtils.isBlank(searchJob.getJobPostalCode())) {
					queryString += "OR ";
				}

			}

			Long convertTime;
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			convertTime = timestamp.getTime();

			Long startDate = searchJob.getFromDate();
			// Long endDate = convertTime;
			Long endDate = searchJob.getToDate();

			if (startDate != null && endDate != null) {
				/*
				 * queryString +=
				 * "to_date (job_posted_date, 'DD/MM/YYYY') >= to_date (:fromDate, 'DD/MM/YYYY') AND "
				 * +
				 * "to_date (job_posted_date, 'DD/MM/YYYY')<= to_date (:toDate, 'DD/MM/YYYY') "
				 * ;
				 */
				queryString += "JOB_POSTED_DT BETWEEN :fromDate AND :toDate ) ";
			}
			Date d1 = null;
			Date d2 = null;
			Query<JobInfo> query = session.createSQLQuery(queryString).addEntity(JobInfo.class);
			if (searchJob.getJobId() != null) {
				query.setParameter("jobId", searchJob.getJobId());
			}
			if (searchJob.getJobPostalCode() != null && !searchJob.getJobPostalCode().equals("")) {
				query.setParameter("JOB_POSTAL_CODE", searchJob.getJobPostalCode());
			}

			query.setParameter("fromDate", startDate);
			query.setParameter("toDate", endDate);

			jobList = query.getResultList();
			session.close();
		} else {
			String queryString = "select * from job_info where delete_status = true and ( ";
			if (searchJob.getJobId() != null) {
				queryString += "job_id= :jobId ";
			}
			if (searchJob.getJobId() != null) {
				if (searchJob.getJobPostalCode() != null && !searchJob.getJobPostalCode().equals("")) {
					queryString += "OR ";
				}
			}
			if (searchJob.getJobPostalCode() != null && !searchJob.getJobPostalCode().equals("")) {
				queryString += "JOB_POSTAL_CODE= :JOB_POSTAL_CODE ";
			}

			queryString += ")";
			Query q = session.createSQLQuery(queryString).addEntity(JobInfo.class);
			if (searchJob.getJobId() != null) {
				q.setParameter("jobId", searchJob.getJobId());
				if (searchJob.getJobId() != null
						&& (searchJob.getJobPostalCode() != null && !searchJob.getJobPostalCode().equals(""))) {
					q.setParameter("jobId", searchJob.getJobId());
					q.setParameter("JOB_POSTAL_CODE", searchJob.getJobPostalCode());
				}

			} else {
				if (searchJob.getJobPostalCode() != null && !searchJob.getJobPostalCode().equals("")) {
					q.setParameter("JOB_POSTAL_CODE", searchJob.getJobPostalCode());
				}
			}
			jobList = q.getResultList();
			session.close();
		}
		return jobList;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<JobInfo> searchJobFilterForHomePage(JobInfo searchJob) {
		Session session = factory.openSession();
		List<JobInfo> jobList = null;

		String queryString = "select * from job_info where delete_status = true AND ";

		if (searchJob.getJobHomeFilterValue() != null) {
			queryString += "(job_postal_code= ?1 OR job_city= ?1 OR job_state= ?1)";
		}

		if (searchJob.getJobHomeFilterValue() != null) {
			if (searchJob.getJobTitle() != null && !searchJob.getJobTitle().equals("")) {
				queryString += "OR ";
			}
		}

		if (searchJob.getJobTitle() != null && !searchJob.getJobTitle().equals("")) {
			queryString += "(job_title= ?2)";
		}
		Query q = session.createSQLQuery(queryString).addEntity(JobInfo.class);

		if (searchJob.getJobHomeFilterValue() != null && !searchJob.getJobHomeFilterValue().equals("")) {
			q.setParameter(1, searchJob.getJobHomeFilterValue());
		}

		if (searchJob.getJobTitle() != null && !searchJob.getJobTitle().equals("")) {
			q.setParameter(2, searchJob.getJobTitle());

		}
		jobList = q.getResultList();
		session.close();
		return jobList;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updateJobInfo(JobInfo updateJobInfo) {
		if (updateJobInfo.getJobId() != null) {
			Session session = factory.openSession();
			session.saveOrUpdate(updateJobInfo);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<JobInfo> getJobsByFilter(JobFilterDTO jobFilter) {
		Session session = factory.openSession();
		List<JobInfo> jobList = null;
		System.out.println("get today ...  " + jobFilter.getToday());
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String today = formatter.format(new Date());

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(today);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String sqlQuery = "";

		if ((jobFilter.getToday() != null && !jobFilter.getToday().equals(""))
				|| (jobFilter.getThisWeek() != null && !jobFilter.getThisWeek().equals(""))
				|| (jobFilter.getThisMonth() != null && !jobFilter.getThisMonth().equals(""))
				|| (jobFilter.getTexas() != null && !jobFilter.getTexas().equals(""))
				|| (jobFilter.getNewYork() != null && !jobFilter.getNewYork().equals(""))
				|| (jobFilter.getNewJersy() != null && !jobFilter.getNewJersy().equals(""))
				|| (jobFilter.getDesigner() != null && !jobFilter.getDesigner().equals(""))
				|| (jobFilter.getDeveloper() != null && !jobFilter.getDeveloper().equals(""))
				|| (jobFilter.getTester() != null && !jobFilter.getTester().equals(""))
				|| (jobFilter.getBing() != null && !jobFilter.getBing().equals(""))
				|| (jobFilter.getGoogle() != null && !jobFilter.getGoogle().equals(""))
				|| (jobFilter.getYahoo() != null && !jobFilter.getYahoo().equals(""))) {
			sqlQuery = "select company_info.company_name, job_info.* from job_info, company_info where "
					+ "company_info.company_id = job_info.company_id AND job_info.delete_status = true  ";

			// For posted date working
			if (jobFilter.getToday() != null && jobFilter.getToday() != "") {
				if (jobFilter.getToday().equals("Today") || jobFilter.getToday().equals("today")) {
					System.out.println("DATE........." + date);
					sqlQuery += " AND job_info.CREATE_TS = ?1 ";
				}
			}

			if (jobFilter.getThisWeek() != null && jobFilter.getThisWeek() != "") {
				if (jobFilter.getThisWeek().equals("This Week") || jobFilter.getThisWeek().equals("this week")) {
					sqlQuery += " AND date_trunc('week', now()) <= job_info.create_ts AND "
							+ "job_info.create_ts < date_trunc('week', now()) + '1 week' ";
				}
			}

			if (jobFilter.getThisMonth() != null && jobFilter.getThisMonth() != "") {
				if (jobFilter.getThisMonth().equals("This Month") || jobFilter.getThisMonth().equals("this month")) {
					sqlQuery += " AND date_trunc('month', job_info.create_ts) = date_trunc('month', current_date) ";
				}
			}

			// For location
			if (jobFilter.getTexas() != null && jobFilter.getTexas() != "") {
				if (jobFilter.getTexas().equals("bhopal") || jobFilter.getTexas().equals("Bhopal")) {
					sqlQuery += " AND lower(job_info.job_city) = lower('bhopal') ";
				}
			}

			if (jobFilter.getNewYork() != null && jobFilter.getNewYork() != "") {
				if (jobFilter.getNewYork().equals("New York") || jobFilter.getNewYork().equals("new york")) {
					sqlQuery += " AND lower(job_info.job_city) = lower('New York') ";
				}
			}

			if (jobFilter.getNewJersy() != null && jobFilter.getNewJersy() != "") {
				if (jobFilter.getNewJersy().equals("New Jersy") || jobFilter.getNewJersy().equals("new jersy")) {
					sqlQuery += " AND lower(job_info.job_city) = lower('New Jersy') ";
				}
			}

			// For Employement type
			if (jobFilter.getDesigner() != null && jobFilter.getDesigner() != "") {
				if (jobFilter.getDesigner().equals("Designer") || jobFilter.getDesigner().equals("designer")) {
					sqlQuery += " AND lower(job_info.job_Type) = ('designer') ";
				}
			}

			if (jobFilter.getDeveloper() != null && jobFilter.getDeveloper() != "") {
				if (jobFilter.getDeveloper().equals("Developer") || jobFilter.getDeveloper().equals("developer")) {
					sqlQuery += " AND lower(job_info.job_Type) = lower('developer') ";
				}
			}

			if (jobFilter.getTester() != null && jobFilter.getTester() != "") {
				if (jobFilter.getTester().equals("Tester") || jobFilter.getTester().equals("tester")) {
					sqlQuery += " AND lower(job_info.job_Type) = lower('Tester') ";
				}
			}

			// For industry working
			if (jobFilter.getBing() != null && jobFilter.getBing() != "") {

				if (jobFilter.getBing().equals("Bing") || jobFilter.getBing().equals("bing")) {
					sqlQuery += " AND lower(company_info.company_name) = lower('Bing') ";
				}
			}

			if (jobFilter.getGoogle() != null && jobFilter.getGoogle() != "") {
				if (jobFilter.getGoogle().equals("Google") || jobFilter.getGoogle().equals("google")) {
					sqlQuery += " AND lower(company_info.company_name) = lower('Google') ";
				}
			}

			if (jobFilter.getYahoo() != null && jobFilter.getYahoo() != "") {
				if (jobFilter.getYahoo().equals("Yahoo") || jobFilter.getYahoo().equals("yahoo")) {
					sqlQuery += " AND lower(company_info.company_name) = lower('Yahoo') ";
				}
			}

			Query<JobInfo> query = session.createSQLQuery(sqlQuery).addEntity(JobInfo.class);

			if (jobFilter.getToday() != null && !jobFilter.getToday().equals("")) {
				query.setParameter(1, date);
			}

			jobList = query.getResultList();
			session.close();

		}
		return jobList;
	}
	
	public Long countOfAllJobs() {
		Session session = factory.openSession();
		Long count = (Long) session
				.createQuery("select count(*) from JobInfo where delete_status = true").getSingleResult();
		session.close();
		return count;
	}
}