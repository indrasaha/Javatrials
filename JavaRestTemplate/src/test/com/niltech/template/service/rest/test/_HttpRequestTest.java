package com.niltech.template.service.rest.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.niltech.template.service.rest.operation.MyData;
import com.niltech.template.service.rest.operation.RestTemplateApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes=RestTemplateApplication.class)

public class _HttpRequestTest {

	private final String contextRoot = "/JavaRestTemplate/";

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getMyDataTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + contextRoot + "getdatalist", MyData.class));
	}
}