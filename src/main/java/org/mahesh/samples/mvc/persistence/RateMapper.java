package org.mahesh.samples.mvc.persistence;

import java.util.List;

import org.mahesh.samples.mvc.views.RateParams;

public interface RateMapper {

	List<RateParams> getRates(RateParams params);
	
	Long countTotalRates(RateParams menuParams);

	void insertRate(RateParams params);

	void updateRate(RateParams params);
	
	void removeRate(RateParams params);
}
