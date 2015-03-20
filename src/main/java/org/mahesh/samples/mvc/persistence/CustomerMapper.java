package org.mahesh.samples.mvc.persistence;

import java.util.List;

import org.mahesh.samples.mvc.views.CustomerParams;

public interface CustomerMapper {

	List<CustomerParams> getCustomers(CustomerParams params);

	void insertCustomer(CustomerParams params);
}
