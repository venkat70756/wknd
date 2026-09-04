package com.adobe.aem.guides.wknd.core.services;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;

@Component(service = ResourceUtil.class)
public class ResourceUtil {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    public ResourceResolver getResolver() throws LoginException{

        Map<String, Object> param = new HashMap<>();
        param.put(ResourceResolverFactory.SUBSERVICE, "venkat-backend");

        return resourceResolverFactory.getServiceResourceResolver(param);

    }
}
