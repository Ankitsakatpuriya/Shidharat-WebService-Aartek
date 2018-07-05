package com.hyringspree.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyringspree.model.Membership;
import com.hyringspree.repository.MembershipRepository;
import com.hyringspree.service.MembershipService;

@Service
public class MembershipServiceImpl implements MembershipService {

	@Autowired
	private MembershipRepository membershipRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteMembership(Integer membershipId) {
		return  membershipRepository.deleteMembership(membershipId);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Membership editMembership(Integer membershipId) {
		return membershipRepository.editMembership(membershipId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveMembershipInfo(Membership membershipInfo) {
		return membershipRepository.saveJobMembershipDetails(membershipInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Membership> getMembershipByProfileId(Integer profileId) {
		return membershipRepository.getMembershipByProfileId(profileId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateMembership(Membership updateMembership) {
		return membershipRepository.updateMembership(updateMembership);
	}

}
