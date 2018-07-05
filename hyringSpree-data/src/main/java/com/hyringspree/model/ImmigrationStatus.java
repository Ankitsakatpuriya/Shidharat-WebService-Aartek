package com.hyringspree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "immigration_status")
public class ImmigrationStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IMMIGRATION_ID")
	private Integer immigrationId;

	@Column(name = "IMMIGRATION_STATUS")
	private String immigration;     
  
	public Integer getImmigrationId() {
		return immigrationId;
	}

	public void setImmigrationId(Integer immigrationId) {
		this.immigrationId = immigrationId;
	}

	public String getImmigration() {
		return immigration;
	}

	public void setImmigration(String immigration) {
		this.immigration = immigration;
	}

	
}
