package org.mahesh.samples.mvc.service;

import java.util.List;

import org.mahesh.samples.mvc.views.CustomerParams;

public interface CustomerService {

	List<CustomerParams> getCustomers(CustomerParams params);

	Long countTotalCustomers(CustomerParams params);
	
	void insertCustomer(CustomerParams params);

	void updateCustomer(CustomerParams params);
	
	void removeCustomer(CustomerParams params);
	
	List<CustomerParams> getAllCustomers();

}
