package com.mycompany.model;

public class Response {
	private String deviceId;
	private String localizedDate;
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getLocalizedDate() {
		return localizedDate;
	}
	public void setLocalizedDate(String localizedDate) {
		this.localizedDate = localizedDate;
	}
	@Override
	public String toString() {
		return "Response [deviceId=" + deviceId + ", localizedDate=" + localizedDate + "]";
	}
	
	
}
