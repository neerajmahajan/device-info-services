package com.mycompany.util.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.model.Response;
import com.mycompany.route.proxy.DateConversionRouteProxy;
import com.mycompany.util.DateConverter;

public class DateConverterImpl implements DateConverter {

	private static final Logger logger = LoggerFactory.getLogger(DateConverterImpl.class);
	private DateConversionRouteProxy dateConversionRouteProxy;
	
	public DateConversionRouteProxy getDateConversionRouteProxy() {
		return dateConversionRouteProxy;
	}

	public void setDateConversionRouteProxy(DateConversionRouteProxy dateConversionRouteProxy) {
		this.dateConversionRouteProxy = dateConversionRouteProxy;
	}

	@Override
	public Response getLocalizeDate(String deviceId) {
		Response response = new Response();
				
		String localizedDate = dateConversionRouteProxy.getLocalizeDate(deviceId);
		logger.debug("Final Localized Date :{}", localizedDate);

		response.setDeviceId(deviceId);
		response.setLocalizedDate(localizedDate);
		
		return response;
	}

}
