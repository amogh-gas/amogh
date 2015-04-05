package org.mahesh.samples.mvc.service;

import java.util.List;

import org.mahesh.samples.mvc.views.RateParams;

public interface RateService {

	List<RateParams> getRates(RateParams params);

	Long countTotalRates(RateParams params);
	
	void insertRate(RateParams params);

	void updateRate(RateParams params);
	
	void removeRate(RateParams params);

}
