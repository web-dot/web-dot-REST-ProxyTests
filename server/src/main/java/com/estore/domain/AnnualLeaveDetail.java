package com.estore.domain;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class AnnualLeaveDetail {
	
	@Id
	private String id;
	private String userType;
	private EmploymentType employmentType;
	private boolean changeEmploymentTypeToPermanent;
	private int probationDuration;
	private List<LeaveCategoryDetail> leaveCategoryDetails= new ArrayList<>();
	private List<LeaveApprover> leaveApprovers = new ArrayList<>();
	
	public AnnualLeaveDetail() {
		super();
		this.id = ObjectId.get().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	public boolean isChangeEmploymentTypeToPermanent() {
		return changeEmploymentTypeToPermanent;
	}

	public void setChangeEmploymentTypeToPermanent(boolean changeEmploymentTypeToPermanent) {
		this.changeEmploymentTypeToPermanent = changeEmploymentTypeToPermanent;
	}

	public int getProbationDuration() {
		return probationDuration;
	}

	public void setProbationDuration(int probationDuration) {
		this.probationDuration = probationDuration;
	}

	public List<LeaveCategoryDetail> getLeaveCategoryDetails() {
		return leaveCategoryDetails;
	}

	public void setLeaveCategoryDetails(List<LeaveCategoryDetail> leaveCategoryDetails) {
		this.leaveCategoryDetails = leaveCategoryDetails;
	}

	public List<LeaveApprover> getLeaveApprovers() {
		return leaveApprovers;
	}

	public void setLeaveApprovers(List<LeaveApprover> leaveApprovers) {
		this.leaveApprovers = leaveApprovers;
	}
	
}
