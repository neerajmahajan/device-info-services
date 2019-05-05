package com.mycompany;

import org.apache.camel.Exchange;

import com.mycompany.model.Response;

public class NoMatchResponseGenerator {
	public void process(Exchange exchange) throws Exception {

		String message = exchange.getIn().getBody(String.class);
		
		Response responseForDeviceId = new Response();
		responseForDeviceId.setDeviceId(exchange.getProperty("deviceId", String.class));
		responseForDeviceId.setResponseMessage(message);
		
		exchange.getOut().setBody(responseForDeviceId);
	}

}
