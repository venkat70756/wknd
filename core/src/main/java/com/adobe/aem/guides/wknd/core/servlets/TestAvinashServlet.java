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
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws  ServletException, IOException{
        log.info("do Post method triggered ");
    }

}
