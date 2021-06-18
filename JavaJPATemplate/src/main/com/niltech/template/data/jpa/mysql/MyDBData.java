package com.niltech.template.data.jpa.mysql;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="MYDATA")
//@Profile("PROD")
public class MyDBData {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String content;
	private double dValue;
	private Date createdtime;
	
	public MyDBData() {
		super();
	}

	public MyDBData(String content, double dValue) {
		super();
		this.content = content;
		this.dValue = dValue;
	}
	
	public MyDBData(long id, String content, double dValue) {
		super();
		this.id = id;
		this.content = content;
		this.dValue = dValue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getdValue() {
		return dValue;
	}

	public void setdValue(double dValue) {
		this.dValue = dValue;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	@Override
	public String toString() {
		return "MyDBData [id=" + id + ", content=" + content + ", dValue=" + dValue + ", created=" + createdtime + "]";
	}


	
	
}
