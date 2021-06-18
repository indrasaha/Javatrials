package com.niltech.template.data.jpa.mysql;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.niltech.template.common.service.MyData;
import com.niltech.template.common.service.MyDataServiceInterface;

@Component 
//@Profile("PROD")
public class MySQLDataServiceImpl implements MyDataServiceInterface<MyData> {
	
	public MySQLDataServiceImpl() {
		super();
	}

	@Autowired
	@Qualifier("mySQLDataRepository")
	private MySQLDataRepository mySQLDataRepository;
	
	@Override
	public int addService(MyData arg0) {
		MyDBData dbdata = new MyDBData(arg0.getId(),arg0.getContent(), arg0.getdValue());
		dbdata.setCreatedtime(Calendar.getInstance().getTime());
		mySQLDataRepository.save(dbdata);
		return 0;
	}

	@Override
	public int deleteService(MyData arg0) {
		MyDBData dbdata = new MyDBData(arg0.getId(),arg0.getContent(), arg0.getdValue());
		mySQLDataRepository.delete(dbdata);
		return 0;
	}

	@Override
	public List<MyData> getAllService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyData getAllService(int arg0) {
		mySQLDataRepository.findAll();
		return null;
	}

	@Override
	public MyData updateService(MyData arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public CrudRepository<MyDBData, Long> getDataRepository() { return
	 * mySQLDataRepository; }
	 */
	
}
