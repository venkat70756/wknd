package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.services.DemoAvinashService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


// AEM cloud Path Based Servlet Registration
@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/testavinash")

// AEM 6.5 and AEM LTS Path Based servlet registration
//@Component(service = Servlet.class, properties = {
//        "sling.servlet.paths=/bin/testavinash"
//})
public class TestAvinashServlet extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(TestAvinashServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        log.info("do Get method Triggered");

        String name = request.getParameter("username");

        String location = request.getParameter("loc");

        log.info("name is : {}", name);

        log.info("Location is : {}", location);

        String searchResults;

        if (name.equals("v") && location.equals("bengaluru")){
            searchResults = "Venkat123";
        } else if (name.equals("a")){
            searchResults = "Avinash";
        }
        else {
            searchResults = "user not found";
        }

        log.info("Search Results is: {} ", searchResults);

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();

        printWriter.println("Search Results: " + searchResults);


    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws  ServletException, IOException{
        log.info("do Post method triggered ");
    }

}
