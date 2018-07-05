package com.hyringspree.service;

import java.util.List;

import com.hyringspree.model.PublicationInfo;

public interface PublicationService {
	
	public boolean deletePublicationInfo(Integer publicationId);

	public boolean updatePublicationInfo(PublicationInfo updatePublicationInfo);

	public boolean savePublicationInfo(PublicationInfo publicationInfo);

	public PublicationInfo editPublicationInfo(Integer publicationId);
	
	public List<PublicationInfo> getPublication(Integer profileId);
	
}
