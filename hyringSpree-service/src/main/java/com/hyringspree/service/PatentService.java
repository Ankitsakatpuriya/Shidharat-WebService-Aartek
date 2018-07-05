package com.hyringspree.service;

import java.util.List;

import com.hyringspree.model.PatentInfo;

public interface PatentService {

	public PatentInfo editPatentInfo(Integer patentId);

	public boolean deletePatentInfo(Integer patentId);

	public boolean savePatentInfo(PatentInfo patentInfo);

	public boolean updatePatentInfo(PatentInfo updatePatentInfo);

	public List<PatentInfo> getPatentInfo(Integer profileId);

}
