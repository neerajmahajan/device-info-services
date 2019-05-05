package com.mycompany.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.message.GeocoderResponse;
import com.mycompany.model.Response;

public class DateConverterByZone {

	private static final Logger logger = LoggerFactory.getLogger(DateConverterByZone.class);
	
	public void process(Exchange exchange) throws Exception {

		GeocoderResponse response = exchange.getIn().getBody(GeocoderResponse.class);
		
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm z Z");
		
		long property = (long)exchange.getProperty("timestamp") * 1000;
		Date date = new Date(property);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone(response.getZoneName()));
		String localizedDate = simpleDateFormat.format(date);
		Response finalResponse = new Response();
		finalResponse.setDeviceId(exchange.getProperty("deviceId",String.class));
		finalResponse.setLocalizedDate(localizedDate);
		finalResponse.setResponseMessage("Successfully retrieved local time");
		logger.debug("Localized Date :{}", localizedDate);
		exchange.getOut().setBody(finalResponse);
	}

}
