package com.adobe.aem.guides.wknd.core.models.Impl;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class DemoDevaMultiModel {

    @ValueMapValue
    private String pageTitle;

    @ValueMapValue
    private String pagePath;



    public String getPageTitle(){
        return pageTitle;
    }


    public String getPagePath(){
        return pagePath;
    }
}
