package com.estore.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class LeaveApprover {
	
	@Id
	private String id;
	private int priority;
	private String approver;
	private boolean enableBulkApprover;
	
	public LeaveApprover() {
		this.id = ObjectId.get().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public boolean isEnableBulkApprover() {
		return enableBulkApprover;
	}

	public void setEnableBulkApprover(boolean enableBulkApprover) {
		this.enableBulkApprover = enableBulkApprover;
	}
	
	
}
