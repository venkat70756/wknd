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
        resourceTypes = "wknd/components/teaser",
        methods = "GET",
        selectors = "yl",
        extensions = "html"
)


//AEM 6.5
//@Component(service = Servlet.class, property = {
//        "sling.servlet.resourceTypes= wknd/components/teaser ",
//        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
//        "sling.servlet.selectors=yl",
//        "sling.servlet.extensions=html"
//})
public class DemoResServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");
        response.getWriter().println("<h1>Hello World!</h1>");
    }
}

