package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.DemoService;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = DemoService.class)
public class DemoServiceImpl implements DemoService {

    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public void getWelcome() {

        log.info("Welcome to Demo Service");

    }

    @Override
    public int getAddition(int a, int b) {
        int result = a + b;
        log.info("Addition of {} and {} is : {}", a, b, result);
        return result;
    }

    @Override
    public String getName() {
        return "Hi good Morning, Welcome to Demo Service";
    }

}
