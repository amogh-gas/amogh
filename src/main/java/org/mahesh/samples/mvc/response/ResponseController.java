package org.mahesh.samples.mvc.response;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.service.MenuService;
import org.mahesh.samples.mvc.views.MenuDetailsParams;
import org.mahesh.samples.mvc.views.ResponseJSON;
import org.mahesh.samples.mvc.views.ViewsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/response", method=RequestMethod.GET)
public class ResponseController {

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
	private MenuService menuService;

	/**
	 * Load resouce details.
	 * 
	 * @param resourceDetails
	 *            the resource details
	 * @return the response json
	 */
	@RequestMapping(value = "/default/getMenuDetails", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON getMenuDetails(
			@RequestBody final MenuDetailsParams resourceDetails) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {
			if (resourceDetails.getPagenum() != null
					&& resourceDetails.getPagesize() != null) {
				resourceDetails.setRows(menuService
						.getMenuDetails(resourceDetails));
				resourceDetails.setTotalRows(menuService
						.countTotalMenus(resourceDetails));
				mResponseJSON.setResult(resourceDetails);
				mResponseJSON.setStatus("SUCCESS");
			}
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
	@RequestMapping(value = "/default/addMenuDetails", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON addMenuDetails(
			@RequestBody final MenuDetailsParams resourceDetails) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {

			menuService.insertMenuDetails(resourceDetails);
			mResponseJSON.setResult(resourceDetails);
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

	/**
	 * Update menu details.
	 * 
	 * @param resourceDetails
	 *            the resource details
	 * @return the response json
	 */
	@RequestMapping(value = "/default/updateMenuDetails", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON updateMenuDetails(
			@RequestBody final MenuDetailsParams resourceDetails) {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {
			menuService.updateMenu(resourceDetails);
			mResponseJSON.setStatus("SUCCESS");
		} catch (Exception e) {
			LOGGER.log(
					Level.SEVERE,
					"There is unknown exception from ViewsController while updating the menu details ",
					e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON
					.setMessage("There is unknown exception from ViewsController while updating the menu details");
		}

		return mResponseJSON;
	}

	@RequestMapping(value = "/default/getMenus", method = RequestMethod.POST)
	@ResponseBody
	public final ResponseJSON getMenus() {
		final ResponseJSON mResponseJSON = new ResponseJSON();
		try {
			mResponseJSON.setResult(menuService
						.getMenus());
			mResponseJSON.setStatus("SUCCESS");
		} catch (Exception e) {
			LOGGER.log(
					Level.SEVERE,
					"There is unknown exception from ViewsController while getting the menus ",
					e);
			mResponseJSON.setStatus("FAILURE");
			mResponseJSON
					.setMessage("There is unknown exception from ViewsController while getting the menus");
		}

		return mResponseJSON;
	}

	@RequestMapping("/annotation")
	public @ResponseBody String responseBody() {
		return "The String ResponseBody";
	}

	@RequestMapping("/charset/accept")
	public @ResponseBody String responseAcceptHeaderCharset() {
		return "\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)";
	}

	@RequestMapping(value="/charset/produce", produces="text/plain;charset=UTF-8")
	public @ResponseBody String responseProducesConditionCharset() {
		return "\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)";
	}

	@RequestMapping("/entity/status")
	public ResponseEntity<String> responseEntityStatusCode() {
		return new ResponseEntity<String>("The String ResponseBody with custom status code (403 Forbidden)",
				HttpStatus.FORBIDDEN);
	}

	@RequestMapping("/entity/headers")
	public ResponseEntity<String> responseEntityCustomHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("The String ResponseBody with custom header Content-Type=text/plain",
				headers, HttpStatus.OK);
	}

}
