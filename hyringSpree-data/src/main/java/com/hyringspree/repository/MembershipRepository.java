package com.hyringspree.repository;

import java.util.List;

import com.hyringspree.model.Membership;

public interface MembershipRepository {

	public boolean deleteMembership(Integer membershipId);
	
	public boolean saveJobMembershipDetails(Membership memberInfo);
	
	public List<Membership> getMembershipByProfileId(Integer profileId);
	
	public boolean updateMembership(Membership updateMembership);
	
	public Membership editMembership(Integer memberInfoId);
}
