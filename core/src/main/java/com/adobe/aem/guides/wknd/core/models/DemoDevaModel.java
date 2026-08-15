package com.adobe.aem.guides.wknd.core.models;

import com.adobe.aem.guides.wknd.core.models.Impl.DemoDevaMultiModel;


import java.util.List;

public interface DemoDevaModel {

    public String getBannerTitle();

    public String getBannerDescription();

    public String getBannerImage();

    public List<DemoDevaMultiModel> getBannerTabs();

}
