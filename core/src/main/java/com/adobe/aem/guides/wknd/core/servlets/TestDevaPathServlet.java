package com.adobe.aem.guides.wknd.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/deva")

//aem 6.5 path based servlet registration
//@Component(service = Servlet.class, options={
//        "sling.servlet.paths=/bin/deva"
//})

public class TestDevaPathServlet extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(TestDevaPathServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        log.info("Do get Triggered");
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response){
        log.info("Do Post Triggered");
    }

}
