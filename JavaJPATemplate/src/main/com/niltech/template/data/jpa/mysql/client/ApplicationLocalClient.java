package com.niltech.template.data.jpa.mysql.client;

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
			myDataRepository.save(new MyDBData("Content - " + i, i * 4));
		}
    }

	@Override
	public void onApplicationEvent(ContextStartedEvent arg0) {
		System.out.println("Event - " + arg0.getSource().getClass().getName());
	}
}
