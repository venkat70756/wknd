package com.adobe.aem.guides.wknd.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.guides.wknd.core.models.DemoModel;

@Model(adaptables = Resource.class,
    adapters = DemoModel.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class DemoModelImpl implements DemoModel{

    @ValueMapValue
    private String id;

    @ValueMapValue
    private String heading;

    @ValueMapValue
    private String subTitle;



    @Override
    public String getId(){
        return id;
    }


    @Override
    public String getHeading(){
        return heading;
    }

    @Override
    public String getSubTitle(){
        return subTitle;
    }

}