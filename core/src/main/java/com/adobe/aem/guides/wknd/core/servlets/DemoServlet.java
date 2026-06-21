package com.adobe.aem.guides.wknd.core.servlets;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@Component(service = Servlet.class)
//R7 annotations
@SlingServletPaths("/bin/yl")


// AEM 6.5
//@Component(service= Servlet.class,
//   property ={
//         "sling.servlet.paths=/bin/yl",
//         "sling.servlet.methods=" + HttpConstants.METHOD_GET,
//   })
public class DemoServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(DemoServlet.class);


    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{

        String pagePath = request.getParameter("pagePath");

        ResourceResolver resolver = request.getResourceResolver();

        Resource resource = resolver.getResource(pagePath + "/jcr:content");

        log.info("DemoServlet Get Method Called");

        log.info(resource.getPath());
        log.info(resource.getName());

        log.info(resource.getValueMap().get("pageTitle").toString());

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

    }

}


