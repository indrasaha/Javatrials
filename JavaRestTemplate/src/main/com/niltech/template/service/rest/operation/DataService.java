package com.niltech.template.service.rest.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataService {
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public @ResponseBody String greeting() {
		return "Hello World";
	}
	

	// Push single data entity
	@RequestMapping(value = "/pushdata", method = RequestMethod.POST)
	public void pushData(@RequestBody MyData myData) {
		myData.setId(counter.getAndIncrement());
		System.out.println(myData);
	}
	
	// Push data entity list
	@RequestMapping(value = "/pushdatalist", method = RequestMethod.POST)
	public void pushDataList(@RequestBody List <MyData> myDataList) {
		for(MyData myData : myDataList) {
			myData.setId(counter.getAndIncrement());
		}
		System.out.println(myDataList);
	}
	
	// Modify data entity
	@RequestMapping(value = "/modifydata/{id}", method = RequestMethod.PUT)
	public ResponseEntity<MyData> modifyData(@PathVariable Long id, @RequestBody MyData myData) {
		System.out.println("Updating my data for id - " + id);
		myData.setContent("Updated Content..");
		System.out.println(myData);
		return new ResponseEntity<MyData>(myData, HttpStatus.OK);
	}
	
	// Get data an entity
	@RequestMapping(value = "/getdata", method = RequestMethod.POST)
	public ResponseEntity<MyData> getData(@RequestParam Long id) {
		System.out.println("Requesting my data for id - " + id);
		MyData myData = new MyData(counter.getAndIncrement(), "My Data");
		myData.setdValue(500.00);
		System.out.println(myData);
		return new ResponseEntity<MyData>(myData, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getdatalist", method = RequestMethod.POST)
	public ResponseEntity<List<MyData>> getDataList() {
		List <MyData> myDataList = new ArrayList<MyData>();
		for(int i=0; i < 10; i++) {
			MyData myData = new MyData(counter.getAndIncrement(), "Content of ");
			myData.setContent("Content of " + myData.getId());
			myDataList.add(myData);
		}
		
		return new ResponseEntity <List<MyData>> (myDataList, HttpStatus.OK);
	}
	
	
}