package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.MadhanDemoModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class,
        adapters = MadhanDemoModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class MadhanDemoModelImpl implements MadhanDemoModel {

    @ValueMapValue
    private String madhanTitle;

    @ValueMapValue
    private String madhanDescription;


    @ValueMapValue
    private String mobileNumber;

    @ValueMapValue
    private String compHeight;

    @ChildResource
    private List<MadhanDemoMultiModel> contact;



    private String myName = "venkat";


    @Override
    public String getMadhanTitle() {
        return madhanTitle;
    }

    @Override
    public String getMadhanDescription() {
        return madhanDescription;
    }

    @Override
    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public String getCompHeight() {
        return compHeight;
    }

    @Override
    public String getMyName() {
        return myName;
    }

    @Override
    public List<MadhanDemoMultiModel> getContact() {
        return  contact;
    }
}
