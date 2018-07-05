package com.hyringspree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "jobdetails")
public class Job implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOB_ID")
	private Integer jobId;  

	@Column(name = "JOB_TITLE")
	private String jobTitle;

	@Column(name = "JOB_TYPE")
	private String jobType;

	@Column(name = "JOB_DESCRIPTION")
	private String jobDescription;

	@Column(name = "IMMIGRATION")
	private String immigration;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "ZIP")
	private String zip;

	@Column(name = "TEX_TERM")
	private String texTerm;

	@Column(name = "COMPENSATION")    
	private String compensation;

	@Column(name = "COMPENSATION_TYPE")
	private String compensationType;    

	@Column(name = "JOB_REQUIRMENT")
	private String jobRequirment;

	@Column(name = "JOB_POSTED_DATE")
	private String jobPostedDate;

	@Column(name = "JOB_LAST_DATE")
	private String jobLastDate;

	@Column(name = "ADDITIONAL_DETAIL")
	private String additionalDetail;

	private String sampleCSVFileName;

	public String getSampleCSVFileName() {
		return sampleCSVFileName;
	}
	
	@Transient
	private String fromDate;
	
	@Transient
	private String toDate;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public void setSampleCSVFileName(String sampleCSVFileName) {
		this.sampleCSVFileName = sampleCSVFileName;
	}

	public String getImmigration() {
		return immigration;
	}

	public void setImmigration(String immigration) {
		this.immigration = immigration;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTexTerm() {
		return texTerm;
	}

	public void setTexTerm(String texTerm) {
		this.texTerm = texTerm;
	}

	public String getCompensation() {
		return compensation;
	}

	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobRequirment() {
		return jobRequirment;
	}

	public void setJobRequirment(String jobRequirment) {
		this.jobRequirment = jobRequirment;
	}

	public String getAdditionalDetail() {
		return additionalDetail;
	}

	public void setAdditionalDetail(String additionalDetail) {
		this.additionalDetail = additionalDetail;
	}

	

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobPostedDate() {
		return jobPostedDate;
	}

	public void setJobPostedDate(String jobPostedDate) {
		this.jobPostedDate = jobPostedDate;
	}

	public String getJobLastDate() {
		return jobLastDate;
	}

	public void setJobLastDate(String jobLastDate) {
		this.jobLastDate = jobLastDate;
	}

	public String getCompensationType() {
		return compensationType;
	}

	public void setCompensationType(String compensationType) {
		this.compensationType = compensationType;
	}

}