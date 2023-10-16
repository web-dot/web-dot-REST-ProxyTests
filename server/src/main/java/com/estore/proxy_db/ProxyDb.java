package com.estore.proxy_db;

import java.util.Arrays;
import java.util.List;

import com.estore.dto.CustomerDto;

public class ProxyDb {

	public List<CustomerDto> getCustomers() {
		CustomerDto c1 = new CustomerDto();
		CustomerDto c2 = new CustomerDto();
		CustomerDto c3 = new CustomerDto();
		CustomerDto c4 = new CustomerDto();
		
		
		c1.setCustomerId("f47ac10b-58cc-4372-a567-0e02b2c3d479");
		c1.setOrderList(Arrays.asList("headphones", "smartphone", "tablet"));
		
		c2.setCustomerId("6f3f6e2e-ee59-43b1-8d7e-6ebd028716cc");
		c2.setOrderList(Arrays.asList("book", "guitar-strings", "guitar-bag"));
		
		c3.setCustomerId("d8e61c92-1e60-4aa7-9db3-839b7c8fcd52");
		c3.setOrderList(Arrays.asList("laptop", "mouse", "keyboard"));
		
		c4.setCustomerId("3f5efb6e-7e3b-4e56-8f3a-1b4f3e7d8b4a");
		c4.setOrderList(Arrays.asList("coffee maker", "toaster", "camera", "tripod"));
		
		List<CustomerDto> customersDetails = Arrays.asList(c1, c2, c3, c4);
		return customersDetails;
	}
}
