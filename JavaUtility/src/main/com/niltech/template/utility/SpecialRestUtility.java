package com.niltech.template.utility;

import org.springframework.stereotype.Component;

import com.niltech.template.service.rest.operation.common.MyServiceUtility;

@Component
public class SpecialRestUtility implements MyServiceUtility{

	public void utilityMethod() {
		System.out.println("Special Utility .....");
	}

}
