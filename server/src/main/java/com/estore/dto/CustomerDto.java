package com.estore.dto;

import java.util.List;

public class CustomerDto {
	
	private String customerId;
	private List<String> orderList;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public List<String> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<String> orderList) {
		this.orderList = orderList;
	}

}
