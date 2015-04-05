package org.mahesh.samples.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.persistence.CustomerMapper;
import org.mahesh.samples.mvc.service.CustomerService;
import org.mahesh.samples.mvc.views.CustomerParams;
import org.mahesh.samples.mvc.views.ProductParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	private static final String LOGGING_CLASS_NAME = CustomerServiceImpl.class.getName();
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);
	
	@Autowired
	public CustomerMapper customerMapper;
	
	@Override
	public List<CustomerParams> getCustomers(CustomerParams params) {
		List<CustomerParams> customers = new ArrayList<CustomerParams>();
		LOGGER.entering(LOGGING_CLASS_NAME, ": getCustomers");
		Long currentPage = params.getPagenum() * params.getPagesize();
		params.setFirstRow(currentPage);
		params.setLastRow(currentPage + params.getPagesize());

		List<CustomerParams> paramsResult = customerMapper.getCustomers(params);
		if (paramsResult != null && paramsResult.size() > 0) {
			customers = paramsResult;
		}
		LOGGER.exiting(LOGGING_CLASS_NAME, ": getCustomers");
		return customers;
	}

	@Override
	public void insertCustomer(CustomerParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": insertCustomer");
		customerMapper.insertCustomer(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": insertCustomer");
	}

	@Override
	public Long countTotalCustomers(CustomerParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": countTotalCustomers");
		Long count = customerMapper.countTotalCustomers(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": countTotalCustomers");
		return count;
	}

	@Override
	public void updateCustomer(CustomerParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": updateCustomer");
		customerMapper.updateCustomer(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": updateCustomer");
		
	}
	
	@Override
	public void removeCustomer(CustomerParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": removeCustomer");
		customerMapper.removeCustomer(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": removeCustomer");
		
	}
	
	@Override
	public List<CustomerParams> getAllCustomers() {
		LOGGER.entering(LOGGING_CLASS_NAME, ": getAllCustomers");
		List<CustomerParams> list = customerMapper.getAllCustomers();
		LOGGER.exiting(LOGGING_CLASS_NAME, ": getAllCustomer");
		return list;
	}
}
