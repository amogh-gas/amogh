package org.mahesh.samples.mvc.response;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.service.RateService;
import org.mahesh.samples.mvc.views.Constants;
import org.mahesh.samples.mvc.views.RateParams;
import org.mahesh.samples.mvc.views.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/rate", method=RequestMethod.GET)
public class RateController {

	private static final String LOGGING_CLASS_NAME = RateController.class.getName();
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	@Autowired
	private RateService rateService;

	/**
	 * Retrieve all rates
	 * @param rateParams
	 * @return
	 */
	@RequestMapping(value = "/getRates", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON getRates(
			@RequestBody final RateParams rateParams) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {			
			if (rateParams.getPagenum() != null
					&& rateParams.getPagesize() != null) {
				rateParams.setRows(rateService.getRates(rateParams));
				rateParams.setTotalRows(rateService.countTotalRates(rateParams));
				mResponseJSON.setResult(rateParams);
				mResponseJSON.setStatus("SUCCESS");
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "There is unknown exception from RateController while getting the rate details", e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON.setMessage("There is unknown exception from RateController while getting the rate details");
		}
		
		return mResponseJSON;
	}

	/**
	 * Create a new rate to the table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/addRate", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON addRate(
			@RequestBody final RateParams params) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {
			if(Constants.UPDATE.equalsIgnoreCase(params.getSaveType())) {
				rateService.updateRate(params);
			} else if(Constants.REMOVE.equalsIgnoreCase(params.getSaveType())) {
				rateService.removeRate(params);
			} else {
				rateService.insertRate(params);
			}
			mResponseJSON.setResult(params);
			mResponseJSON.setStatus("SUCCESS");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "There is unknown exception from RateController while adding the rate details", e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON.setMessage("There is unknown exception from RateController while adding the rate details");
		}

		return mResponseJSON;
	}
}
