package org.mahesh.samples.mvc.service;

import java.util.List;

import org.mahesh.samples.mvc.views.ProductTypeParams;

public interface ProductTypeService {

	List<ProductTypeParams> getProductTypes(ProductTypeParams params);

	Long countTotalProductTypes(ProductTypeParams params);

	List<ProductTypeParams> getAllProductTypes();	
}
