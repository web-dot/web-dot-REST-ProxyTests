package com.estore.service;

import java.util.List;

import com.estore.dto.CustomerDto;

public interface PrimaryService {
	
	public String downloadStudentPdfFile(String id);
	
	public CustomerDto returnOrderListBasedOnId(String customerId);
}
