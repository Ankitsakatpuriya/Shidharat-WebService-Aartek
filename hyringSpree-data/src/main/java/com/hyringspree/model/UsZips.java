package com.hyringspree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uszips")
public class UsZips implements Serializable{
	
	@Id
	@Column(name = "zip")
	private String zip;

    @Column(name = "lat")
	private String aLat; 
	
    @Column(name = "lng")
	private String bLng; 

	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String dState; 
	
	@Column(name = "zcta")
	private String eZcta; 
	
	@Column(name = "parent_zcta")
	private String fParentZcta; 
	
	@Column(name = "pop")
	private String gPop; 

	@Column(name = "county_fips")
	private String hCountyFips; 
	
	@Column(name = "county_name")
	private String iCountyName; 
	
	@Column(name = "county_weight")
	private String jCountyWeight; 
	
	@Column(name = "all_county_weight")
	private String kAllCountyWeight; 

	@Column(name = "imprecise")
	private String lImprecise; 
	
	@Column(name = "military")
	private String mMilitary;
	
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the aLat
	 */
	public String getaLat() {
		return aLat;
	}

	/**
	 * @param aLat the aLat to set
	 */
	public void setaLat(String aLat) {
		this.aLat = aLat;
	}

	/**
	 * @return the bLng
	 */
	public String getbLng() {
		return bLng;
	}

	/**
	 * @param bLng the bLng to set
	 */
	public void setbLng(String bLng) {
		this.bLng = bLng;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the dState
	 */
	public String getdState() {
		return dState;
	}

	/**
	 * @param dState the dState to set
	 */
	public void setdState(String dState) {
		this.dState = dState;
	}

	/**
	 * @return the eZcta
	 */
	public String geteZcta() {
		return eZcta;
	}

	/**
	 * @param eZcta the eZcta to set
	 */
	public void seteZcta(String eZcta) {
		this.eZcta = eZcta;
	}

	/**
	 * @return the fParentZcta
	 */
	public String getfParentZcta() {
		return fParentZcta;
	}

	/**
	 * @param fParentZcta the fParentZcta to set
	 */
	public void setfParentZcta(String fParentZcta) {
		this.fParentZcta = fParentZcta;
	}

	/**
	 * @return the gPop
	 */
	public String getgPop() {
		return gPop;
	}

	/**
	 * @param gPop the gPop to set
	 */
	public void setgPop(String gPop) {
		this.gPop = gPop;
	}

	/**
	 * @return the hCountyFips
	 */
	public String gethCountyFips() {
		return hCountyFips;
	}

	/**
	 * @param hCountyFips the hCountyFips to set
	 */
	public void sethCountyFips(String hCountyFips) {
		this.hCountyFips = hCountyFips;
	}

	/**
	 * @return the iCountyName
	 */
	public String getiCountyName() {
		return iCountyName;
	}

	/**
	 * @param iCountyName the iCountyName to set
	 */
	public void setiCountyName(String iCountyName) {
		this.iCountyName = iCountyName;
	}

	/**
	 * @return the jCountyWeight
	 */
	public String getjCountyWeight() {
		return jCountyWeight;
	}

	/**
	 * @param jCountyWeight the jCountyWeight to set
	 */
	public void setjCountyWeight(String jCountyWeight) {
		this.jCountyWeight = jCountyWeight;
	}

	/**
	 * @return the kAllCountyWeight
	 */
	public String getkAllCountyWeight() {
		return kAllCountyWeight;
	}

	/**
	 * @param kAllCountyWeight the kAllCountyWeight to set
	 */
	public void setkAllCountyWeight(String kAllCountyWeight) {
		this.kAllCountyWeight = kAllCountyWeight;
	}

	/**
	 * @return the lImprecise
	 */
	public String getlImprecise() {
		return lImprecise;
	}

	/**
	 * @param lImprecise the lImprecise to set
	 */
	public void setlImprecise(String lImprecise) {
		this.lImprecise = lImprecise;
	}

	/**
	 * @return the mMilitary
	 */
	public String getmMilitary() {
		return mMilitary;
	}

	/**
	 * @param mMilitary the mMilitary to set
	 */
	public void setmMilitary(String mMilitary) {
		this.mMilitary = mMilitary;
	}

}
