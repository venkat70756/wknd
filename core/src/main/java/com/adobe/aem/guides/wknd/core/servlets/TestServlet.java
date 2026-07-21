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
import java.io.PrintWriter;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/p/phalguni")

// AEM 6.5
//@Component(service= Servlet.class,
//   property ={
//         "sling.servlet.paths=/bin/yl",
//         "sling.servlet.methods=" + HttpConstants.METHOD_GET,
//   })
public class TestServlet extends SlingAllMethodsServlet {


    private static final Logger log = LoggerFactory.getLogger(TestServlet.class);

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException{
        log.info("TestServlet doGet");
        String name = request.getParameter("name");
        String age = request.getParameter("age");


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        if (age != null) {

            int a = Integer.parseInt(age);

           if (a >= 60 ) {
               out.println("Hi " + name + ", you're eligible for pension");
           }
           else {
               out.println("Hi " + name + ", you're not eligible for pension");
           }
        }else {
            out.println("Please pass the age");
        }


    }

    @Override
    protected void doPost(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException{

        log.info("TestServlet doPost");

    }
}

/*
 * Apis,
 * JSON
 */
