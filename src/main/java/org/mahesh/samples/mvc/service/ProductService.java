package org.mahesh.samples.mvc.service;

import java.util.List;

import org.mahesh.samples.mvc.views.ProductParams;

public interface ProductService {

	List<ProductParams> getProducts(ProductParams params);

	Long countTotalProducts(ProductParams params);
	
	void insertProduct(ProductParams params);

	void updateProduct(ProductParams params);
	
	void removeProduct(ProductParams params);

}
