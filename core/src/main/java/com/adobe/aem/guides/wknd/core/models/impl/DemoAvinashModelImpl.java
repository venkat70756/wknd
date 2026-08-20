package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.DemoAvinashModel;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger log = LoggerFactory.getLogger(DemoAvinashModelImpl.class);



    @Override
    public String getBannerImage() {
        return bannerImage;
    }

    @Override
    public String getBannerTitle() {
        log.info("Banner Title is: {}", bannerTitle);
        return bannerTitle;
    }

    @Override
    public String getBannerDescription() {
        return  bannerDescription;
    }
}
