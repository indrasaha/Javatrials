package com.niltech.template.data.jpa.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.niltech.template.service.rest.operation.common.MyDataServiceInterface;

@Component 
@Profile("PROD")
public class MySQLDataServiceImpl implements MyDataServiceInterface<MyDBData> {
	
	public MySQLDataServiceImpl() {
		super();
	}

	@Autowired
	@Qualifier("mySQLDataRepository")
	private MySQLDataRepository mySQLDataRepository;
	
	@Override
	public CrudRepository<MyDBData, Long> getDataRepository() {
		return mySQLDataRepository;
	}
	
}
