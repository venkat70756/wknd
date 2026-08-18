package com.adobe.aem.guides.wknd.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class UpdatedCarouselMultiModel {

    @ValueMapValue
    private String carouselSlide;


    public String getCarouselSlide(){

        return carouselSlide;
    }
}
