package com.adobe.aem.guides.wknd.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class MadhanDemoMultiModel {


    @ValueMapValue
    private String contactName;

    @ValueMapValue
    private String contactEmail;

    @ValueMapValue
    private boolean hideEmail;


    public String getContactName(){

        return contactName;
    }


    public String getContactEmail(){

        return contactEmail;
    }

    public boolean getHideEmail(){
        return hideEmail;
    }
}
