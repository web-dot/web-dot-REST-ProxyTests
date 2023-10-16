package com.estore.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pms_annual_leave_rule")
public class AnnualLeaveRule {
	
	@Id
	private String id;
	private int approvalThresoldPercentage;
	private boolean enableBulkApproval;
	private List<AnnualLeaveDetail> annualLeaveDetails = new ArrayList<>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getApprovalThresoldPercentage() {
		return approvalThresoldPercentage;
	}
	public void setApprovalThresoldPercentage(int approvalThresoldPercentage) {
		this.approvalThresoldPercentage = approvalThresoldPercentage;
	}
	public boolean isEnableBulkApproval() {
		return enableBulkApproval;
	}
	public void setEnableBulkApproval(boolean enableBulkApproval) {
		this.enableBulkApproval = enableBulkApproval;
	}
	public List<AnnualLeaveDetail> getAnnualLeaveDetails() {
		return annualLeaveDetails;
	}
	public void setAnnualLeaveDetails(List<AnnualLeaveDetail> annualLeaveDetails) {
		this.annualLeaveDetails = annualLeaveDetails;
	}
	
	
}
