package com.mycompany;

import java.util.List;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.message.CSVMessage;

public class DeviceInfoFinder {

	private static final Logger logger = LoggerFactory.getLogger(DeviceInfoFinder.class);
	
	public void process(Exchange exchange) throws Exception {
		
		List<CSVMessage> csvMessages = exchange.getIn().getBody(List.class);
		for (CSVMessage csvMessage : csvMessages) {
			if (csvMessage.getId().equals(exchange.getProperty("deviceId"))) {
				exchange.setProperty("timestamp", csvMessage.getTimestamp());
				exchange.getIn().setBody(csvMessage);
				
				logger.debug("Matched deviceId :{}", csvMessage.getId());
				break;
			}
		}
		
	}

}
