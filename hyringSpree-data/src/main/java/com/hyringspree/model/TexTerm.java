package com.hyringspree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tex_term")
public class TexTerm implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEXT_TERM_ID")
	private Integer TexTermId;

	@Column(name = "TEX_TERM_DATA")
	private String texTerm;

	public Integer getTexTermId() {
		return TexTermId;
	}

	public void setTexTermId(Integer texTermId) {
		TexTermId = texTermId;
	}

	public String getTexTerm() {
		return texTerm;
	}

	public void setTexTerm(String texTerm) {
		this.texTerm = texTerm;
	}

}
