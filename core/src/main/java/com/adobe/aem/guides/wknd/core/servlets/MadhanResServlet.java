package com.adobe.aem.guides.wknd.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "wknd/components/madhan/madhanTest",
        methods = "GET",
        selectors = "madhan",
        extensions = "html"
)
public class MadhanResServlet extends SlingSafeMethodsServlet {


    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException{

        response.getWriter().write("HI Mahdan your get method is working from Resource based servlet");
    }
}

/*
*  @Component(service=Servlet.class, property ={
*
*       "sling.servlet.resourceTypes=wknd/components/madhan/madhanTest",
*       "sling.servlet.methods=GET",
*       "sling.servlet.selectors=madhan",
*       "sling.servlet.extensions=html"
* })
*
*
*
 */
