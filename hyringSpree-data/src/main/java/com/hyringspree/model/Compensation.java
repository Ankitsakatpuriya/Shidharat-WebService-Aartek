package com.hyringspree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compensation_type")
public class Compensation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPENSATION_ID")
	private Integer compensationId;

	@Column(name = "COMPENSATION_TYPE")
	private String compensationType;

	public Integer getCompensationId() {
		return compensationId;
	}

	public void setCompensationId(Integer compensationId) {
		this.compensationId = compensationId;
	}

	public String getCompensationType() {
		return compensationType;
	}

	public void setCompensationType(String compensationType) {
		this.compensationType = compensationType;
	}

}
