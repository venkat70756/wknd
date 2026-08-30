package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.ResourceUtil;
import com.adobe.aem.guides.wknd.core.services.Venkat;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Venkat.class)

public class VenkatImpl implements Venkat {

    private static final Logger log = LoggerFactory.getLogger(VenkatImpl.class);

    @Reference
    ResourceUtil resourceUtil;

    @Override
    public void getAccessingResource(String path) {
        log.info("inside access method ");

        try (ResourceResolver resourceResolver = resourceUtil.getResolver()){

            log.info("inside try block");

            Resource resource = resourceResolver.getResource(path + "/jcr:content");

            log.info("Resource: {}", resource);

            log.info("After got resource");

            if (resource != null){

                log.info("inside the resource");

                ValueMap valueMap = resource.getValueMap();

                String author = valueMap.get("author", String.class);

                log.info(author);
            }



        } catch (LoginException e) {
           log.error("Exception: {}", e);
        }

    }
}
