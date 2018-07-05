package com.hyringspree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hyringspree.model.Membership;
import com.hyringspree.service.MembershipService;
import com.hyringspree.util.IConstant;

@CrossOrigin
@RestController
public class MembershipController {

	@Autowired
	MembershipService membershipService;

	@DeleteMapping(path = IConstant.DELETE_MEMBERSHIP_MEMBERSHIPID)
	public String deleteMembership(@PathVariable("membershipId") Integer membershipId) {
		boolean status = membershipService.deleteMembership(membershipId);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}

	}

	@GetMapping(path = IConstant.EDIT_MEMBERSHIP_MEMBERSHIPID)
	public Membership editMembership(@PathVariable Integer membershipId) {

		return membershipService.editMembership(membershipId);

	}

	/**
	 * Save jobSeekerMemberShip
	 *
	 * @param String
	 *            publicationInfo
	 */
	@PostMapping(path = IConstant.SAVEJOBSEEKER_MEMBERSHIP)
	public String saveMembership(@RequestBody String memberInfo) {

		Gson gson = new Gson();
		Membership publicationInfoDetails = gson.fromJson(memberInfo, Membership.class);
		boolean status = membershipService.saveMembershipInfo(publicationInfoDetails);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

	@GetMapping(path = IConstant.GET_MEMBERSHIP_BY_PROFILEID_PROFILEID)
	public List<Membership> getMembershipByProfileId(@PathVariable Integer profileId) {

		return membershipService.getMembershipByProfileId(profileId);

	}

	@PostMapping(path = IConstant.UPDATE_MEMBERSHIP)
	public String updateMembership(@RequestBody String membership) {
		Gson gson = new Gson();
		Membership updateMembership = gson.fromJson(membership, Membership.class);
		boolean status = membershipService.updateMembership(updateMembership);
		if (status) {
			return IConstant.SUCCESS;
		} else {
			return IConstant.ERROR;
		}
	}

}
