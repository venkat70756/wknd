package com.adobe.aem.guides.wknd.core.models;

import com.adobe.aem.guides.wknd.core.models.impl.UpdatedCarouselMultiModel;

import java.util.List;

public interface UpdatedCarouselModel {

    public String getCarouselTitle();

    public String getBackgroundImage();

    public List<UpdatedCarouselMultiModel> getCarouselSlides();
}
