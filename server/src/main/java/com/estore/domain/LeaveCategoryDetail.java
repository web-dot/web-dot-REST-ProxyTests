package com.estore.domain;

public class LeaveCategoryDetail {
	
	private String id;
	private String categoryName;
	private String categoryShortName;
	private BalanceType balanceTypes;
	private double noOfAnnualLeaves;
	private double totalLeaves;
	private double minLeavesCanBeTakenAtOnce;
	private double maxLeavesCanBeTakenAtOnce;
	private boolean carryable;
	private double maxCarryableDays;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryShortName() {
		return categoryShortName;
	}
	public void setCategoryShortName(String categoryShortName) {
		this.categoryShortName = categoryShortName;
	}
	public BalanceType getBalanceTypes() {
		return balanceTypes;
	}
	public void setBalanceTypes(BalanceType balanceTypes) {
		this.balanceTypes = balanceTypes;
	}
	public double getNoOfAnnualLeaves() {
		return noOfAnnualLeaves;
	}
	public void setNoOfAnnualLeaves(double noOfAnnualLeaves) {
		this.noOfAnnualLeaves = noOfAnnualLeaves;
	}
	public double getTotalLeaves() {
		return totalLeaves;
	}
	public void setTotalLeaves(double totalLeaves) {
		this.totalLeaves = totalLeaves;
	}
	public double getMinLeavesCanBeTakenAtOnce() {
		return minLeavesCanBeTakenAtOnce;
	}
	public void setMinLeavesCanBeTakenAtOnce(double minLeavesCanBeTakenAtOnce) {
		this.minLeavesCanBeTakenAtOnce = minLeavesCanBeTakenAtOnce;
	}
	public double getMaxLeavesCanBeTakenAtOnce() {
		return maxLeavesCanBeTakenAtOnce;
	}
	public void setMaxLeavesCanBeTakenAtOnce(double maxLeavesCanBeTakenAtOnce) {
		this.maxLeavesCanBeTakenAtOnce = maxLeavesCanBeTakenAtOnce;
	}
	public boolean isCarryable() {
		return carryable;
	}
	public void setCarryable(boolean carryable) {
		this.carryable = carryable;
	}
	public double getMaxCarryableDays() {
		return maxCarryableDays;
	}
	public void setMaxCarryableDays(double maxCarryableDays) {
		this.maxCarryableDays = maxCarryableDays;
	}
}
