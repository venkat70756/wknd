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
@SlingServletPaths(value = "/bin/madhan/m/123")
public class MadhanServlet extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(MadhanServlet.class);



    @Override
    protected void doGet( final SlingHttpServletRequest request,  final SlingHttpServletResponse response) throws ServletException, IOException{

        String userName = request.getParameter("name");

        String userAge = request.getParameter("age");

        if (userName != null){
            log.info("Hi {} and you're age is : {} ", userName, userAge );
        }else {
            log.warn("Please send the name queryparams");
        }

        response.setContentType("applicaiton/json");
        response.getWriter().write("HI " + userName  +", your get method is working");

    }

    @Override
    protected void doPost( final SlingHttpServletRequest  request, final SlingHttpServletResponse response) throws ServletException, IOException{
        log.info("Do Post method triggered from Madhan servlet");
    }

}


/*
 * @SlingServletPaths() --> it will define the Path based servlet in AEM as a cloud
 * @SlingServletResourceTypes() --> it will define the Resource Based servlet in AEM as a cloud
 *
 *
 *
 *
 * Path based servlet registration on the AEM 6.5 and LTS
 *
 * @Component(service = Servlet.class, properties = {
 *      "sling.servlet.paths=/bin/madhan"
 *  })
 */