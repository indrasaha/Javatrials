package com.niltech.template.service.rest.test;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.niltech.template.service.rest.operation.DataService;
import com.niltech.template.service.rest.operation.RestTemplateApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RestTemplateApplication.class)
public class _SmokeTest {

    @Autowired
    private DataService controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}