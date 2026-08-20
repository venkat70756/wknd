package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.UpdatedCarouselModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Model(
        adaptables = Resource.class,
        adapters = UpdatedCarouselModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class UpdatedCarouselModelImpl implements UpdatedCarouselModel {


    private static final Logger log = LoggerFactory.getLogger(UpdatedCarouselModelImpl.class);



    @ValueMapValue
    private String carouselTitle;

    @ValueMapValue
    private String backgroundImage;


    @ChildResource
    private List<UpdatedCarouselMultiModel> carouselSlides;

    @Override
    public String getCarouselTitle() {
        log.trace("Trace");
        log.debug("Debug");
        log.info("Info");
        log.warn("Warn");
        log.error("Error");
        return carouselTitle;
    }

    @Override
    public String getBackgroundImage() {
        return backgroundImage;
    }

    @Override
    public List<UpdatedCarouselMultiModel> getCarouselSlides() {
        return carouselSlides;
    }
}
