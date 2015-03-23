package org.mahesh.samples.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.persistence.ProductTypeMapper;
import org.mahesh.samples.mvc.service.ProductTypeService;
import org.mahesh.samples.mvc.views.ProductTypeParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {
	/**
	 * Logger Name for this class.
	 */
	private static final String LOGGING_CLASS_NAME = ProductTypeServiceImpl.class
			.getName();

	@Autowired
	public ProductTypeMapper productTypeMapper;
	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	@Override
	public List<ProductTypeParams> getProductTypes(ProductTypeParams params) {
		List<ProductTypeParams> resources = new ArrayList<ProductTypeParams>();
		LOGGER.entering(LOGGING_CLASS_NAME, ": getProductType");
		Long currentPage = params.getPagenum() * params.getPagesize();
		params.setFirstRow(currentPage);
		params.setLastRow(currentPage + params.getPagesize());

		List<ProductTypeParams> paramsResult = productTypeMapper
				.getProductTypes(params);
		if (paramsResult != null && paramsResult.size() > 0) {
			resources = paramsResult;
		}
		LOGGER.exiting(LOGGING_CLASS_NAME, ": getProductTypes");
		return resources;
	}

	@Override
	public Long countTotalProductTypes(ProductTypeParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": countTotalProductTypes");
		Long count = productTypeMapper.countTotalProductTypes(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": countTotalProductTypes");
		return count;
	}
}
