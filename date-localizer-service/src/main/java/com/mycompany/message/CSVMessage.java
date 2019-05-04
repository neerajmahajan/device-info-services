package com.mycompany.message;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", skipFirstLine = true)
public class CSVMessage {
	@DataField(pos = 1)
	private String id;
	
	@DataField(pos = 2)
	private long timestamp;
	
	@DataField(pos = 3)
	private String lng;
	
	@DataField(pos = 4)
	private String lat;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "CSVMessage [id=" + id + ", timestamp=" + timestamp + ", lng=" + lng + ", lat=" + lat + "]";
	}

}
