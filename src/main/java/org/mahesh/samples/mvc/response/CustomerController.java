package org.mahesh.samples.mvc.response;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.service.CustomerService;
import org.mahesh.samples.mvc.views.CustomerParams;
import org.mahesh.samples.mvc.views.ResponseJSON;
import org.mahesh.samples.mvc.views.ViewsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/customer", method=RequestMethod.GET)
public class CustomerController {

	/**
	 * Logger Name for this class.
	 */
	private static final String LOGGING_CLASS_NAME = ViewsController.class
			.getName();

	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	/** The resource service. */
	@Autowired
	private CustomerService customerService;

	/**
	 * Load resouce details.
	 * 
	 * @param resourceDetails
	 *            the resource details
	 * @return the response json
	 */
	@RequestMapping(value = "/getCustomers", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON getCustomers(
			@RequestBody final CustomerParams resourceDetails) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {
				mResponseJSON.setResult(customerService.getCustomers(resourceDetails));
				mResponseJSON.setStatus("SUCCESS");
		} catch (Exception e) {
			LOGGER.log(
					Level.SEVERE,
					"There is unknown exception from ViewsController while getting the menu details ",
					e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON
					.setMessage("There is unknown exception from ViewsController while getting the menu details");
		}

		return mResponseJSON;
	}

	/**
	 * Adds the resouce details.
	 * 
	 * @param resourceDetails
	 *            the resource details
	 * @return the response json
	 */
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON addCustomer(
			@RequestBody final CustomerParams params) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {

			customerService.insertCustoemr(params);
			mResponseJSON.setResult(params);
			mResponseJSON.setStatus("SUCCESS");
		} catch (Exception e) {
			LOGGER.log(
					Level.SEVERE,
					"There is unknown exception from ViewsController while adding the menu details ",
					e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON
					.setMessage("There is unknown exception from ViewsController while adding the menu details");
		}

		return mResponseJSON;
	}

}
