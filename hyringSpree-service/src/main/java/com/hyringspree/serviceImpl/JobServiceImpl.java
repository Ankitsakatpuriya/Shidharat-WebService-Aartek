package com.hyringspree.serviceImpl;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.hyringspree.model.JobFilterDTO;
import com.hyringspree.model.JobHavingError;
import com.hyringspree.model.JobInfo;
import com.hyringspree.repository.JobRepository;
import com.hyringspree.service.JobService;
import com.hyringspree.util.IConstant;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

/**
 * @author aartek
 *
 */
@Service
public class JobServiceImpl implements JobService {

	private static AtomicInteger jobIdCount = new AtomicInteger(100);

	@Autowired
	private JobRepository jobRepository;

	/**
	 * save Job
	 * 
	 * @param Job
	 *            jobDetails
	 * @return boolean
	 */

	private static final SimpleDateFormat FORMATTER_DD_MM_YY = new SimpleDateFormat("dd/MM/yyyy");

	@Transactional(propagation = Propagation.REQUIRED)
	public String saveMultipleJob(MultipartFile file, String fileType, String recruiterId, String companyId)
			throws IOException, SAXException, ParserConfigurationException {
		String statusOfValue = null;

		String fileName = file.getOriginalFilename();

		if (fileType.contentEquals(IConstant.CSV)) {
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(IConstant.PATH + File.separator + fileName)));
			stream.write(bytes);
			stream.flush();
			stream.close();

			// READ FILE FIRST ROW FOR HEADER
			BufferedReader buffReadFile = new BufferedReader(
					new FileReader(IConstant.PATH + File.separator + fileName));
			String line = buffReadFile.readLine();
			String[] columns = line.split(",");

			// READ CSV FILE & MAP WITH POJO CLASS
			CSVReader csvReader = null;
			csvReader = new CSVReader(new FileReader(IConstant.PATH + File.separator + fileName), ',', '"', 1);

			CSVReader csvReaderError = null;
			csvReaderError = new CSVReader(new FileReader(IConstant.PATH + File.separator + fileName), ',', '"', 1);

			ColumnPositionMappingStrategy mappingStratgy = new ColumnPositionMappingStrategy();
			mappingStratgy.setType(JobInfo.class);
			mappingStratgy.setColumnMapping(columns);
			ColumnPositionMappingStrategy mappingStratgyError = new ColumnPositionMappingStrategy();
			mappingStratgyError.setType(JobHavingError.class);
			mappingStratgyError.setColumnMapping(columns);

			CsvToBean csvToBean = new CsvToBean();
			List<JobInfo> empList = csvToBean.parse(mappingStratgy, csvReader);
			List<JobHavingError> empErrorList = csvToBean.parse(mappingStratgyError, csvReaderError);

			empErrorList.remove(empErrorList.size() - 1);
			int listCount = 0;
			for (JobHavingError jobError : empErrorList) {
				listCount++;
				if (StringUtils.isBlank(jobError.getJobTitle()) || StringUtils.isBlank(jobError.getJobDescription())
						|| StringUtils.isBlank(jobError.getImmigration()) || StringUtils.isBlank(jobError.getJobCity())
						|| StringUtils.isBlank(jobError.getJobState())
						|| StringUtils.isBlank(jobError.getJobPostalCode())
						|| StringUtils.isBlank(jobError.getTexTerm()) || StringUtils.isBlank(jobError.getCompensation())
						|| StringUtils.isBlank(jobError.getCompensationType())
						|| StringUtils.isBlank(jobError.getJobRequirement()) ||
						// StringUtils.isBlank(jobError.getJobExpiryDt())||
						StringUtils.isBlank(jobError.getAdditionalDetail())) {
					listCount++;
					// statusOfNullValue = jobRepository.saveNullJob(jobError,
					// recruiterId, companyId);
					return "400";
				}
			}

			for (JobInfo job : empList) {

				if (!StringUtils.isBlank(job.getJobTitle()) && !StringUtils.isBlank(job.getJobDescription())
						&& !StringUtils.isBlank(job.getImmigration()) && !StringUtils.isBlank(job.getJobCity())
						&& !StringUtils.isBlank(job.getJobState()) && !StringUtils.isBlank(job.getJobPostalCode())
						&& !StringUtils.isBlank(job.getTexTerm()) && !StringUtils.isBlank(job.getCompensation())
						&& !StringUtils.isBlank(job.getCompensationType())
						&& !StringUtils.isBlank(job.getJobRequirement()) &&
						// !StringUtils.isBlank(job.getJobExpiryDt())&&
						!StringUtils.isBlank(job.getAdditionalDetail())) {
					statusOfValue = jobRepository.saveMultipleJobs(job, recruiterId, companyId);

				}
			}

		} else if (fileType.contentEquals(IConstant.XML)) {

			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document doc = builder.parse(IConstant.PATH + File.separator + fileName);
			doc.getDocumentElement().normalize();

			NodeList nodeList = doc.getElementsByTagName(IConstant.TAG);

			List<JobHavingError> jobErrorList = new ArrayList<JobHavingError>();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);
				jobErrorList.add(getJobsError(nodeList.item(i)));
			}

			int listCount = 0;
			for (JobHavingError jobError : jobErrorList) {
				listCount++;
				if (StringUtils.isBlank(jobError.getJobTitle()) || StringUtils.isBlank(jobError.getJobDescription())
						|| StringUtils.isBlank(jobError.getImmigration()) || StringUtils.isBlank(jobError.getJobCity())
						|| StringUtils.isBlank(jobError.getJobState())
						|| StringUtils.isBlank(jobError.getJobPostalCode())
						|| StringUtils.isBlank(jobError.getTexTerm()) || StringUtils.isBlank(jobError.getCompensation())
						|| StringUtils.isBlank(jobError.getCompensationType())
						|| StringUtils.isBlank(jobError.getJobRequirement()) ||
						// StringUtils.isBlank(jobError.getJobExpiryDt())||
						StringUtils.isBlank(jobError.getAdditionalDetail())) {

					// statusOfValue = jobRepository.saveNullJob(jobError,
					// recruiterId, companyId);
					return "400";
				}
			}

			List<JobInfo> jobList = new ArrayList<JobInfo>();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);
				jobList.add(getJobs(nodeList.item(i)));
			}

			for (JobInfo job : jobList) {

				if (!StringUtils.isBlank(job.getJobTitle()) && !StringUtils.isBlank(job.getJobDescription())
						&& !StringUtils.isBlank(job.getImmigration()) && !StringUtils.isBlank(job.getJobCity())
						&& !StringUtils.isBlank(job.getJobState()) && !StringUtils.isBlank(job.getJobPostalCode())
						&& !StringUtils.isBlank(job.getTexTerm()) && !StringUtils.isBlank(job.getCompensation())
						&& !StringUtils.isBlank(job.getCompensationType())
						&& !StringUtils.isBlank(job.getJobRequirement()) &&
						// !StringUtils.isBlank(job.getJobExpiryDt())&&
						!StringUtils.isBlank(job.getAdditionalDetail())) {

					statusOfValue = jobRepository.saveMultipleJobs(job, recruiterId, companyId);
				}
			}
		}
		return statusOfValue;
	}

	private static JobInfo getJobs(Node node) {

		JobInfo job = new JobInfo();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			job.setJobTitle(getTagValue("jobTitle", element));
			job.setAdditionalDetail(getTagValue("additionalDetail", element));
			job.setJobCity(getTagValue("jobCity", element));
			job.setCompensation(getTagValue("compensation", element));
			job.setCompensationType(getTagValue("compensationType", element));
			job.setImmigration(getTagValue("immigration", element));
			job.setJobDescription(getTagValue("jobDescription", element));
			// job.setJobLastDate(getTagValue("jobLastDate", element));
			// job.setJobPostedDate(getTagValue("jobPostedDate", element));
			job.setJobRequirement(getTagValue("jobRequirement", element));
			job.setJobType(getTagValue("jobType", element));
			job.setJobState(getTagValue("jobState", element));
			job.setTexTerm(getTagValue("texTerm", element));
			job.setJobPostalCode(getTagValue("jobPostalCode", element));

		}

		return job;

	}

	private static JobHavingError getJobsError(Node node) {

		JobHavingError job = new JobHavingError();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			job.setJobTitle(getTagValue("jobTitle", element));
			job.setAdditionalDetail(getTagValue("additionalDetail", element));
			job.setJobCity(getTagValue("jobCity", element));
			job.setCompensation(getTagValue("compensation", element));
			job.setCompensationType(getTagValue("compensationType", element));
			job.setImmigration(getTagValue("immigration", element));
			job.setJobDescription(getTagValue("jobDescription", element));
			// job.setJobLastDate(getTagValue("jobLastDate", element));
			// job.setJobPostedDate(getTagValue("jobPostedDate", element));
			job.setJobRequirement(getTagValue("jobRequirement", element));
			job.setJobType(getTagValue("jobType", element));
			job.setJobState(getTagValue("jobState", element));
			job.setTexTerm(getTagValue("texTerm", element));
			job.setJobPostalCode(getTagValue("jobPostalCode", element));

		}

		return job;

	}

	private static String getTagValue(String tag, Element element) {
		String value = element.getElementsByTagName(tag).item(0).getTextContent();
		return value;
	}

	/**
	 * Edit Job Record
	 * 
	 * @param Integer
	 *            jobId
	 * @return boolean
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public JobInfo editJobInfo(Integer jobId) {
		return jobRepository.editJobInfo(jobId);

	}

	/**
	 * Edit Job Record
	 * 
	 * @param Integer
	 *            jobId
	 * @return boolean
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public String saveSingleJob(JobInfo jobId) {
		return jobRepository.saveSingleJobs(jobId);

	}

	/**
	 * Delete Job Record
	 * 
	 * @param Integer
	 *            Id
	 * @return void
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteJob(Integer jobId) {
		return jobRepository.deleteById(jobId);
	}

	/**
	 * Get Job Record
	 * 
	 * 
	 * @return List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List getAllJobsDetails() {
		return jobRepository.getAllJobsDetails();
	}

	/**
	 * Search Job By Selection
	 * 
	 * 
	 * @return List
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<JobInfo> searchJobBySelection(JobInfo searchJob) {

		return jobRepository.searchJobBySelection(searchJob);
	}

	/**
	 * Update Job Record
	 * 
	 * @return boolean
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateJobInfo(JobInfo updateJobInfo) {
		return jobRepository.updateJobInfo(updateJobInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<JobInfo> getJobsByFilter(JobFilterDTO jobFilter) {
		return jobRepository.getJobsByFilter(jobFilter);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<JobInfo> searchJobFilterForHomePage(JobInfo searchJob) {
		return jobRepository.searchJobFilterForHomePage(searchJob);
	}

}
