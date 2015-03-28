package org.mahesh.samples.mvc.response;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.service.ProductService;
import org.mahesh.samples.mvc.views.Constants;
import org.mahesh.samples.mvc.views.ProductParams;
import org.mahesh.samples.mvc.views.ResponseJSON;
import org.mahesh.samples.mvc.views.ViewsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/product", method=RequestMethod.GET)
public class ProductController {

	/**
	 * Logger Name for this class.
	 */
	private static final String LOGGING_CLASS_NAME = ProductController.class
			.getName();

	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	/** The resource service. */
	@Autowired
	private ProductService productService;

	/**
	 * Load resouce details.
	 * 
	 * @param resourceDetails
	 *            the resource details
	 * @return the response json
	 */
	@RequestMapping(value = "/getProducts", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON getProducts(
			@RequestBody final ProductParams productParams) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {			
			if (productParams.getPagenum() != null
					&& productParams.getPagesize() != null) {
				productParams.setRows(productService
						.getProducts(productParams));
				productParams.setTotalRows(productService
						.countTotalProducts(productParams));
				mResponseJSON.setResult(productParams);
				mResponseJSON.setStatus("SUCCESS");
			}
		} catch (Exception e) {
			LOGGER.log(
					Level.SEVERE,
					"There is unknown exception from ViewsController while getting the product details ",
					e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON
					.setMessage("There is unknown exception from ViewsController while getting the product details");
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
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON addProduct(
			@RequestBody final ProductParams params) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {
			if(Constants.UPDATE.equalsIgnoreCase(params.getSaveType())) {
				productService.updateProduct(params);
			} else if(Constants.REMOVE.equalsIgnoreCase(params.getSaveType())) {
				productService.removeProduct(params);
			} else {
				productService.insertProduct(params);
			}
			mResponseJSON.setResult(params);
			mResponseJSON.setStatus("SUCCESS");
		} catch (Exception e) {
			LOGGER.log(
					Level.SEVERE,
					"There is unknown exception from ProductController while adding the product details ",
					e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON
					.setMessage("There is unknown exception from ProductController while adding the product details");
		}

		return mResponseJSON;
	}

}
