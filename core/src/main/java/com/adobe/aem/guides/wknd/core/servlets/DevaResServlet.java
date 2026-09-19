package com.adobe.aem.guides.wknd.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "wknd/components/deva/demo",
        selectors = "deva",
        extensions = "html",
        methods = HttpConstants.METHOD_GET
)

// AEM 6.5 Resource Based Servlet Registration
//@Component(service = Servlet.class, property = {
//        "sling.servlet.resourceTypes=wknd/components/deva/demo",
//        "sling.servlet.selectors=venkat",
//        "sling.servlet.extensions=",
//        "sling.servlet.mehtods=" + HttpConstants.METHOD_GET
//})

public class DevaResServlet extends SlingAllMethodsServlet {


    private static final Logger log = LoggerFactory.getLogger(DevaResServlet.class);


    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException{
        log.info("Resource based servlet got triggered");


        response.getWriter().write("Resource based servlet got triggered");

    }
}
