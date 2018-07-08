package com.niltech.template.service.rest.operation;

public class MyData {

	private long id;
	private String content;
	private Double dValue;
	
	public MyData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyData(long id, String content) {
		this.id = id;
		this.content = content;
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
		return "MyData [id=" + id + ", content=" + content + ", dValue=" + dValue + "]";
	}
	
}
