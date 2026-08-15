package com.adobe.aem.guides.wknd.core.models.Impl;

import com.adobe.aem.guides.wknd.core.models.DemoDevaModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;


@Model(adaptables = Resource.class,
        adapters = DemoDevaModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class DemoDevaModelImpl implements DemoDevaModel {


    @ValueMapValue
    private String bannerTitle;


    @ValueMapValue
    private String bannerDescription;


    @ValueMapValue
    private String bannerImage;


    @ChildResource
    private List<DemoDevaMultiModel> bannerTabs;


    @Override
    public String getBannerTitle() {
        bannerTitle = bannerTitle.toUpperCase();
        return bannerTitle;
    }

    @Override
    public String getBannerDescription() {
        return bannerDescription;
    }

    @Override
    public String getBannerImage() {
        return bannerImage;
    }


    @Override
    public List<DemoDevaMultiModel> getBannerTabs(){
        return bannerTabs;
    }
}
