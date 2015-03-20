package org.mahesh.samples.mvc.persistence;

import java.util.List;

import org.mahesh.samples.mvc.views.ProductParams;

public interface ProductMapper {

	List<ProductParams> getProducts(ProductParams params);
	
	Long countTotalProducts(ProductParams menuParams);

	void insertProduct(ProductParams params);
}
