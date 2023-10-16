package com.estore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estore.dto.CustomerDto;
import com.estore.proxy_db.ProxyDb;

@Service
public class PrimaryServiceImpl implements PrimaryService {

	@Override
	public String downloadStudentPdfFile(String id) {
		return id != null ? "processing student id" : null;
	}
	
	@Override
	public CustomerDto returnOrderListBasedOnId(String customerId) {
		
		/**
		 * the data will be retrieved from db based on the customer id,
		 * the below implementation is a proxy implementation
		 * */
		ProxyDb db = new ProxyDb();
		CustomerDto customer = null;
		List<CustomerDto> customers = db.getCustomers();
		for(CustomerDto dto : customers) {
			if(dto.getCustomerId().equals(customerId)) {
				customer = dto;
			}
		}
		return customer;
	}

}
