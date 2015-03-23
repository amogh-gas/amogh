package org.mahesh.samples.mvc.response;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.service.ProductTypeService;
import org.mahesh.samples.mvc.views.ProductTypeParams;
import org.mahesh.samples.mvc.views.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/productType", method = RequestMethod.GET)
public class ProductTypeController {

	/**
	 * Logger Name for this class.
	 */
	private static final String LOGGING_CLASS_NAME = ProductTypeController.class
			.getName();

	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	/** The resource service. */
	@Autowired
	private ProductTypeService productTypeService;

	/**
	 * Load resouce details.
	 * 
	 * @param resourceDetails
	 *            the resource details
	 * @return the response json
	 */
	@RequestMapping(value = "/getProductTypes", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON getProducts(
			@RequestBody final ProductTypeParams productTypeParams) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {
			if (productTypeParams.getPagenum() != null
					&& productTypeParams.getPagesize() != null) {
				productTypeParams.setRows(productTypeService
						.getProductTypes(productTypeParams));
				productTypeParams.setTotalRows(productTypeService
						.countTotalProductTypes(productTypeParams));
				mResponseJSON.setResult(productTypeParams);
				mResponseJSON.setStatus("SUCCESS");
			}
		} catch (Exception e) {
			LOGGER.log(
					Level.SEVERE,
					"There is unknown exception from ProductTypeController while getting the product type details ",
					e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON
					.setMessage("There is unknown exception from ProductTypeController while getting the product type details");
		}

		return mResponseJSON;
	}

	@RequestMapping(value = "/getAllProductTypes", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON getAllProducts() {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {
			mResponseJSON.setResult(productTypeService.getAllProductTypes());
			mResponseJSON.setStatus("SUCCESS");
		} catch (Exception e) {
			LOGGER.log(
					Level.SEVERE,
					"There is unknown exception from ProductTypeController while getting the product type details ",
					e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON
					.setMessage("There is unknown exception from ProductTypeController while getting the product type details");
		}

		return mResponseJSON;
	}
}
