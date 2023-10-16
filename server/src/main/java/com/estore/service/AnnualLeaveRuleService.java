package com.estore.service;

import java.util.List;

import com.estore.domain.LeaveApprover;
import com.estore.domain.LeaveCategoryDetail;

public interface AnnualLeaveRuleService {
	
	public List<LeaveCategoryDetail> fetchAllLeaveCategoryDetails(String userType, String employmentType);
	public List<LeaveApprover> saveLeaveApprovers(String userType, String employmentType, List<LeaveApprover> leaveApprovers);
}
