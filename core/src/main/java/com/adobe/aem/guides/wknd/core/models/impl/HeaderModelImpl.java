package com.adobe.aem.guides.wknd.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.guides.wknd.core.models.HeaderModel;

@Model(adaptables = Resource.class,
    adapters = HeaderModel.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeaderModelImpl implements HeaderModel{

    @ValueMapValue
    private String mobileNumber;


    @ValueMapValue
    private String email;


    @ValueMapValue
    private String loginText;


    @ValueMapValue
    private String registerText;

    @ValueMapValue
    private String universityName;





    @Override
    public String getMobileNumber() {

        return mobileNumber;
    }

    @Override
    public String getEmail() {

       return email;
    }

    @Override
    public String getLoginText() {
    
        return loginText;
    }

    @Override
    public String getRegisterText() {

        return registerText;
    }

    @Override
    public String getUniversityName() {

        return universityName;
    }

    @Override
    public String getDummyValue(){

        return "this is the dummy value";

    }
    
}
