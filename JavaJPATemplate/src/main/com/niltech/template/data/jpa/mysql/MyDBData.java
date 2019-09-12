package com.niltech.template.data.jpa.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.niltech.template.service.rest.operation.common.MyDataInterface;

@Component
@Entity(name="MyData")
@Profile("PROD")
public class MyDBData implements MyDataInterface{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String content;
	private double dValue;
	
	public MyDBData() {
		super();
	}

	public MyDBData(String content, double dValue) {
		super();
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
		return "MyData [id=" + id + ", content=" + content + ", dValue=" + dValue + "]";
	}
	
}
