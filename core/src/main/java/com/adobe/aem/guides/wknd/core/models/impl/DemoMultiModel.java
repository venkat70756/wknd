package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.services.DemoService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class DemoMultiModel {

    @ValueMapValue
    private String headingTitle;

    @ValueMapValue
    private String headingLink;


    public String getHeadingTitle(){
        return headingTitle;
    }

    public String getHeadingLink(){
        return headingLink;
    }
    
}


/*
*  Classes
*  Objects
*  Methods
*  abstraction (interface)
*  inheritance
*
*  JCF(List Map)
 */