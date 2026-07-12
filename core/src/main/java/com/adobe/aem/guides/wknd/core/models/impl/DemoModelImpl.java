package com.adobe.aem.guides.wknd.core.models.impl;

import java.util.List;

import com.adobe.aem.guides.wknd.core.services.DemoService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.guides.wknd.core.models.DemoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class,
    adapters = DemoModel.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class DemoModelImpl implements DemoModel{

    private static final Logger log = LoggerFactory.getLogger(DemoModelImpl.class);

    @ValueMapValue
    private String id;

    @ValueMapValue
    private String heading;

    @ValueMapValue
    private String subTitle;

    @ChildResource
    private List<DemoMultiModel> headingTabs;


    @OSGiService
    private DemoService demoService;

    String name;

    @Override
    public String getId(){
        return id;
    }


    @Override
    public String getHeading(){

     demoService.getWelcome();

         int a = 50;
         int b = 100;

        demoService.getAddition(a, b);


        log.info("Heading : {}", heading);
        return heading;
    }

    @Override
    public String getSubTitle(){
        return subTitle;
    }

    @Override
    public List<DemoMultiModel> getHeadingTabs(){

        return headingTabs;
    }

    @Override
    public String getTestName() {

        name = demoService.getName();

        return name;
    }

}