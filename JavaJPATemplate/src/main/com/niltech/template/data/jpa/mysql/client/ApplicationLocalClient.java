package com.niltech.template.data.jpa.mysql.client;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.niltech.template.data.jpa.mysql.MyDBData;
import com.niltech.template.data.jpa.mysql.MySQLDataRepository;

@Component
public class ApplicationLocalClient implements ApplicationListener<ContextStartedEvent>{

	@Autowired
	private MySQLDataRepository myDataRepository;
	
    @EventListener(ApplicationReadyEvent.class)
    public void EventListenerExecute(){
		for (int i = 0; i < 5; i++) {
			MyDBData dbdata = new MyDBData("Content - " + i, i * 4);
			dbdata.setCreatedtime(Calendar.getInstance().getTime());
			myDataRepository.save(dbdata);
		}
    }

	@Override
	public void onApplicationEvent(ContextStartedEvent arg0) {
		System.out.println("Event - " + arg0.getSource().getClass().getName());
	}
}
