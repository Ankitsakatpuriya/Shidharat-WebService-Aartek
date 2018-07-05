package com.hyringspree.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.PublicationInfo;
import com.hyringspree.repository.PublicationRepository;
import com.hyringspree.service.PublicationService;

@Service
public class PublicationServiceImpl implements PublicationService {
	@Autowired
	private PublicationRepository publicationRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public PublicationInfo editPublicationInfo(Integer publicationId) {
		return publicationRepository.editPublicationInfo(publicationId);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deletePublicationInfo(Integer publicationId) {
		return publicationRepository.deletePublicationInfo(publicationId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updatePublicationInfo(PublicationInfo updatePublicationInfo) {

		return publicationRepository.updatePublicationInfo(updatePublicationInfo);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean savePublicationInfo(PublicationInfo publicationInfo) {
		return publicationRepository.saveJobPublicationDetails(publicationInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<PublicationInfo> getPublication(Integer profileId) {
		return publicationRepository.getPublication(profileId);
	}
}
