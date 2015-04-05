package org.mahesh.samples.mvc.response;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.service.CustomerService;
import org.mahesh.samples.mvc.views.Constants;
import org.mahesh.samples.mvc.views.CustomerParams;
import org.mahesh.samples.mvc.views.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/customer", method=RequestMethod.GET)
public class CustomerController {

	private static final String LOGGING_CLASS_NAME = CustomerController.class.getName();
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	@Autowired
	private CustomerService customerService;

	/**
	 * Retrieve all customers
	 * @param customerParams
	 * @return
	 */
	@RequestMapping(value = "/getCustomers", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON getCustomers(
			@RequestBody final CustomerParams customerParams) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {			
			if (customerParams.getPagenum() != null
					&& customerParams.getPagesize() != null) {
				customerParams.setRows(customerService.getCustomers(customerParams));
				customerParams.setTotalRows(customerService.countTotalCustomers(customerParams));
				mResponseJSON.setResult(customerParams);
				mResponseJSON.setStatus("SUCCESS");
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "There is unknown exception from CustomerController while getting the customer details", e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON.setMessage("There is unknown exception from CustomerController while getting the customer details");
		}
		
		return mResponseJSON;
	}
	
	/**
	 * Returns the list of Customers
	 * @return List of customers
	 */
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON getAllCustomers() {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {
			mResponseJSON.setResult(customerService.getAllCustomers());
			mResponseJSON.setStatus("SUCCESS");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "There is unknown exception from ProductController while getting the product details ", e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON.setMessage("There is unknown exception from ProductTypeController while getting the product type details");
		}

		return mResponseJSON;
	}	

	/**
	 * Create a new customer to the table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON addCustomer(
			@RequestBody final CustomerParams params) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {
			if(Constants.UPDATE.equalsIgnoreCase(params.getSaveType())) {
				customerService.updateCustomer(params);
			} else if(Constants.REMOVE.equalsIgnoreCase(params.getSaveType())) {
				customerService.removeCustomer(params);
			} else {
				customerService.insertCustomer(params);
			}
			mResponseJSON.setResult(params);
			mResponseJSON.setStatus("SUCCESS");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "There is unknown exception from CustomerController while adding the customer details", e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON.setMessage("There is unknown exception from CustomerController while adding the customer details");
		}

		return mResponseJSON;
	}
}
