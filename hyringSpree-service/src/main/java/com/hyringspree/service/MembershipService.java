package com.hyringspree.service;

import java.util.List;

import com.hyringspree.model.Membership;

public interface MembershipService {

	public boolean deleteMembership(Integer membershipId);

	public boolean saveMembershipInfo(Membership memberInfo);

	public Membership editMembership(Integer membershipId);

	public List<Membership> getMembershipByProfileId(Integer profileId);

	public boolean updateMembership(Membership updateMembership);

}
