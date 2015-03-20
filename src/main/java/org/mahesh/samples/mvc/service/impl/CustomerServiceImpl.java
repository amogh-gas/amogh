package org.mahesh.samples.mvc.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.persistence.CustomerMapper;
import org.mahesh.samples.mvc.service.CustomerService;
import org.mahesh.samples.mvc.views.CustomerParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	/**
	 * Logger Name for this class.
	 */
	private static final String LOGGING_CLASS_NAME = CustomerServiceImpl.class
			.getName();

	@Autowired
	public CustomerMapper customerMapper;
	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	@Override
	public List<CustomerParams> getCustomers(CustomerParams params) {
		// TODO Auto-generated method stub
		return customerMapper.getCustomers(params);
	}

	@Override
	public void insertCustoemr(CustomerParams params) {
		// TODO Auto-generated method stub
		customerMapper.insertCustomer(params);
	}

}
