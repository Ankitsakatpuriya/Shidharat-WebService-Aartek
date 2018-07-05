package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.PatentInfo;

public interface PatentRepository {

	public PatentInfo editPatentInfo(Integer patentId);
	
	public boolean deletePatentInfo(Integer patentId);
	
	public boolean saveJobPatentDetails(PatentInfo patentInfo);
	
	public boolean updatePatentInfo(PatentInfo updatePatentInfo);
	
	public List<PatentInfo> getPatentInfo(Integer profileId);
}
