package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.TestService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = TestService.class, immediate = true)
public class TestServiceImpl implements TestService {


    private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);



    @Activate
    public void activate(){
        log.info("Bundle Got Activated");
    }


    @Modified
    public void modified(){
        log.info("Bundle Got modified");
    }

    @Deactivate
    public void deactivated(){
        log.info("Bundle got deactivated");
    }

}
