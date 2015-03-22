package org.mahesh.samples.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.persistence.ProductMapper;
import org.mahesh.samples.mvc.service.ProductService;
import org.mahesh.samples.mvc.views.ProductParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	/**
	 * Logger Name for this class.
	 */
	private static final String LOGGING_CLASS_NAME = ProductServiceImpl.class
			.getName();

	@Autowired
	public ProductMapper productMapper;
	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	@Override
	public List<ProductParams> getProducts(ProductParams params) {
		// TODO Auto-generated method stub
		//return productMapper.getProducts(params);
		List<ProductParams> resources = new ArrayList<ProductParams>();
		LOGGER.entering(LOGGING_CLASS_NAME, ": getMenuDetails");
		Long currentPage = params.getPagenum() * params.getPagesize();
		params.setFirstRow(currentPage);
		params.setLastRow(currentPage + params.getPagesize());

		List<ProductParams> paramsResult = productMapper
				.getProducts(params);
		if (paramsResult != null && paramsResult.size() > 0) {
			resources = paramsResult;
		}
		LOGGER.exiting(LOGGING_CLASS_NAME, ": getProducts");
		return resources;
	}

	@Override
	public void insertProduct(ProductParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": insertProduct");
		productMapper.insertProduct(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": insertProduct");
	}

	@Override
	public Long countTotalProducts(ProductParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": countTotalProducts");
		Long count = productMapper.countTotalProducts(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": countTotalProducts");
		return count;
	}

	@Override
	public void updateProduct(ProductParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": updateProduct");
		productMapper.updateProduct(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": updateProduct");
		
	}
	
	@Override
	public void removeProduct(ProductParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": removeProduct");
		productMapper.removeProduct(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": removeProduct");
		
	}

}
