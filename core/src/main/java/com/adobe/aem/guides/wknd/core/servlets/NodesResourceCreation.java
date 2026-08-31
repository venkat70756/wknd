package com.adobe.aem.guides.wknd.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/nodeCreation")
public class NodesResourceCreation extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(NodesResourceCreation.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{


        ResourceResolver resourceResolver = request.getResourceResolver();

        Resource resource = resourceResolver.getResource("/content/wknd/us/en/test10/jcr:content");

        Map<String, Object> props = new HashMap<>();
        props.put("name", "Avinash");
        props.put("role", "AEM Developer");
        props.put("location", "pune");

        if (resource != null) {
            resourceResolver.create(resource, "avinash-backend", props);

            if (resourceResolver.hasChanges()){
                resourceResolver.commit();
                log.info("Resource has been created");
            }
        }else {
            log.error("Resource is Null");
        }
    }
}
