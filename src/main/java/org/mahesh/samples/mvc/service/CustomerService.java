package org.mahesh.samples.mvc.service;

import java.util.List;

import org.mahesh.samples.mvc.views.CustomerParams;

public interface CustomerService {

	List<CustomerParams> getCustomers(CustomerParams params);

	void insertCustoemr(CustomerParams params);

}
