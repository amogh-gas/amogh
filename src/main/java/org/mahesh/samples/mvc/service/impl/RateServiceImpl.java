package org.mahesh.samples.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.mahesh.samples.mvc.persistence.RateMapper;
import org.mahesh.samples.mvc.service.RateService;
import org.mahesh.samples.mvc.views.RateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rateService")
public class RateServiceImpl implements RateService {
	
	private static final String LOGGING_CLASS_NAME = RateServiceImpl.class.getName();
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);
	
	@Autowired
	public RateMapper rateMapper;
	
	@Override
	public List<RateParams> getRates(RateParams params) {
		List<RateParams> rates = new ArrayList<RateParams>();
		LOGGER.entering(LOGGING_CLASS_NAME, ": getRates");
		Long currentPage = params.getPagenum() * params.getPagesize();
		params.setFirstRow(currentPage);
		params.setLastRow(currentPage + params.getPagesize());

		List<RateParams> paramsResult = rateMapper.getRates(params);
		if (paramsResult != null && paramsResult.size() > 0) {
			rates = paramsResult;
		}
		LOGGER.exiting(LOGGING_CLASS_NAME, ": getRates");
		return rates;
	}

	@Override
	public void insertRate(RateParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": insertRate");
		rateMapper.insertRate(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": insertRate");
	}

	@Override
	public Long countTotalRates(RateParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": countTotalRates");
		Long count = rateMapper.countTotalRates(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": countTotalRates");
		return count;
	}

	@Override
	public void updateRate(RateParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": updateRate");
		rateMapper.updateRate(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": updateRate");
		
	}
	
	@Override
	public void removeRate(RateParams params) {
		LOGGER.entering(LOGGING_CLASS_NAME, ": removeRate");
		rateMapper.removeRate(params);
		LOGGER.exiting(LOGGING_CLASS_NAME, ": removeRate");
		
	}
}
