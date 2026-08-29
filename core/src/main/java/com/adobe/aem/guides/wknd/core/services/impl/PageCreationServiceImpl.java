package com.adobe.aem.guides.wknd.core.services.impl;


import com.adobe.aem.guides.wknd.core.services.PageCreationService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = PageCreationService.class)
public class PageCreationServiceImpl implements PageCreationService{


    private static final Logger log = LoggerFactory.getLogger(PageCreationServiceImpl.class);
    @Override
    public void getPageCreation(ResourceResolver resourceResolver,String parentPath, String pageName, String templatePath, String pageTitle) {

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

        try {

            Page page = pageManager.create(parentPath,pageName,templatePath,pageTitle);

            resourceResolver.commit();

            log.info("Page Created Successfully");


        }catch (Exception e){
                log.error(e.getMessage());
        }

    }
}
