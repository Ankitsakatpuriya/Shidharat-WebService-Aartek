package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.PublicationInfo;

public interface PublicationRepository {
	
	public PublicationInfo editPublicationInfo(Integer publicationId);
	
	public boolean deletePublicationInfo(Integer publicationId);
	
	public boolean updatePublicationInfo(PublicationInfo updatePublicationInfo);
	
	public boolean saveJobPublicationDetails(PublicationInfo publicationInfo);
	
	public List<PublicationInfo> getPublication(Integer profileId);

}
