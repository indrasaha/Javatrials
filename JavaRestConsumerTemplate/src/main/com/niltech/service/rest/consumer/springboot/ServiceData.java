package com.niltech.service.rest.consumer.springboot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceData {

	private long id;
	private String content;
	private Double dValue;
	
	public ServiceData() {
		super();
	}

	public ServiceData(long id, String content, Double dValue) {
		super();
		this.id = id;
		this.content = content;
		this.dValue = dValue;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	public Double getdValue() {
		return dValue;
	}

	public void setdValue(Double dValue) {
		this.dValue = dValue;
	}

	@Override
	public String toString() {
		return "ServiceData [id=" + id + ", content=" + content + ", dValue=" + dValue + "]";
	}


	
}
