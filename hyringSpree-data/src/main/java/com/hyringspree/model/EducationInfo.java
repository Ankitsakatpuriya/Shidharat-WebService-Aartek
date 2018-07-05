package com.hyringspree.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "education_info")
public class EducationInfo {

	@Id
	@Column(name = "EDUCATION_ID")
	private Integer educationId;

	@Column(name = "EDUCATION_INFO_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationInfoSeq;

	@Column(name = "SCHOOL_ID")
	private String schoolId;

	@Column(name = "GRADUATION_DT")
	private Date graduationDt;

	@Column(name = "EDU_LEVEL")
	private String eduLevel;

	@Column(name = "CREATE_TS")
	private long createTs;

	@Column(name = "CREATE_BY")
	private String createBy;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

	@Column(name = "DEGREE_AWARDED")
	private String degreeAwarde;

	@Column(name = "SUBJECT_MAJOR")
	private String subjectMajor;

	/* Education */
	@Column(name = "COURSE_NAME")
	private String courseName;

	@Column(name = "INSTITUTION_NAME")
	private String institutionName;

	@Column(name = "COURSE_COMPLETED")
	private String courseCompleted;

	@Column(name = "EDUCATION_LOCATION")
	private String educationLocation;

	@Column(name = "DELETE_STATUS")
	private Boolean deleteStatus;

	@Column(name = "PROFILE_ID", nullable = false)
	private Integer profileId;

	/**
	 * @return the deleteStatus
	 */
	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	/**
	 * @param deleteStatus
	 *            the deleteStatus to set
	 */
	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getCourseCompleted() {
		return courseCompleted;
	}

	public void setCourseCompleted(String courseCompleted) {
		this.courseCompleted = courseCompleted;
	}

	public String getEducationLocation() {
		return educationLocation;
	}

	public void setEducationLocation(String educationLocation) {
		this.educationLocation = educationLocation;
	}

	public Integer getEducationId() {
		return educationId;
	}

	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}

	public Integer getEducationInfoSeq() {
		return educationInfoSeq;
	}

	public void setEducationInfoSeq(Integer educationInfoSeq) {
		this.educationInfoSeq = educationInfoSeq;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public Date getGraduationDt() {
		return graduationDt;
	}

	public void setGraduationDt(Date graduationDt) {
		this.graduationDt = graduationDt;
	}

	public String getEduLevel() {
		return eduLevel;
	}

	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}

	public long getCreateTs() {
		return createTs;
	}

	public void setCreateTs(long createTs) {
		this.createTs = createTs;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getDegreeAwarde() {
		return degreeAwarde;
	}

	public void setDegreeAwarde(String degreeAwarde) {
		this.degreeAwarde = degreeAwarde;
	}

	public String getSubjectMajor() {
		return subjectMajor;
	}

	public void setSubjectMajor(String subjectMajor) {
		this.subjectMajor = subjectMajor;
	}

}
