package com.niltech.template.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niltech.template.common.service.MyData;
import com.niltech.template.common.service.MyDataServiceInterface;
import com.niltech.template.data.jpa.mysql.MyDBData;

@Service
public class MyDataService implements MyDataServiceInterface <MyData>{

	@Autowired
	private MyDBData myDBData;
			
	@Override
	public int addService(MyData arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteService(MyData arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MyData> getAllService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyData getAllService(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyData updateService(MyData arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
