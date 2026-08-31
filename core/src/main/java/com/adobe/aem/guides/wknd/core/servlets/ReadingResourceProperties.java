package com.adobe.aem.guides.wknd.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/readProperties")
public class ReadingResourceProperties extends SlingSafeMethodsServlet {


    private static final Logger log = LoggerFactory.getLogger(ReadingResourceProperties.class);


    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {

        ResourceResolver resourceResolver = request.getResourceResolver();

        Resource resource = resourceResolver.getResource("/content/wknd/us/en/test10/jcr:content");

        log.info(resource.getName());

        log.info(resource.getPath());

        log.info(resource.getResourceSuperType());

        log.info(resource.getResourceType());

//        log.info(resource.getChildren());

        log.info(resource.getParent().getParent().getName().toUpperCase());


        ValueMap valueMap = resource.adaptTo(ValueMap.class);

        log.info(valueMap.get("writer").toString());



    }
}
