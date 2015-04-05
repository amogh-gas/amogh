package org.mahesh.samples.mvc.persistence;

import java.util.List;

import org.mahesh.samples.mvc.views.CustomerParams;

public interface CustomerMapper {

	List<CustomerParams> getCustomers(CustomerParams params);
	
	Long countTotalCustomers(CustomerParams menuParams);

	void insertCustomer(CustomerParams params);

	void updateCustomer(CustomerParams params);
	
	void removeCustomer(CustomerParams params);
	
	List<CustomerParams> getAllCustomers();
}
