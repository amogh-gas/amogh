package org.mahesh.samples.mvc.persistence;

import java.util.List;

import org.mahesh.samples.mvc.views.ProductTypeParams;

public interface ProductTypeMapper {

	List<ProductTypeParams> getProductTypes(ProductTypeParams params);
	
	Long countTotalProductTypes(ProductTypeParams params);
}
