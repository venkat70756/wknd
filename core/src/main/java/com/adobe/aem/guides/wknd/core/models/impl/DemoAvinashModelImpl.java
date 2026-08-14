package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.DemoAvinashModel;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = Resource.class,
        adapters = DemoAvinashModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class DemoAvinashModelImpl implements DemoAvinashModel{

    @ValueMapValue
    private String bannerImage;

    @ValueMapValue
    private String bannerTitle;


    @ValueMapValue
    private String bannerDescription;



    @Override
    public String getBannerImage() {
        return bannerImage;
    }

    @Override
    public String getBannerTitle() {
        return bannerTitle;
    }

    @Override
    public String getBannerDescription() {
        return  bannerDescription;
    }
}
