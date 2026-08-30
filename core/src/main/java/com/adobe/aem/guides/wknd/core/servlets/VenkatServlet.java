package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.services.Venkat;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/venkat")
public class VenkatServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(VenkatServlet.class);

    @Reference
    Venkat venkat;


    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException{


        ResourceResolver resourceResolver = request.getResourceResolver();
        log.info("Servlet get method triggered");
        String path = request.getParameter("path");

       venkat.getAccessingResource(path);

       log.info("Method called succesfully");

    }
}
