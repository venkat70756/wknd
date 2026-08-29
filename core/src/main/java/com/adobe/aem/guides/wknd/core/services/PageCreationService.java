package com.adobe.aem.guides.wknd.core.services;

import org.apache.sling.api.resource.ResourceResolver;

import java.security.PublicKey;

public interface PageCreationService {

    public void getPageCreation(ResourceResolver resourceResolver, String parentPath, String pageName, String templatePath, String pageTitle);


}
