package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.MadhanBundlesService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = MadhanBundlesService.class, immediate = true)
@Designate(ocd = MadhanConfig.class)  // for the separate file
//@Designate(ocd = MadhanBundlesServiceImpl.Config.class)  // with in the same file
public class MadhanBundlesServiceImpl implements MadhanBundlesService {

    private static final Logger log = LoggerFactory.getLogger(MadhanBundlesServiceImpl.class);


//    @ObjectClassDefinition(name = "venkat m configuration")
//    public @interface Config{
//
//    }

    @Activate
    public void activate(){
        log.info("Activate method got triggered");

    }

    @Modified
    public void modified(){
        log.info("Modified Method got triggered");

    }


    @Deactivate
    public void deactivate(){
        log.info("Deactivate method got triggered");
    }

}
